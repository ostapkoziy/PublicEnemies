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

	public void checkResult(){
		
	}
}
