package com.epam.publicenemies.web.casino.poker;



public interface IPokerPlayer {
	public int makeMove(PokerTable deck, PokerHand hand, boolean isSmallBlind) throws FoldException;

	public String getName();

	public int getCash();

	public void setCash(int i);

}
