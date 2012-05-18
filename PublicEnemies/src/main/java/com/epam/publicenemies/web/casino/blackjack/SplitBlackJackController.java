package com.epam.publicenemies.web.casino.blackjack;

import org.apache.log4j.Logger;

import com.epam.publicenemies.domain.blackjack.BlackJackGame;
import com.epam.publicenemies.domain.blackjack.BlackJackDeck;
import com.epam.publicenemies.domain.blackjack.BlackJackGameList;

public class SplitBlackJackController {
	private Logger log = Logger.getLogger(SplitBlackJackController.class);
	
	private BlackJackDeck deck;
	private BlackJackGameList games;
	public void setDeck(BlackJackDeck deck) {
		this.deck = deck;
	}	
	public void setGames(BlackJackGameList games) {
		this.games = games;
	}
}
