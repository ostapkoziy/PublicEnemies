package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;

public class PokerTable {
	private List<PokerCard> flop = new ArrayList<PokerCard>();
	private PokerCard turn;
	private PokerCard river;
	private int smallBlind;
	private int bigBlind;
	
	
	public List<PokerCard> getFlop() {
		return flop;
	}
	public PokerCard getTurn() {
		return turn;
	}
	public PokerCard getRiver() {
		return river;
	}
	public void setFlop(List<PokerCard> flop) {
		this.flop = flop;
	}
	public void setTurn(PokerCard turn) {
		this.turn = turn;
	}
	public void setRiver(PokerCard river) {
		this.river = river;
	}
	
	public int getSmallBlind() {
		return smallBlind;
	}
	public int getBigBlind() {
		return bigBlind;
	}
	public void setSmallBlind(int smallBlind) {
		this.smallBlind = smallBlind;
	}
	public void setBigBlind(int bigBlind) {
		this.bigBlind = bigBlind;
	}
	@Override
	public String toString() {
		return ""+flop.get(0)+" "+flop.get(1)+" "+flop.get(2)+"   "+turn+"   "+river;
	}
	
	public List<PokerCard> getTable(){
		List<PokerCard> result = new ArrayList<PokerCard>();
		result.addAll(flop);
		if (turn != null){
			result.add(turn);	
		}
		if (river != null){
			result.add(river);	
		}
		return result;
	}
	
}
