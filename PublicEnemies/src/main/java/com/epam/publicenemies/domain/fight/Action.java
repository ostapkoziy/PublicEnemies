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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((block == null) ? 0 : block.hashCode());
		result = prime * result + (didHit ? 1231 : 1237);
		result = prime * result + ((hit == null) ? 0 : hit.hashCode());
		result = prime * result + (usedAid ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Action other = (Action) obj;
		if (block == null)
		{
			if (other.block != null) return false;
		}
		else
			if (!block.equals(other.block)) return false;
		if (didHit != other.didHit) return false;
		if (hit == null)
		{
			if (other.hit != null) return false;
		}
		else
			if (!hit.equals(other.hit)) return false;
		if (usedAid != other.usedAid) return false;
		return true;
	}
}
