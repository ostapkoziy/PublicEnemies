package com.epam.publicenemies.domain.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.publicenemies.domain.blackjack.Card.Rank;
import com.epam.publicenemies.domain.blackjack.Card.Suit;


public class Deck {
	private List<Card> deck;
	
	public Deck(){
		deck = new ArrayList<Card>();
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				deck.add(new Card(rank, suit));
	}
	
	public Card getCard(){
		Random rand = new Random();
		Card card = deck.get(rand.nextInt());
		return card;
	}
}
