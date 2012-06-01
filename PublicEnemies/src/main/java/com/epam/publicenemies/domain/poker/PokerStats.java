package com.epam.publicenemies.domain.poker;

public class PokerStats {
	
	private int playedGames;
	private byte vpip;
	private byte pfr;
	private byte tribet;
	private byte f3bet;
	
	private int vpipCounter;
	private int pfrCounter;
	private int tribetCounter;
	private int f3betCounter;
	private int playedGamesCounter;
	
	public PokerStats() {

	}
	
	public void addPlayedGames(){
		this.playedGamesCounter++;
	}
	
	public int getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(int playedGames) {
		this.playedGames = playedGames;
	}
	public byte getVpip() {
		return vpip;
	}
	public void setVpip(int vpip) {
		this.vpip = (byte) vpip;
	}
	public byte getPfr() {
		return pfr;
	}
	public void setPfr(int pfr) {
		this.pfr = (byte) pfr;
	}
	public byte get3bet() {
		return tribet;
	}
	public void set3bet(int tribet) {
		this.tribet = (byte) tribet;
	}
	public byte getf3bet() {
		return f3bet;
	}
	public void setf3bet(int f3bet) {
		this.f3bet = (byte) f3bet;
	}
	@Override
	public String toString() {
		return "games - " + playedGames + "; vpip - " + vpip + "; pfr - " + pfr + "; 3bet - " + tribet + "; f3bet - " + f3bet;
	}
	
	public String counters(){
		return "counters - " + "; vpipCounter - " + vpipCounter + "; pfrCounter - " + pfrCounter + "; 3betCounter - " + tribetCounter + "; f3betCounter - " + f3betCounter;
	}

	public int getVpipCounter() {
		return vpipCounter;
	}

	public void addVpipCounter() {
		this.vpipCounter ++;
	}

	public int getPfrCounter() {
		return pfrCounter;
	}

	public void addPfrCounter() {
		this.pfrCounter ++;
	}

	public int getTribetCounter() {
		return tribetCounter;
	}

	public void addTribetCounter() {
		this.tribetCounter ++;
	}

	public int getF3betCounter() {
		return f3betCounter;
	}

	public void addF3betCounter() {
		this.f3betCounter ++;
	}

	public int getPlayedGamesCounter() {
		return playedGamesCounter;
	}

	public void setPlayedGamesCounter(int playedGamesCounter) {
		this.playedGamesCounter = playedGamesCounter;
	}

	public void setVpipCounter(int vpipCounter) {
		this.vpipCounter = vpipCounter;
	}

	public void setPfrCounter(int pfrCounter) {
		this.pfrCounter = pfrCounter;
	}

	public void setTribetCounter(int tribetCounter) {
		this.tribetCounter = tribetCounter;
	}

	public void setF3betCounter(int f3betCounter) {
		this.f3betCounter = f3betCounter;
	}
	
	
}
