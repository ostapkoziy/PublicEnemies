package com.epam.publicenemies.domain.roulette;

public class RouletteGameInfo {
	
	private int betNumbers[];
	private int bet=0;
	private int prize=0;
	private int luckyNumber;
	private String msg = "";

	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public int[] getBetNumbers() {
		return betNumbers;
	}
	public int getBetAmount() {
		return bet;
	}
	public void setBetAmount(int bet) {
		this.bet = bet;
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
}