package com.epam.publicenemies.web.casino.blackjack;

/**
 * @author Danylo_Batyuk
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
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
import com.google.gson.Gson;

@Controller
public class RecoveryForBlackJackGame {
	private Logger log = Logger.getLogger(RecoveryForBlackJackGame.class);

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

	@RequestMapping("/checkForBlackJackGame")
	public void check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Get game
		BlackJackGame game = games.getGameById(userId);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(game));
		out.flush();

	}

	@RequestMapping("/BlackJackGame")
	public ModelAndView empty(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("BLACKJACK TABLE WAS CREATED");
		// Get game
		Integer userId = (Integer) request.getSession().getAttribute("userId");
		BlackJackGame game = games.getGameById(userId);
		Profile profile = profileManagerService.getProfileByUserId(userId);
		
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("player_avatar", profile.getAvatar());
		objects.put("player_nickname", profile.getNickName());
		objects.put("chips", game.getChips());
		
		return new ModelAndView("blackJackGame",objects);
	}
}
