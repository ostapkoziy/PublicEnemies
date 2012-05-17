package com.epam.publicenemies.domain.blackjack;

import java.util.List;
import java.util.Random;

public class BlackJackGame {
	private final int id;
	private List<BlackJackCard> playerCards;
	private List<BlackJackCard> dealerCards;
	private int bet;
	private int chips;
	private int yourPoints;
	
	public BlackJackGame(int id,int chips){
		this.id = id;
		this.chips = chips;
	}
	
	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	public int getYourPoints() {
		return yourPoints;
	}

	public void setYourPoints(int yourPoints) {
		this.yourPoints = yourPoints;
	}	
	public int getId() {
		return id;
	}
	public List<BlackJackCard> getPlayerCards() {
		return playerCards;
	}
	public void setPlayerCards(List<BlackJackCard> playerCards) {
		this.playerCards = playerCards;
	}
	public List<BlackJackCard> getDealerCards() {
		return dealerCards;
	}
	public void setDealerCards(List<BlackJackCard> dealerCards) {
		this.dealerCards = dealerCards;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}
}
