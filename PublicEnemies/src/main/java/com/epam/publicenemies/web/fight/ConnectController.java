package com.epam.publicenemies.web.fight;

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
	@Qualifier("profileManagerService")
	private IProfileManagerService	profileManagerService;
	public void setProfileManagerService(IProfileManagerService profileManagerService)
	{
		this.profileManagerService = profileManagerService;
	}
	@RequestMapping("/connect.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		long gameId = new Long(request.getParameter("gameId"));
		Fight game = Utils.findGameById(gameId);
		if (game.isGameStarted())
		{
			return new ModelAndView(new RedirectView("gameStarted.html"));
		}
		/*
		 * GAME_SETUP
		 */
		log.info(userProfile.getNickName() + " CONNECT TO GAME: " + game.getId());
		game.setGameStarted(true);
		game.setUser2profile(userProfile);
		game.getRound().setRoundBeginTime(System.currentTimeMillis());
		/*
		 * SESSION_CONFIG
		 */
		request.getSession().setAttribute("gameRole", "connector");
		request.getSession().setAttribute("game", game);
		ModelAndView mav = new ModelAndView(new RedirectView("fight.html"));
		return mav;
	}
}
