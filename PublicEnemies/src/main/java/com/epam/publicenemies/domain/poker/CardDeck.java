package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CardDeck {
	private static final CardDeck INSTANCE = new CardDeck();
	private List<PokerCard> deck = new ArrayList<PokerCard>();
	
	private CardDeck(){
		this.initDeck();
		this.shuffleDeck();
	}

	private void initDeck() {
		for(Value i : Value.VALUES){
			deck.add(new PokerCard(Suit.CLUBS,i, false));
			deck.add(new PokerCard(Suit.DIAMONDS,i, false));
			deck.add(new PokerCard(Suit.HEARTS,i, false));
			deck.add(new PokerCard(Suit.SPADES,i, false));
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
		for (PokerCard i : deck){
			i.setUsed(false);
		}

	}
	
	public static CardDeck getInstance(){
		return INSTANCE;
	}
	public List<PokerCard> getDeck(){
		return this.deck;
	}
}
