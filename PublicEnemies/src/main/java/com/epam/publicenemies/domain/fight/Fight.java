package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
public class Fight
{
	private long				id;
	private Profile				creatorProfile;
	private Profile				connectorProfile;
	private volatile boolean	gameStarted		= false;
	private volatile boolean	gameEnd			= false;
	private FightRound			round			= new FightRound();
	private String				whoIAm;
	private boolean				creatorOnline	= true;
	private boolean				connectorOnline	= false;
	private String				whoWins;
	public long getId()
	{
		return id;
	}
	public Profile getCreatorProfile()
	{
		return creatorProfile;
	}
	public Profile getConnectorProfile()
	{
		return connectorProfile;
	}
	public boolean isGameStarted()
	{
		return gameStarted;
	}
	public boolean isGameEnd()
	{
		return gameEnd;
	}
	public FightRound getRound()
	{
		return round;
	}
	public String getWhoIAm()
	{
		return whoIAm;
	}
	public boolean isCreatorOnline()
	{
		return creatorOnline;
	}
	public boolean isConnectorOnline()
	{
		return connectorOnline;
	}
	public String getWhoWins()
	{
		return whoWins;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public void setCreatorProfile(Profile creatorProfile)
	{
		this.creatorProfile = creatorProfile;
	}
	public void setConnectorProfile(Profile connectorProfile)
	{
		this.connectorProfile = connectorProfile;
	}
	public void setGameStarted(boolean gameStarted)
	{
		this.gameStarted = gameStarted;
	}
	public void setGameEnd(boolean gameEnd)
	{
		this.gameEnd = gameEnd;
	}
	public void setRound(FightRound round)
	{
		this.round = round;
	}
	public void setWhoIAm(String whoIAm)
	{
		this.whoIAm = whoIAm;
	}
	public void setCreatorOnline(boolean creatorOnline)
	{
		this.creatorOnline = creatorOnline;
	}
	public void setConnectorOnline(boolean connectorOnline)
	{
		this.connectorOnline = connectorOnline;
	}
	public void setWhoWins(String whoWins)
	{
		this.whoWins = whoWins;
	}
}
