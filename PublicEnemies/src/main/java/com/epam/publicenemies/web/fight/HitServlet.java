package com.epam.publicenemies.web.fight;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Game;
import com.epam.publicenemies.domain.fight.GameEngine;

/**
 * @author Karamba
 */
@Controller
public class HitServlet
{
	private Logger	log	= Logger.getLogger(HitServlet.class);
	@RequestMapping("/HitServlet")
	public void hit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		Profile userProfile;
		String role = request.getSession().getAttribute("gameRole").toString();
		Game game = (Game) request.getSession().getAttribute("game");
		String hit = new String(request.getParameter("userHit"));
		String block = request.getParameter("userBlock");
		/*
		 * 
		 */
		if (role.equals("creator"))
		{
			userProfile = game.getUser1profile();
		}
		else
		{
			userProfile = game.getUser2profile();
		}
		if (request.getSession().getAttribute("gameRole").equals("creator"))
		{
			log.info("USER1 (CREATOR): " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			game.getRound().setUser1Hit(hit);
			game.getRound().setUser1Block(block);
			game.getRound().setU1Hit(true);
			if (game.getRound().isU2Hit())
			{
				log.info("AND END ROUND");
				game.getRound().setRoundStart(false);
			}
		}
		else
		{
			log.info("USER2 (CONNECT): " + userProfile.getNickName() + " HIT : " + hit + " BLOCK: " + block);
			game.getRound().setUser2Hit(hit);
			game.getRound().setUser2Block(block);
			game.getRound().setU2Hit(true);
			if (game.getRound().isU1Hit())
			{
				log.info("AND END ROUND №" + game.getRound().getRoundNumber());
				game.getRound().setRoundStart(false);
			}
		}
		/*
		 * Engine Start
		 */
		if (!game.getRound().isRoundStart())
		{
			GameEngine.startEngine(game);
		}
	}
}
