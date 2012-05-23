package com.epam.publicenemies.web.fight;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alexander Ivanov
 */
@Controller
public class RedirectController2
{
	@RequestMapping("/gameStarted.html")
	public String gameStarted()
	{
		return "/fight/gameStarted";
	}
	@RequestMapping("/lose.html")
	public String lose()
	{
		return "/fight/lose";
	}
	@RequestMapping("/resault.html")
	public String resaultPage()
	{
		return "/fight/resault";
	}
	@RequestMapping("/win.html")
	public String win()
	{
		return "/fight/win";
	}
	@RequestMapping("/fight.html")
	public String fight()
	{
		return "/fight/fight";
	}
	//TODO DELETE THIS
	@RequestMapping("/mod.html")
	public String mod()
	{
		return "/fight/mod";
	}
}
