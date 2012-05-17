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

public class HitBlackJackController extends AbstractController{
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
		// Take one card for player
		List<BlackJackCard> playerCards = new ArrayList<BlackJackCard>();
		playerCards.add(deck.getCard());
		game.setPlayerCards(playerCards);
		// Calculate your points
		int yourPoints = playerCards.get(0).rank().getValue()
				+ playerCards.get(1).rank().getValue();
		game.setYourPoints(yourPoints);
		// Get your bet
		int bet = Integer.valueOf(request.getParameter("bet"));
		game.setBet(bet);
		// Push it all in map
		Map<String, String> objects = new HashMap<String, String>();
		objects.put("chips", String.valueOf(game.getChips()));
		objects.put("dealer_card0", dealerCards.get(0).image());
		objects.put("player_card0", playerCards.get(0).image());
		objects.put("player_card1", playerCards.get(1).image());
		objects.put("your_points", String.valueOf(yourPoints));
		objects.put("bet", String.valueOf(bet));

		return new ModelAndView("blackJackGame", objects);

	}
	
}
