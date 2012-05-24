package com.epam.publicenemies.web.fight;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightEngine;

/**
 * @author Alexander Ivanov
 */
@Controller
public class HitServlet
{
	private static Logger	log	= Logger.getLogger(HitServlet.class);
	@RequestMapping("/HitServlet")
	public void hit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		String role = request.getSession().getAttribute("gameRole").toString();
		Fight fight = (Fight) request.getSession().getAttribute("game");
		String hit = new String(request.getParameter("userHit"));
		String block = request.getParameter("userBlock");
		Profile userProfile;
		/*
		 * 
		 */
		if (role.equals("creator"))
		{
			userProfile = fight.getCreatorProfile();
			log.info("CREATOR: " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			user1GameSetup(fight, hit, block, role);
		}
		else
		{
			userProfile = fight.getConnectorProfile();
			log.info("CONNECT: " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			user2GameSetup(fight, hit, block, role);
		}
		/*
		 * Engine Start
		 */
		startEngine(fight);
		/*
		 * 
		 */
	}
	/**
	 * Можна буде забрати якщо передавати в ENGINE того хто стартанув гру(він
	 * вдарив другим). Add STATIC
	 */
	protected static synchronized void setFirstHit(Fight fight, String role)
	{
		if (fight.getRound().getFirstHit().equals(""))
		{
			fight.getRound().setFirstHit(role);
		}
	}
	protected static synchronized void startEngine(Fight fight)
	{
		if (!fight.getRound().isRoundStart())
		{
			new FightEngine().startEngine(fight);
		}
	}
	protected static void user1GameSetup(Fight fight, String hit, String block, String role)
	{
		fight.getRound().setUser1Hit(hit);
		fight.getRound().setUser1Block(block);
		fight.getRound().setU1Hit(true);
		if (fight.getRound().isU2Hit())
		{
			log.info("AND END ROUND №" + fight.getRound().getRoundNumber());
			fight.getRound().setRoundStart(false);
		}
		else
		{
			setFirstHit(fight, role);
		}
	}
	protected static void user2GameSetup(Fight fight, String hit, String block, String role)
	{
		fight.getRound().setUser2Hit(hit);
		fight.getRound().setUser2Block(block);
		fight.getRound().setU2Hit(true);
		if (fight.getRound().isU1Hit())
		{
			log.info("AND END ROUND №" + fight.getRound().getRoundNumber());
			fight.getRound().setRoundStart(false);
		}
		else
		{
			setFirstHit(fight, role);
		}
	}
}
