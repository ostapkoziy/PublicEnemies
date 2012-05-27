package com.epam.publicenemies.web.fight;

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
	public String fight()
	{
		return "/fight/fight";
	}
}
