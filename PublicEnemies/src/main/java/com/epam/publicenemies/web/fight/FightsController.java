package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
@Controller
public class FightsController
{
	@Autowired
	private IProfileManagerService	profileManagerService;
	@RequestMapping("/fights.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		FightsList gl = FightsList.newInstanse();
		ModelAndView mav = new ModelAndView("/fight/fights");
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		mav.addObject("profileInfo", userProfile);
		mav.addObject("list", gl.getNotStartedGames());
		return mav;
	}
	@RequestMapping("/fightStarted.html")
	public ModelAndView fightStarted(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		FightsList gl = FightsList.newInstanse();
		ModelAndView mav = new ModelAndView("/fight/fights");
		Profile userProfile = profileManagerService.getProfileByUserId((Integer) request.getSession().getAttribute("userId"));
		mav.addObject("profileInfo", userProfile);
		mav.addObject("list", gl.getNotStartedGames());
		mav.addObject("gameStarted", "GAME IS STARTED");
		return mav;
	}
}
