package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.fight.Fight;

/**
 * @author Alexander Ivanov
 */
@Controller
public class FightResultController
{
	@RequestMapping("/fightResult.html")
	public ModelAndView fightResault(HttpServletRequest request, HttpServletResponse response)
	{
		Fight fight = (Fight) request.getSession().getAttribute("game");
		String role = (String) request.getSession().getAttribute("gameRole");
		ModelAndView mav = new ModelAndView("/fight/fightResult");
		if (fight.getWhoWins() == null)
		{
			request.getSession().setAttribute("win", false);
			mav.addObject("myProfile", fight.getProfile(role));
			return mav;
		}
		if (fight.getProfile(role).getUserId() == fight.getWhoWins().getUserId())
		{
			mav.addObject("myProfile", fight.getWhoWins());
			request.getSession().setAttribute("win", true);
		}
		else
		{
			mav.addObject("myProfile", fight.getWhoLoses());
			request.getSession().setAttribute("win", false);
		}
		return mav;
	}
}
