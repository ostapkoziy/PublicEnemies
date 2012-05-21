package com.epam.publicenemies.web.casino.poker;

import com.epam.publicenemies.domain.Profile;

/*
 * @author Ostap Koziy
 */
public class PokerGame {

	private long id;
	private Profile user1Profile;
	private PokerGameEngine pokerGameEngine;
	private String userResultPage;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Profile getUser1Profile() {
		return user1Profile;
	}
	public void setUser1Profile(Profile user1Profile) {
		this.user1Profile = user1Profile;
	}
	public PokerGameEngine getPokerGameEngine() {
		return pokerGameEngine;
	}
	public void setPokerGameEngine(PokerGameEngine pokerGameEngine) {
		this.pokerGameEngine = pokerGameEngine;
	}
	public String getUserResultPage() {
		return userResultPage;
	}
	public void setUserResultPage(String userResultPage) {
		this.userResultPage = userResultPage;
	}
	
	
}
