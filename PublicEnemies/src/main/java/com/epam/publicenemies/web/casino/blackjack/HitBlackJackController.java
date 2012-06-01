package com.epam.publicenemies.web.casino.blackjack;

/**
 * @author Danylo_Batyuk
 */

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
public class HitBlackJackController {
	private static Logger log = Logger.getLogger(HitBlackJackController.class);

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

	@RequestMapping("/hitBlackJackController")
	public void hit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// Get userId
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		// Get game
		BlackJackGame game = games.getGameById(userId);
		BlackJackRound round = game.getRound();

		// Take 1 card for player
		List<BlackJackCard> playerCards;
		if (round.getPlayerCardsSplit() == null) {
			playerCards = round.getPlayerCards();
		} else {
			playerCards = round.getPlayerCardsSplit();
		}
		playerCards.add(deck.getCard());

		// Calculate player points
		int playerPoints = engine.calculatePoints(playerCards);

		// Check result
		String playerResult = engine.checkResult(playerPoints);
		game.setChips(engine.updateChips(playerResult, game.getChips(),
				round.getPlayerBet()));

		// Set round
		round.setPlayerPoints(playerPoints);
		if (round.getPlayerCardsSplit() == null) {
			round.setPlayerResult(playerResult);
		} else {
			round.setPlayerResultSplit(playerResult);
		}

		// Round to json
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

		out.print(gson.toJson(game));
		out.flush();

		if (playerResult != null) {
			round.setPlayerCardsSplit(null);
		}
		log.info("HIT WAS DONE IN BLACKJACK GAME " + userId);
	}
}