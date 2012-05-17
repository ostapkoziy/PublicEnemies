package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
public class Fight
{
	private long				id;
	private Profile				user1profile;
	private Profile				user2profile;
	private volatile boolean	gameStarted;
	private volatile boolean	gameEnd	= false;
	private FightRound			round	= new FightRound();
	private String				user1resaultPage;
	private String				user2resaultPage;
	private String				whoIAm;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public Profile getUser1profile()
	{
		return user1profile;
	}
	public void setUser1profile(Profile user1profile)
	{
		this.user1profile = user1profile;
	}
	public Profile getUser2profile()
	{
		return user2profile;
	}
	public void setUser2profile(Profile user2profile)
	{
		this.user2profile = user2profile;
	}
	public boolean isGameStarted()
	{
		return gameStarted;
	}
	public void setGameStarted(boolean gameStarted)
	{
		this.gameStarted = gameStarted;
	}
	public boolean isGameEnd()
	{
		return gameEnd;
	}
	public void setGameEnd(boolean gameEnd)
	{
		this.gameEnd = gameEnd;
	}
	public FightRound getRound()
	{
		return round;
	}
	public void setRound(FightRound round)
	{
		this.round = round;
	}
	public String getUser1resaultPage()
	{
		return user1resaultPage;
	}
	public void setUser1resaultPage(String user1resaultPage)
	{
		this.user1resaultPage = user1resaultPage;
	}
	public String getUser2resaultPage()
	{
		return user2resaultPage;
	}
	public void setUser2resaultPage(String user2resaultPage)
	{
		this.user2resaultPage = user2resaultPage;
	}
	public String getWhoIAm()
	{
		return whoIAm;
	}
	public void setWhoIAm(String whoIAm)
	{
		this.whoIAm = whoIAm;
	}
}
