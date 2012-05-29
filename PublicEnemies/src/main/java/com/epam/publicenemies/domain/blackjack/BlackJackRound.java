package com.epam.publicenemies.domain.blackjack;

import java.util.List;

public class BlackJackRound {
	private List<BlackJackCard> playerCards;
	private List<BlackJackCard> playerCardsSplit;
	private List<BlackJackCard> dealerCards;
	private int playerBet;
	private int playerPoints;
	private String playerResult;
	
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
	public int getPlayerBet() {
		return playerBet;
	}
	public void setPlayerBet(int bet) {
		this.playerBet = bet;
	}
	public int getPlayerPoints() {
		return playerPoints;
	}
	public void setPlayerPoints(int playerPoints) {
		this.playerPoints = playerPoints;
	}
	public String getPlayerResult() {
		return playerResult;
	}
	public void setPlayerResult(String playerResult) {
		this.playerResult = playerResult;
	}
	public List<BlackJackCard> getPlayerCardsSplit() {
		return playerCardsSplit;
	}
	public void setPlayerCardsSplit(List<BlackJackCard> playerCardsSplit) {
		this.playerCardsSplit = playerCardsSplit;
	}

}
