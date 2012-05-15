package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.fight.GamesList;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
@Controller
public class JoinController
{
	@RequestMapping("/allGames.html")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		GamesList gl = GamesList.newInstanse();
		ModelAndView mav = new ModelAndView("allGames");
		mav.addObject("list", gl.getNotStartedGames());
		return mav;
	}
}
