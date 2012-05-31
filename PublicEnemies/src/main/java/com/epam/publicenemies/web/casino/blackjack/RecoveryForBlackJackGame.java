package com.epam.publicenemies.web.casino.blackjack;

/**
 * @author Danylo_Batyuk
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.google.gson.Gson;

@Controller
public class RecoveryForBlackJackGame {
	private Logger log = Logger.getLogger(RecoveryForBlackJackGame.class);

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
		return new ModelAndView("blackJackGame");
	}
}
