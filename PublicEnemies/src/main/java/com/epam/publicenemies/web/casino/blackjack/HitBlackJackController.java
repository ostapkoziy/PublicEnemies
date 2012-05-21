package com.epam.publicenemies.web.casino.blackjack;

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
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;

public class HitBlackJackController extends AbstractController {
	private Logger log = Logger.getLogger(HitBlackJackController.class);

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
		// Take one card for player
		List<BlackJackCard> playerCards = game.getPlayerCards();
		playerCards.add(deck.getCard());
		game.setPlayerCards(playerCards);
		// Get index of last card
		int index = game.getPlayerCards().size() - 1;
		// Calculate your points
		int yourPoints = game.getYourPoints()
				+ playerCards.get(index).rank().getValue();
		game.setYourPoints(yourPoints);
		// Get result
		String result = null;
		if (yourPoints == 21) {
			result = "You WIN!!!";
			game.setChips(game.getChips() + game.getBet());
			
		} else if (yourPoints > 21) {
			result = "You LOSE!!!";
			game.setChips(game.getChips() - game.getBet());
		}

		// Push it all in map
		Map<String, Object> objects = new HashMap<String, Object>();
		objects.put("chips", game.getChips());
		objects.put("dealer_cards", game.getDealerCards());
		objects.put("player_cards", game.getPlayerCards());
		objects.put("your_points", game.getYourPoints());
		objects.put("bet", game.getBet());
		objects.put("result", result);
		objects.put("start_state", "disabled=\"disabled\"");
		objects.put("split_state", "disabled=\"disabled\"");


		return new ModelAndView("blackJackGame", objects);

	}
}
