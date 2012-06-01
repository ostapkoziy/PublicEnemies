package com.epam.publicenemies.domain.poker;

import java.io.Serializable;

import com.epam.publicenemies.web.casino.poker.PokerGame;


/**
 * @author Ostap Koziy
 */
public interface IPokerPlayer{
	public int makeMove(PokerGame game) throws FoldException;

	public String getName();

	public int getCash();

	public void setCash(int i);

}
