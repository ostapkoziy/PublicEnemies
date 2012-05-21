package com.epam.publicenemies.domain.roulette;

public class RouletteGameInfo {
	
	private Integer bets[];
	private int prize;
	private int luckyNumber;
	private int chips;
	private String msg = "";

	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public Integer[] getBets() {
		return bets;
	}
	public void setBets(Integer[] betNumbers) {
		this.bets = betNumbers;
	}
	public int getLuckyNumber() {
		return luckyNumber;
	}
	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
	}
}