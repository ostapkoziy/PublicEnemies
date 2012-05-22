package com.epam.publicenemies.web.casino.poker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ostap Koziy
 */
@Controller
public class RedirectController3 {

	
	@RequestMapping("/pokerGame.html")
	public String pokerGame()
	{
		return "pokerGame";
	}
}
