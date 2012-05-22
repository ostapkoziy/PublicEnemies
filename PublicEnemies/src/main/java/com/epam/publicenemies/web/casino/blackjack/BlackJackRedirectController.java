package com.epam.publicenemies.web.casino.blackjack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Danylo Batyuk
 */
@Controller
public class BlackJackRedirectController {

	
	@RequestMapping("/blackJackGame.html")
	public String blackJackGame()
	{
		return "blackJackGame";
	}
}
