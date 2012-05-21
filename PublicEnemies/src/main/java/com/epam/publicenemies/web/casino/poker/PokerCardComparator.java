package com.epam.publicenemies.web.casino.poker;

import java.util.Comparator;

import com.epam.publicenemies.domain.poker.PokerCard;
import com.epam.publicenemies.domain.poker.Value;


public class PokerCardComparator implements Comparator<PokerCard> {

	public int compare(PokerCard arg0, PokerCard arg1) {
		Value card1Value = arg0.getValue();
		Value card2Value = arg1.getValue();
		int card1Pos = Value.VALUES.indexOf(card1Value);
		int card2Pos = Value.VALUES.indexOf(card2Value);
		return card2Pos - card1Pos;
	}

}
