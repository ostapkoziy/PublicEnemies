package com.epam.publicenemies.domain.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.publicenemies.domain.blackjack.BlackJackCard.Rank;
import com.epam.publicenemies.domain.blackjack.BlackJackCard.Suit;


public class BlackJackDeck {
	private List<BlackJackCard> deck;
	
	public BlackJackDeck(){
		deck = new ArrayList<BlackJackCard>();
		for (Suit suit : Suit.values())
			for (Rank rank : Rank.values())
				deck.add(new BlackJackCard(rank, suit));
	}
	
	public BlackJackCard getCard(){
		Random rand = new Random();
		BlackJackCard card = deck.get(rand.nextInt(52));
		return card;
	}
}
