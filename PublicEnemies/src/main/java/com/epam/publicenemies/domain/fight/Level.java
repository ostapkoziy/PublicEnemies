package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
public class Level
{
	private int		allExpirience;			// from DB
	private int		currentLevel;
	private int		expirienceAfterFight;
	private int		leftBound;
	private int		rightBound;
	private int		expOnCurrentLevel;
	private int		nextLevelInPercent;
	private boolean	newLevel;
	public Level(int experience)
	{
		allExpirience = experience;
		newLevel = false;
		Utils.expAnalizer(this);
	}
	public int getAllExpirience()
	{
		return allExpirience;
	}
	public void setAllExpirience(int allExpirience)
	{
		this.allExpirience = allExpirience;
	}
	public int getCurrentLevel()
	{
		return currentLevel;
	}
	public void setCurrentLevel(int currentLevel)
	{
		this.currentLevel = currentLevel;
	}
	public int getExpirienceAfterFight()
	{
		return expirienceAfterFight;
	}
	public void setExpirienceAfterFight(int expirienceAfterFight)
	{
		this.expirienceAfterFight = expirienceAfterFight;
	}
	public int getLeftBound()
	{
		return leftBound;
	}
	public void setLeftBound(int leftBound)
	{
		this.leftBound = leftBound;
	}
	public int getRightBound()
	{
		return rightBound;
	}
	public void setRightBound(int rightBound)
	{
		this.rightBound = rightBound;
	}
	public int getExpOnCurrentLevel()
	{
		return expOnCurrentLevel;
	}
	public void setExpOnCurrentLevel(int expOnCurrentLevel)
	{
		this.expOnCurrentLevel = expOnCurrentLevel;
	}
	public int getNextLevelInPercent()
	{
		return nextLevelInPercent;
	}
	public void setNextLevelInPercent(int nextLevelInPercent)
	{
		this.nextLevelInPercent = nextLevelInPercent;
	}
	public boolean isNewLevel()
	{
		return newLevel;
	}
	public void setNewLevel(boolean newLevel)
	{
		this.newLevel = newLevel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + allExpirience;
		result = prime * result + currentLevel;
		result = prime * result + expOnCurrentLevel;
		result = prime * result + expirienceAfterFight;
		result = prime * result + leftBound;
		result = prime * result + (newLevel ? 1231 : 1237);
		result = prime * result + nextLevelInPercent;
		result = prime * result + rightBound;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Level other = (Level) obj;
		if (allExpirience != other.allExpirience)
			return false;
		if (currentLevel != other.currentLevel)
			return false;
		if (expOnCurrentLevel != other.expOnCurrentLevel)
			return false;
		if (expirienceAfterFight != other.expirienceAfterFight)
			return false;
		if (leftBound != other.leftBound)
			return false;
		if (newLevel != other.newLevel)
			return false;
		if (nextLevelInPercent != other.nextLevelInPercent)
			return false;
		if (rightBound != other.rightBound)
			return false;
		return true;
	}
}
