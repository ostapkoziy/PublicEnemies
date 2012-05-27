package com.epam.publicenemies.web.fight;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
@Controller
public class CreateGameController
{
	private Logger					log	= Logger.getLogger(CreateGameController.class);
	@Autowired
	private IProfileManagerService	profileManagerService;
	@RequestMapping("/createGame.html")
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		/*
		 * SETUP OLD GAME
		 */
		Fight oldFight = (Fight) request.getSession().getAttribute("game");
		String oldRole = (String) request.getSession().getAttribute("gameRole");
		Utils.isOldGameInSession(oldFight, oldRole);
		/*
		 * NEW GAME SETUP
		 */
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		Fight newFight = new Fight();
		newFight.setId(new Random().nextInt());
		newFight.setCreatorProfile(userProfile);
		/*
		 * Make stats
		 */
		StatsCalculator.makeStats(newFight, "creator");
		FightsList.newInstanse().getMap().put(newFight.getId(), newFight);
		/*
		 * SESSION_SETUP
		 */
		log.info("GAME: " + newFight.getId() + "  CREATED");
		request.getSession().setAttribute("gameRole", "creator");
		request.getSession().setAttribute("game", newFight);
		return "redirect:fight.html";
	}
}
