package com.epam.publicenemies.web.casino.poker;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.poker.PokerRound;

/*
 * @author Ostap Koziy
 */
public class PokerGame {

	private int id;
	private Profile user1Profile;
	private PokerRound pokerGameRound;
	private String comment;
	
	public PokerGame (int id, Profile user){
		this.user1Profile = user;
		this.id = id;
	}
	public PokerGame (){
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Profile getUser1Profile() {
		return user1Profile;
	}
	public void setUser1Profile(Profile user1Profile) {
		this.user1Profile = user1Profile;
	}

	public PokerRound getPokerGameRound() {
		return pokerGameRound;
	}
	public void setPokerGameRound(PokerRound pokerGameRound) {
		this.pokerGameRound = pokerGameRound;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
