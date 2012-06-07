package com.epam.publicenemies.web.fight;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
@Controller
public class FightResultController
{
	@Autowired
	private IProfileManagerService	profileManagerService;
	@RequestMapping("/fightResult.html")
	public ModelAndView fightResault(HttpServletRequest request, HttpServletResponse response)
	{
		Fight fight = (Fight) request.getSession().getAttribute("game");
		String role = (String) request.getSession().getAttribute("gameRole");
		ModelAndView mav = new ModelAndView("/fight/fightResult");
		Profile profile = fight.getProfile(role);
		profileManagerService.updateTotalFights(profile.getProfileId(), profile.getFightsTotal() + 1);
		if (fight.getWhoWins() == null || (profile.getUserId() != fight.getWhoWins().getUserId()))
		{
			request.getSession().setAttribute("win", false);
		}
		else
		{
			/*
			 * Work with DB
			 */
			profileManagerService.updateExperience(profile.getUserId(), profile.getLevel().getAllExpirience());
			profileManagerService.updateMoney(profile.getUserId(), profile.getMoney() + new Random().nextInt(50) + 50
					* profile.getLevel().getCurrentLevel());
			profileManagerService.updateWonFights(profile.getProfileId(), profile.getFightsWon() + 1);
			/*
			 * 
			 */
			int oldLvl = profile.getLevel().getCurrentLevel();
			Utils.expAnalizer(profile.getLevel());
			Utils.isNewLevel(profile.getLevel(), oldLvl, profile.getLevel().getCurrentLevel());
			/*
			 * SESSION CONFIG
			 */
			request.getSession().setAttribute("win", true);
		}
		mav.addObject("myProfile", profile);
		return mav;
	}
}
