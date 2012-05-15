package com.epam.publicenemies.web.fight;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Karamba
 */
@Controller
public class RedirectController2
{
	@RequestMapping("/gameStarted.html")
	public String gameStarted()
	{
		return "gameStarted";
	}
	@RequestMapping("/lose.html")
	public String lose()
	{
		return "lose";
	}
	@RequestMapping("/resault.html")
	public String resaultPage()
	{
		return "resault";
	}
	@RequestMapping("/win.html")
	public String win()
	{
		return "win";
	}
	@RequestMapping("/fight.html")
	public String fight()
	{
		return "fight";
	}
}
