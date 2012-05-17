package com.epam.publicenemies.web.casino.blackjack;

import org.apache.log4j.Logger;

public class DoubleDownBlackJackController {
	private Logger log = Logger.getLogger(StartBlackJackController.class);
	
	private Deck deck;
	

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
