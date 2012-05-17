package com.epam.publicenemies.domain.blackjack;

import java.util.List;
import java.util.Random;

public class Game {
	private final long id;
	private List<Card> playerCards;
	private List<Card> dealerCards;
	
	public Game(){
		Random rand = new Random();
		id = rand.nextLong();
	}
	
	public long getId() {
		return id;
	}
	public List<Card> getPlayerCards() {
		return playerCards;
	}
	public void setPlayerCards(List<Card> playerCards) {
		this.playerCards = playerCards;
	}
	public List<Card> getDealerCards() {
		return dealerCards;
	}
	public void setDealerCards(List<Card> dealerCards) {
		this.dealerCards = dealerCards;
	}
}
