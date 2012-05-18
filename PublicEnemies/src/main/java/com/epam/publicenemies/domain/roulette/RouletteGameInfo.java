package com.epam.publicenemies.domain.roulette;

public class RouletteGameInfo {
	
	private String betNumbers[];
	private int bet;
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
	public String[] getBetNumbers() {
		return betNumbers;
	}
	public void setBetNumbers(String[] betNumbers) {
		this.betNumbers = betNumbers;
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
	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
	}
}