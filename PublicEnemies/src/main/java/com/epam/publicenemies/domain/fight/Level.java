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
}
