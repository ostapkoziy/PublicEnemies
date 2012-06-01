package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class Action
{
	private String	hit;
	private String	block;
	private boolean	didHit;
	public Action()
	{
		hit = "";
		block = "";
		didHit = false;
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
}