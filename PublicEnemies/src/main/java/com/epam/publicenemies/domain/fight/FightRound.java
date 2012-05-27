package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class FightRound
{
	private int				roundNumber;
	private boolean			roundStart;
	private String			creatorHit;
	private String			creatorBlock;
	private String			connectorHit;
	private String			connectorBlock;
	private boolean			creatorDoHit;
	private boolean			connectorDoHit;
	private String			firstHit;
	private volatile long	roundBeginTime;
	public FightRound()
	{
		roundNumber = 1;
		roundStart = true;
		creatorHit = "";
		creatorBlock = "";
		connectorHit = "";
		connectorBlock = "";
		firstHit = "";
	}
	public int getRoundNumber()
	{
		return roundNumber;
	}
	public boolean isRoundStart()
	{
		return roundStart;
	}
	public String getCreatorHit()
	{
		return creatorHit;
	}
	public String getCreatorBlock()
	{
		return creatorBlock;
	}
	public String getConnectorHit()
	{
		return connectorHit;
	}
	public String getConnectorBlock()
	{
		return connectorBlock;
	}
	public boolean isCreatorDoHit()
	{
		return creatorDoHit;
	}
	public boolean isConnectorDoHit()
	{
		return connectorDoHit;
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
	public void setCreatorHit(String user1Hit)
	{
		this.creatorHit = user1Hit;
	}
	public void setCreatorBlock(String user1Block)
	{
		this.creatorBlock = user1Block;
	}
	public void setConnectorHit(String user2Hit)
	{
		this.connectorHit = user2Hit;
	}
	public void setConnectorBlock(String user2Block)
	{
		this.connectorBlock = user2Block;
	}
	public void setCreatorDoHit(boolean u1Hit)
	{
		this.creatorDoHit = u1Hit;
	}
	public void setConnectorDoHit(boolean u2Hit)
	{
		this.connectorDoHit = u2Hit;
	}
	public void setRoundBeginTime(long roundBeginTime)
	{
		this.roundBeginTime = roundBeginTime;
	}
	public String getFirstHit()
	{
		return firstHit;
	}
	public void setFirstHit(String firstHit)
	{
		this.firstHit = firstHit;
	}
}
