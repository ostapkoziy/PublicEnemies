package com.epam.publicenemies.web.casino.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PokerPlayer implements IPokerPlayer {
	private String name;
	private int cash;
	//===================
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
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
		System.out.println("You have "+(table.getPlayer2Bet() - table.getPlayer1Bet())+" to call");
		System.out.println(name+" please enter the sum");
		
		try {
			in = Integer.valueOf(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
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
