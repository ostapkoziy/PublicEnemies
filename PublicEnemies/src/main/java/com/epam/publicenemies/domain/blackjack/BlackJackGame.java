package com.epam.publicenemies.domain.blackjack;

/**
 * @author Danylo_Batyuk
 */

public class BlackJackGame {
	private final int id;
	private BlackJackRound round;
	private int chips;
	private boolean enoughChips;

	public BlackJackGame(int id, int chips) {
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

	public boolean isEnoughChips() {
		return enoughChips;
	}

	public void setEnoughChips(boolean enoughChips) {
		this.enoughChips = enoughChips;
	}
}
