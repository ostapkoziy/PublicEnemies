package com.epam.publicenemies.web.casino.blackjack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.service.IProfileManagerService;

@Controller
public class ExitBlakcJackController {
	private static Logger log = Logger.getLogger(ExitBlakcJackController.class);
	@Autowired
	private IProfileManagerService profileManagerService;

	public void setProfileManagerService(
			IProfileManagerService profileManagerService) {
		this.profileManagerService = profileManagerService;
	}

	@Autowired
	@Qualifier("games")
	private BlackJackGameList games;

	public void setGames(BlackJackGameList games) {
		this.games = games;
	}

	@RequestMapping("/exitBlackJackController")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile profile = profileManagerService.getProfileByUserId(userId);

		BlackJackGame game = games.getGameById(userId);

		profileManagerService.updateMoney(userId,
				profile.getMoney() + game.getChips());

		log.info("BLACKJACK GAME: " + userId + "  DESTROYED");

		games.removeGame(userId);
		return new ModelAndView("userStartPage");
	}
}