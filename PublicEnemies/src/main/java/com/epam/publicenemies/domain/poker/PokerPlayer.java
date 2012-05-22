package com.epam.publicenemies.domain.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.epam.publicenemies.web.casino.poker.FoldException;
//import com.epam.publicenemies.web.casino.poker.WaitingNewPokerRound;

public class PokerPlayer implements IPokerPlayer {
	private Logger	log	= Logger.getLogger(PokerPlayer.class);
	
	private String name;
	private int cash;
	//===================
	
	public PokerPlayer(String name, int cash) {
		this.name = name;
		this.cash = cash;
	}
	public String getName() {
		return name;
	}
	public int getCash() {
		return cash;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCash(int cash) {
		
		this.cash = cash;
	}
	public int makeMove(PokerTable table, PokerHand hand, boolean isSmallBlind) throws FoldException{
		int in = 0;
		log.info("You have "+(table.getPlayer2Bet() - table.getPlayer1Bet())+" to call");
		log.info(name+" please enter the sum");
		
		//in = player's move
		
		table.setPlayer1Bet(table.getPlayer1Bet() + in);
		this.cash -= in;
		
		return in;
	}
	
	private int call(){
		return 0;
	}
	
	private int check(){
		return 0;
	}
	
	private int triBet(){
		return 0;
	}
	
	private int raise(){
		return 0;
	}
}
