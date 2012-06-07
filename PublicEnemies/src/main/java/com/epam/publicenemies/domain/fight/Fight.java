package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;

/**
 * @author Alexander Ivanov
 * @since 19.04.2012
 */
// TODO hashCode & equals
public class Fight
{
	private long				id;
	private Profile				creatorProfile;
	private Profile				connectorProfile;
	private volatile boolean	gameStarted;
	private volatile boolean	gameEnd;
	private FightRound			round;
	private volatile String		whoIAm;
	private boolean				creatorOnline;
	private boolean				connectorOnline;
	private Profile				whoWins;
	private Profile				whoLoses;
	private FightEngine			engine;
	public Fight()
	{
		gameStarted = false;
		gameEnd = false;
		round = new FightRound();
		creatorOnline = true;
		connectorOnline = false;
		engine = new FightEngine();
	}
	public Profile getProfile(String role)
	{
		if (role.equals("creator"))
			return creatorProfile;
		else
			return connectorProfile;
	}
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
	public Profile getWhoWins()
	{
		return whoWins;
	}
	public Profile getWhoLoses()
	{
		return whoLoses;
	}
	public FightEngine getEngine()
	{
		return engine;
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
	public void setWhoWins(Profile whoWins)
	{
		this.whoWins = whoWins;
	}
	public void setWhoLoses(Profile whoLoses)
	{
		this.whoLoses = whoLoses;
	}
	public void setEngine(FightEngine engine)
	{
		this.engine = engine;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (connectorOnline ? 1231 : 1237);
		result = prime * result + ((connectorProfile == null) ? 0 : connectorProfile.hashCode());
		result = prime * result + (creatorOnline ? 1231 : 1237);
		result = prime * result + ((creatorProfile == null) ? 0 : creatorProfile.hashCode());
		result = prime * result + (gameEnd ? 1231 : 1237);
		result = prime * result + (gameStarted ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((round == null) ? 0 : round.hashCode());
		result = prime * result + ((whoIAm == null) ? 0 : whoIAm.hashCode());
		result = prime * result + ((whoLoses == null) ? 0 : whoLoses.hashCode());
		result = prime * result + ((whoWins == null) ? 0 : whoWins.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Fight other = (Fight) obj;
		if (connectorOnline != other.connectorOnline) return false;
		if (connectorProfile == null)
		{
			if (other.connectorProfile != null) return false;
		}
		else
			if (!connectorProfile.equals(other.connectorProfile)) return false;
		if (creatorOnline != other.creatorOnline) return false;
		if (creatorProfile == null)
		{
			if (other.creatorProfile != null) return false;
		}
		else
			if (!creatorProfile.equals(other.creatorProfile)) return false;
		if (gameEnd != other.gameEnd) return false;
		if (gameStarted != other.gameStarted) return false;
		if (id != other.id) return false;
		if (round == null)
		{
			if (other.round != null) return false;
		}
		else
			if (!round.equals(other.round)) return false;
		if (whoIAm == null)
		{
			if (other.whoIAm != null) return false;
		}
		else
			if (!whoIAm.equals(other.whoIAm)) return false;
		if (whoLoses == null)
		{
			if (other.whoLoses != null) return false;
		}
		else
			if (!whoLoses.equals(other.whoLoses)) return false;
		if (whoWins == null)
		{
			if (other.whoWins != null) return false;
		}
		else
			if (!whoWins.equals(other.whoWins)) return false;
		return true;
	}
}
