package com.epam.publicenemies.domain.fight;

/**
 * @author Karamba
 */
public class Round
{
	private int		roundNumber	= 1;
	private boolean	roundStart	= true;
	private String	user1Hit	= "";
	private String	user1Block	= "";
	private String	user2Hit	= "";
	private String	user2Block	= "";
	private boolean	u1Hit;
	private boolean	u2Hit;
	private long	roundBeginTime;
	public int getRoundNumber()
	{
		return roundNumber;
	}
	public boolean isRoundStart()
	{
		return roundStart;
	}
	public String getUser1Hit()
	{
		return user1Hit;
	}
	public String getUser1Block()
	{
		return user1Block;
	}
	public String getUser2Hit()
	{
		return user2Hit;
	}
	public String getUser2Block()
	{
		return user2Block;
	}
	public boolean isU1Hit()
	{
		return u1Hit;
	}
	public boolean isU2Hit()
	{
		return u2Hit;
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
	public void setUser1Hit(String user1Hit)
	{
		this.user1Hit = user1Hit;
	}
	public void setUser1Block(String user1Block)
	{
		this.user1Block = user1Block;
	}
	public void setUser2Hit(String user2Hit)
	{
		this.user2Hit = user2Hit;
	}
	public void setUser2Block(String user2Block)
	{
		this.user2Block = user2Block;
	}
	public void setU1Hit(boolean u1Hit)
	{
		this.u1Hit = u1Hit;
	}
	public void setU2Hit(boolean u2Hit)
	{
		this.u2Hit = u2Hit;
	}
	public void setRoundBeginTime(long roundBeginTime)
	{
		this.roundBeginTime = roundBeginTime;
	}
}
