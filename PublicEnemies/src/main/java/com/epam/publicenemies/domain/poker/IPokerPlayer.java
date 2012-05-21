package com.epam.publicenemies.domain.poker;

import com.epam.publicenemies.web.casino.poker.FoldException;



public interface IPokerPlayer {
	public int makeMove(PokerTable deck, PokerHand hand, boolean isSmallBlind) throws FoldException;

	public String getName();

	public int getCash();

	public void setCash(int i);

}
