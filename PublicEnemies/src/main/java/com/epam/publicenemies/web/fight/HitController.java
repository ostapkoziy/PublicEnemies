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
public class HitController
{
	private static Logger	log	= Logger.getLogger(HitController.class);
	@RequestMapping("/HitController")
	public void hit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		String role = request.getSession().getAttribute("gameRole").toString();
		Fight fight = (Fight) request.getSession().getAttribute("game");
		String hit = new String(request.getParameter("userHit"));
		String block = request.getParameter("userBlock");
		// String useAid = request.getParameter("aidUse");
		Profile userProfile = fight.getProfile(role);
		/*
		 * 
		 */
		if (role.equals("creator"))
		{
			log.info("CREATOR: " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			creatorGameSetup(fight, hit, block, role);
		}
		else
		{
			log.info("CONNECT: " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			connectorGameSetup(fight, hit, block, role);
		}
		/*
		 * Engine Start
		 */
		startEngine(fight, role);
	}
	/**
	 * 
	 * @param fight
	 *            - fight)
	 * @param role
	 *            - who starts the fight engine(second hit)
	 */
	private synchronized void startEngine(Fight fight, String role)
	{
		if (!fight.getRound().isRoundStart())
		{
			FightEngine engine = fight.getEngine();
			engine.startEngine(fight, role);
			engine.setStarted(true);
		}
	}
	private void creatorGameSetup(Fight fight, String hit, String block, String role)
	{
		fight.getRound().setCreatorHit(hit);
		fight.getRound().setCreatorBlock(block);
		fight.getRound().setCreatorDoHit(true);
		if (fight.getRound().isConnectorDoHit())
		{
			setRoundStart(fight);
		}
	}
	private void connectorGameSetup(Fight fight, String hit, String block, String role)
	{
		fight.getRound().setConnectorHit(hit);
		fight.getRound().setConnectorBlock(block);
		fight.getRound().setConnectorDoHit(true);
		if (fight.getRound().isCreatorDoHit())
		{
			setRoundStart(fight);
		}
	}
	private synchronized void setRoundStart(Fight fight)
	{
		if (fight.getRound().isRoundStart())
		{
			log.info("AND END ROUND №" + fight.getRound().getRoundNumber());
			fight.getRound().setRoundStart(false);
		}
	}
}
