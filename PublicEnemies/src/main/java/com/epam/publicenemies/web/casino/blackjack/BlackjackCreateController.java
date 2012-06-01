package com.epam.publicenemies.web.casino.blackjack;

/**
 * @author Danylo Batyuk
 */

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
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.service.IProfileManagerService;

@Controller
public class BlackjackCreateController {
	private Logger log = Logger.getLogger(BlackjackCreateController.class);

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

	@RequestMapping("/blackJackGame")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		Profile profile = profileManagerService.getProfileByUserId(userId);

		Integer chips = Integer.valueOf(request.getParameter("chips"));
		profileManagerService.updateMoney(userId, profile.getMoney() - chips);

		games.createNewGame(userId, chips);

		log.info("BLACKJACK GAME: " + userId + "  CREATED");
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("player_avatar", profile.getAvatar());
		objects.put("player_nickname", profile.getNickName());
		objects.put("chips", chips);

		return new ModelAndView("blackJackGame", objects);
	}
}
