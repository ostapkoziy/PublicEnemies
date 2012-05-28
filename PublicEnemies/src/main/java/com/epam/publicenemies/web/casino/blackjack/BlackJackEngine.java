package com.epam.publicenemies.web.casino.blackjack;

import java.util.List;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;

public class BlackJackEngine {
	private final String win = "You Win!";
	private final String lose = "You Lose!";
	private final String draw = "Draw!";

	public int calculatePoints(List<BlackJackCard> cards) {
		int points = 0;
		for (BlackJackCard card : cards) {
			points = points + card.rank().getValue();
		}
		if (points > 21) {
			for (BlackJackCard card : cards) {
				if (card.rank().getName().equals("A")) {
					points = points - 10;
					return points;
				}
			}
		}
		return points;
	}

	public String checkResult(int playerPoints, int dealerPoints) {
		if (dealerPoints > 21) {
			return win;
		} else if (dealerPoints == 21) {
			return lose;
		} else if (dealerPoints < 21) {
			if (dealerPoints > playerPoints) {
				return lose;
			} else if (dealerPoints == playerPoints) {
				return draw;
			} else if (dealerPoints < playerPoints) {
				return win;
			}
		}
		return "Fuck it";
	}

	public String checkResult(int playerPoints) {
		if (playerPoints > 21) {
			return lose;
		} else if (playerPoints == 21) {
			return win;
		}
		return null;
	}

	public int updateChips(String result, int chips, int bet) {
		if (result == win) {
			return (chips + 2 * bet);
		} else if (result == draw) {
			return (chips + bet);
		} else if (result == lose) {
			return (chips);
		} else {
			return (chips);
		}
	}
}
