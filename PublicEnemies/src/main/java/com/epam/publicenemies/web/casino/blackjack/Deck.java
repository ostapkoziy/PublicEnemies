package com.epam.publicenemies.web.casino.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.epam.publicenemies.web.casino.blackjack.Card.Rank;
import com.epam.publicenemies.web.casino.blackjack.Card.Suit;

public class Deck {
	private List<Card> deck;
	
	public Deck(){
		deck = new ArrayList<Card>();
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				deck.add(new Card(rank, suit));
	}
	
	public Card getCard(){
		Card card = deck.get(10);
		return card;
	}
}
