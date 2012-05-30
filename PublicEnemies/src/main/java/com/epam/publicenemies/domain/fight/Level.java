package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class Level
{
	/**
	 * Якшо userExpirienceOnCurrentLevel > expirienceForNextLevel левел++ різницю експи в базу
	 */
	private int	currentLevel;
	private int	currentUserExpirience	= 1200; // from_DB
	private int	expirienceAfterFight;
	private int	expirienceForNextLevel;
	private int	nextLevelInPercent;
	public Level()
	{
		currentLevel = (currentUserExpirience + (2000 - 1)) / 2000;
		expirienceForNextLevel = 2000 * currentLevel;
		nextLevelInPercent = (int) ((double) currentUserExpirience / expirienceForNextLevel * 100);
		expirienceAfterFight = 0;
	}
	public int getCurrentLevel()
	{
		return currentLevel;
	}
	public int getCurrentUserExpirience()
	{
		return currentUserExpirience;
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
	public void setCurrentUserExpirience(int userExpirienceOnCurrentLevel)
	{
		this.currentUserExpirience = userExpirienceOnCurrentLevel;
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
