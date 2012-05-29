package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class Level
{
	/**
	 * Якшо userExpirienceOnCurrentLevel > expirienceForNextLevel левел++
	 * різницю експи в базу
	 */
	private int	currentLevel					= 1;	// from_DB
	private int	userExpirienceOnCurrentLevel	= 1200; // from_DB
	private int	expirienceAfterFight;
	private int	expirienceForNextLevel;
	private int	nextLevelInPercent;
	public Level()
	{
		expirienceAfterFight = 0;
		expirienceForNextLevel = 2 * 1000 * currentLevel;
		nextLevelInPercent = (int) (((float) userExpirienceOnCurrentLevel / expirienceForNextLevel) * 100);
	}
	public int getCurrentLevel()
	{
		return currentLevel;
	}
	public int getUserExpirienceOnCurrentLevel()
	{
		return userExpirienceOnCurrentLevel;
	}
	public int getExpirienceForNextLevel()
	{
		return expirienceForNextLevel;
	}
	public int getNextLevelInPercent()
	{
		return nextLevelInPercent;
	}
	public void setCurrentLevel(int currentLevel)
	{
		this.currentLevel = currentLevel;
	}
	public void setUserExpirienceOnCurrentLevel(int userExpirienceOnCurrentLevel)
	{
		this.userExpirienceOnCurrentLevel = userExpirienceOnCurrentLevel;
	}
	public void setExpirienceForNextLevel(int expirienceForNextLevel)
	{
		this.expirienceForNextLevel = expirienceForNextLevel;
	}
	public void setNextLevelInPercent(int nextLevelInPercent)
	{
		this.nextLevelInPercent = nextLevelInPercent;
	}
	public int getExpirienceAfterFight()
	{
		return expirienceAfterFight;
	}
	public void setExpirienceAfterFight(int expirienceAfterFight)
	{
		this.expirienceAfterFight = expirienceAfterFight;
	}
}
