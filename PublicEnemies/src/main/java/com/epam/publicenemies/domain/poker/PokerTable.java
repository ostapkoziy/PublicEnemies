package com.epam.publicenemies.domain.poker;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ostap Koziy
 */
public class PokerTable {
	private List<PokerCard> flop = new ArrayList<PokerCard>();
	private PokerCard flop1;
	private PokerCard flop2;
	private PokerCard flop3;
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
		flop1 = flop.get(0);
		flop2 = flop.get(1);
		flop3 = flop.get(2);
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
	public PokerCard getFlop1() {
		return flop1;
	}
	public void setFlop1(PokerCard flop1) {
		this.flop1 = flop1;
	}
	public PokerCard getFlop2() {
		return flop2;
	}
	public void setFlop2(PokerCard flop2) {
		this.flop2 = flop2;
	}
	public PokerCard getFlop3() {
		return flop3;
	}
	public void setFlop3(PokerCard flop3) {
		this.flop3 = flop3;
	}
	
	
}
