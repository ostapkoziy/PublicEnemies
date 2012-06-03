package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class Action
{
	private String				hit;
	private String				block;
	private volatile boolean	didHit;
	private volatile boolean	usedAid;
	public Action()
	{
		hit = "";
		block = "";
		didHit = false;
		usedAid = false;
	}
	public String getHit()
	{
		return hit;
	}
	public String getBlock()
	{
		return block;
	}
	public boolean isDidHit()
	{
		return didHit;
	}
	public void setHit(String hit)
	{
		this.hit = hit;
	}
	public void setBlock(String block)
	{
		this.block = block;
	}
	public void setDidHit(boolean didHit)
	{
		this.didHit = didHit;
	}
	public boolean isUsedAid()
	{
		return usedAid;
	}
	public void setUsedAid(boolean usedAid)
	{
		this.usedAid = usedAid;
	}
}
