package com.epam.publicenemies.web.casino.blackjack;

import java.util.List;

import com.epam.publicenemies.domain.blackjack.BlackJackCard;

public class BlackJackEngine {
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
			return "You Win!";
		} else if (dealerPoints == 21) {
			return "You Lose!";
		} else if (dealerPoints < 21) {
			if (dealerPoints > playerPoints) {
				return "You Lose!";
			} else if (dealerPoints == playerPoints) {
				return "Draw!";
			} else if (dealerPoints < playerPoints) {
				return "You Win!";
			}
		}
		return "Fuck it";
	}

	public String checkResult(int playerPoints) {
		if (playerPoints > 21) {
			return "You Lose";
		} else if (playerPoints == 21) {
			return "You Win!";
		}
		return null;
	}
}
