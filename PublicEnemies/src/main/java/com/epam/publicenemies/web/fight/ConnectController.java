package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
@Controller
public class ConnectController
{
	private Logger					log	= Logger.getLogger(ConnectController.class);
	@Autowired
	private IProfileManagerService	profileManagerService;
	@RequestMapping("/connect.html")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		/*
		 * SETUP OLD GAME
		 */
		Fight oldFight = (Fight) request.getSession().getAttribute("game");
		String oldRole = (String) request.getSession().getAttribute("gameRole");
		/*
		 * NEW GAME
		 */
		long newFightId = new Long(request.getParameter("gameId"));
		Fight newFight = Utils.findGameById(newFightId);
		if (newFight.isGameStarted())
		{
			// КОЛИ ГРА СТАРТАНУЛА
			return "redirect:fightStarted.html";
		}
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		if (newFight.getCreatorProfile().getUserId() == userProfile.getUserId())
		{
			// ПРИ КОНЕКТІ ДО СЕБЕ
			return "redirect:fight.html";
		}
		Utils.isOldGameInSession(oldFight, oldRole);
		/*
		 * GAME_SETUP
		 */
		log.info(userProfile.getNickName() + " CONNECT TO GAME: " + newFight.getId());
		newFight.setGameStarted(true);
		newFight.setConnectorOnline(true);
		newFight.setConnectorProfile(userProfile);
		newFight.getRound().setRoundBeginTime(System.currentTimeMillis() / 1000);
		StatsCalculator.makeStats(newFight, "connector");
		/*
		 * SESSION_CONFIG
		 */
		request.getSession().setAttribute("gameRole", "connector");
		request.getSession().setAttribute("game", newFight);
		return "redirect:fight.html";
	}
}
