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
}
