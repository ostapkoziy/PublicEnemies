package com.epam.publicenemies.web.casino.blackjack;

import org.apache.log4j.Logger;

public class StandBlackJackController {
	private Logger log = Logger.getLogger(StartBlackJackController.class);
	
	private Deck deck;
	

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}