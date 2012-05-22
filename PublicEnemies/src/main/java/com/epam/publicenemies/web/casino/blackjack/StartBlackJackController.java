package com.epam.publicenemies.web.casino.blackjack;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;
import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.mysql.jdbc.BalanceStrategy;

public class StartBlackJackController extends AbstractController {
	private Logger log = Logger.getLogger(StartBlackJackController.class);

	private BlackJackDeck deck;
	private BlackJackGameList games;

	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}

	public void setGames(BlackJackGameList games) {
		this.games = games;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Get game
		BlackJackGame game = games.getGameById((Integer) request.getSession()
				.getAttribute("userId"));
		// Take one card for dealer
		List<BlackJackCard> dealerCards = new ArrayList<BlackJackCard>();
		dealerCards.add(deck.getCard());
//		game.setDealerCards(dealerCards);
		// Take two cards for player
		List<BlackJackCard> playerCards = new ArrayList<BlackJackCard>();
		for (int i = 0; i < 2; i++) {
			playerCards.add(deck.getCard());
		}
		String split = "disabled=\"disabled\"";
		if (playerCards.get(0).rank().getValue() == playerCards.get(1).rank()
				.getValue())
			split = null;
//		game.setPlayerCards(playerCards);
		// Calculate your points
		int yourPoints = playerCards.get(0).rank().getValue()
				+ playerCards.get(1).rank().getValue();
//		game.setYourPoints(yourPoints);
		// Get your bet
		int bet = Integer.valueOf(request.getParameter("bet"));
//		game.setBet(bet);

		// Get result
		String result = null;
		if (yourPoints == 21) {
			result = "You WIN!!!";
//			game.setChips(game.getChips() + game.getBet());
		}

		// Push it all in map
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("chips", game.getChips());
//		objects.put("dealer_cards", game.getDealerCards());
//		objects.put("player_cards", game.getPlayerCards());
//		objects.put("your_points", game.getYourPoints());
//		objects.put("bet", game.getBet());
		objects.put("result", result);
		objects.put("start_state", "disabled=\"disabled\"");
		objects.put("hit_state", null);
		objects.put("stand_state", null);
		objects.put("doubledown_state", null);
		objects.put("split_state", split);

		return new ModelAndView("blackJackGame", objects);
	}

}
