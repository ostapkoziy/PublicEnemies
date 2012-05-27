package com.epam.publicenemies.web.fight;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
@Controller
public class RedirectController2
{
	@RequestMapping("/fightStarted.html")
	public String gameStarted()
	{
		return "/fight/fightStarted";
	}
	@RequestMapping("/fight.html")
	public String fight(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		if (id == null)
		{
			return "redirect:fights.html";
		}
		Fight fight = Utils.findGameById(new Long(id));
		if (fight == null)
		{
			return "redirect:fights.html";
		}
		return "/fight/fight";
	}
}
