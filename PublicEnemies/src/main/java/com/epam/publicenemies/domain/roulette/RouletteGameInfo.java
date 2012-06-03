package com.epam.publicenemies.domain.roulette;

import com.epam.publicenemies.domain.Profile;

public class RouletteGameInfo {
	
	private Integer bets[];
	private int betOnTable;
	private int prize;
	private int luckyNumber;
	private int chips;
	private String msg = "";
	private String history = "";
	private String userNickname = "";
	private String userAvatar = "";
	private int userMoney;
	
	

	
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public int getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(int userMoney) {
		this.userMoney = userMoney;
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
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
}