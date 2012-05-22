package com.epam.publicenemies.domain.blackjack;


public class BlackJackGame {
	private final int id;
	private BlackJackRound round;
	private int chips;
	
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

	public int getId() {
		return id;
	}

	public BlackJackRound getRound() {
		return round;
	}

	public void setRound(BlackJackRound round) {
		this.round = round;
	}

}
