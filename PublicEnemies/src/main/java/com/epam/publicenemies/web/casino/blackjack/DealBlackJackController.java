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
public class DealBlackJackController {
	private static Logger log = Logger.getLogger(DealBlackJackController.class);

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

	@RequestMapping("/DealBlackJackController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		// Get player bet
		Integer playerBet = Integer.valueOf(request.getParameter("playerBet"));
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Take 2 cards for player
		List<BlackJackCard> playerCards = new ArrayList<BlackJackCard>();
		for (int i = 0; i < 2; i++) {
			playerCards.add(deck.getCard());
		}

		// Calculate player points
		int playerPoints = engine.calculatePoints(playerCards);

		// Take 1 card for dealer
		List<BlackJackCard> dealerCards = new ArrayList<BlackJackCard>();
		dealerCards.add(deck.getCard());

		// Check result
		String playerResult = engine.checkResult(playerPoints);
		
		// Set round
		BlackJackRound round = new BlackJackRound();
		round.setPlayerBet(playerBet);
		round.setPlayerCards(playerCards);
		round.setPlayerPoints(playerPoints);
		round.setDealerCards(dealerCards);
		round.setPlayerResult(playerResult);

		// Get game
		BlackJackGame game = games.getGameById(userId);
		game.setRound(round);

		// Round to json
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(round));
		out.flush();
	}
}
