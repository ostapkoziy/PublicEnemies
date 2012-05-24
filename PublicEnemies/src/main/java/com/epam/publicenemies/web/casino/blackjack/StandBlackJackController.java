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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.blackjack.BlackJackRound;
import com.google.gson.Gson;

@Controller
public class StandBlackJackController {
	private static Logger log = Logger
			.getLogger(StandBlackJackController.class);

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

	@RequestMapping("/StandBlackJackController")
	public void deal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Get game
		BlackJackGame game = games.getGameById(userId);
		BlackJackRound round = game.getRound();

		// Take cards for dealer
		List<BlackJackCard> dealerCards = round.getDealerCards();
		int dealerPoints = 0;
		do {
			dealerCards.add(deck.getCard());
			dealerPoints = engine.calculatePoints(dealerCards);
		} while (dealerPoints < 17);

		// Check result
		String playerResult = engine.checkResult(round.getPlayerPoints(),
				dealerPoints);

		// Set round
		round.setDealerCards(dealerCards);
		round.setPlayerResult(playerResult);

		// Round to json
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(round));
		out.flush();

	}
}
