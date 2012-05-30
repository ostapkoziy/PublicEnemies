package com.epam.publicenemies.domain.roulette;

import com.epam.publicenemies.domain.Profile;

public class RouletteGameInfo {
	
	private Integer bets[];
	private int betOnTable;
	private int prize;
	private int luckyNumber;
	private int chips;
	private String msg = "";
	private String[] history;
	private Profile userProfile;

	public Profile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}
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
	public int getBetAmount() {
		return betOnTable;
	}
	public void setBetAmount(int bet) {
		this.betOnTable = bet;
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
	public String[] getHistory() {
		return history;
	}
	public void setHistory(String[] history) {
		this.history = history;
	}
}