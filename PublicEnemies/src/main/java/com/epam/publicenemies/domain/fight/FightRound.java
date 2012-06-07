package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class FightRound
{
	private int				roundNumber;
	private boolean			roundStart;
	private Action			creatorAction;
	private Action			connectorAction;
	private volatile long	roundBeginTime;
	public FightRound()
	{
		roundNumber = 1;
		roundStart = true;
		creatorAction = new Action();
		connectorAction = new Action();
	}
	public int getRoundNumber()
	{
		return roundNumber;
	}
	public boolean isRoundStart()
	{
		return roundStart;
	}
	public Action getCreatorAction()
	{
		return creatorAction;
	}
	public Action getConnectorAction()
	{
		return connectorAction;
	}
	public long getRoundBeginTime()
	{
		return roundBeginTime;
	}
	public void setRoundNumber(int roundNumber)
	{
		this.roundNumber = roundNumber;
	}
	public void setRoundStart(boolean roundStart)
	{
		this.roundStart = roundStart;
	}
	public void setCreatorAction(Action creatorAction)
	{
		this.creatorAction = creatorAction;
	}
	public void setConnectorAction(Action connectorAction)
	{
		this.connectorAction = connectorAction;
	}
	public void setRoundBeginTime(long roundBeginTime)
	{
		this.roundBeginTime = roundBeginTime;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((connectorAction == null) ? 0 : connectorAction.hashCode());
		result = prime * result + ((creatorAction == null) ? 0 : creatorAction.hashCode());
		result = prime * result + (int) (roundBeginTime ^ (roundBeginTime >>> 32));
		result = prime * result + roundNumber;
		result = prime * result + (roundStart ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		FightRound other = (FightRound) obj;
		if (connectorAction == null)
		{
			if (other.connectorAction != null) return false;
		}
		else
			if (!connectorAction.equals(other.connectorAction)) return false;
		if (creatorAction == null)
		{
			if (other.creatorAction != null) return false;
		}
		else
			if (!creatorAction.equals(other.creatorAction)) return false;
		if (roundBeginTime != other.roundBeginTime) return false;
		if (roundNumber != other.roundNumber) return false;
		if (roundStart != other.roundStart) return false;
		return true;
	}
}
