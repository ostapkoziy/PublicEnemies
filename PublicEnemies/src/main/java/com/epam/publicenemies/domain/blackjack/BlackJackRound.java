package com.epam.publicenemies.domain.blackjack;

import java.util.List;

public class BlackJackRound {
	private List<BlackJackCard> playerCards;
	private List<BlackJackCard> dealerCards;
	private int bet;
	private int yourPoints;
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
	public int getYourPoints() {
		return yourPoints;
	}
	public void setYourPoints(int yourPoints) {
		this.yourPoints = yourPoints;
	}

}
