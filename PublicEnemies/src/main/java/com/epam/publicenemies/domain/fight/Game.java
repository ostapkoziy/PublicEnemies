package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
public class Game
{
	private long				id;
	private Profile				user1profile;
	private Profile				user2profile;
	private volatile boolean	gameStarted;
	private volatile boolean	gameEnd	= false;
	private Round				round	= new Round();
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
	public Round getRound()
	{
		return round;
	}
	public void setRound(Round round)
	{
		this.round = round;
	}
}
