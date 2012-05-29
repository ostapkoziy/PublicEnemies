package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alexander Ivanov
 */
@Controller
public class FightResultController
{
	@RequestMapping("/fightResult.html")
	public ModelAndView fightResault(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("/fight/fightResult");
		return mav;
	}
}
