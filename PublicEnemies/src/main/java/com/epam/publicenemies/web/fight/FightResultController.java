package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
@Controller
public class FightResultController
{
	@RequestMapping("/fightResult.html")
	public ModelAndView fightResault(HttpServletRequest request, HttpServletResponse response)
	{
		/*
		 * OLD GAME
		 */
		Fight fight = (Fight) request.getSession().getAttribute("game");
		String role = (String) request.getSession().getAttribute("gameRole");
		Utils.isOldGameInSession(fight, role);
		/*
		 * TODO ADD INFO WIN AND LOSE GAMES
		 */
		ModelAndView mav = new ModelAndView("/fight/fightResult");
		if (role.equals("creator"))
		{
			if (fight.getWhoWins().equals(role))
			{
			}
			else
			{
			}
		}
		else
		{
			if (fight.getWhoWins().equals(role))
			{
			}
			else
			{
			}
		}
		return mav;
	}
}
