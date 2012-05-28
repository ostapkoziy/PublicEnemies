package com.epam.publicenemies.web.casino.blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.blackjack.BlackJackRound;
import com.google.gson.Gson;

public class DoubleBlackJackController {
	private static Logger log = Logger.getLogger(DoubleBlackJackController.class);

	@Autowired
	@Qualifier("games")
	private BlackJackGameList games;

	public void setGames(BlackJackGameList games) {
		this.games = games;
	}

	@Autowired
	@Qualifier("deck")
	private BlackJackDeck deck;

	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}

	@Autowired
	@Qualifier("engine")
	private BlackJackEngine engine;

	public void setEnhine(BlackJackEngine engine) {
		this.engine = engine;
	}

	@RequestMapping("/DoubleBlackJackController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Get game
		BlackJackGame game = games.getGameById(userId);
		BlackJackRound round = game.getRound();

		// Take 1 card for player
		List<BlackJackCard> playerCards = round.getPlayerCards();
		playerCards.add(deck.getCard());

		// Calculate player points
		int playerPoints = engine.calculatePoints(playerCards);

		// Check result
		String playerResult = engine.checkResult(playerPoints);

		// Set round
		round.setPlayerCards(playerCards);
		round.setPlayerPoints(playerPoints);
		round.setPlayerResult(playerResult);

		// Round to json
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(round));
		out.flush();
	}
}
