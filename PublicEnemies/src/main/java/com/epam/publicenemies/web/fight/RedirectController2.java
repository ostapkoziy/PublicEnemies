package com.epam.publicenemies.web.fight;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "/fight/fight";
	}
	@RequestMapping("/saveResults.html")
	public String trololo(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		return "redirect:fightResult.html";
	}
}
