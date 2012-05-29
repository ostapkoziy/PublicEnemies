package com.epam.publicenemies.web.casino.blackjack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.blackjack.BlackJackRound;
import com.google.gson.Gson;

@Controller
public class SplitBlackJackController {
	private static Logger log = Logger
			.getLogger(SplitBlackJackController.class);

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

	@RequestMapping("/splitBlackJackController")
	public void split(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Get game
		BlackJackGame game = games.getGameById(userId);
		BlackJackRound round = game.getRound();

		// New list of cards
		List<BlackJackCard> playerCards = round.getPlayerCards();
		List<BlackJackCard> playerCardsSplit = new ArrayList<BlackJackCard>();
		playerCardsSplit.add(playerCards.get(1));
		playerCards.remove(1);
		
		// Calculate player points
		int playerPoints = engine.calculatePoints(playerCardsSplit);

		// Set round
		round.setPlayerCards(playerCards);
		round.setPlayerCardsSplit(playerCardsSplit);
		round.setPlayerPoints(playerPoints);

		// Game to json
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(game));
		out.flush();
	}
}
