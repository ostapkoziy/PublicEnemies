package com.epam.publicenemies.web.fight;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.service.IProfileManagerService;

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
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	@RequestMapping("/createGame.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		Fight game = new Fight();
		game.setId(new Random().nextInt());
		game.setUser1profile(userProfile);
		FightsList.newInstanse().getMap().put(game.getId(), game);
		/*
		 * SESSION_SETUP
		 */
		log.info("GAME: " + game.getId() + "  CREATED");
		request.getSession().setAttribute("gameRole", "creator");
		request.getSession().setAttribute("game", game);
		ModelAndView mav = new ModelAndView(new RedirectView("fight.html"));
		return mav;
	}
}
