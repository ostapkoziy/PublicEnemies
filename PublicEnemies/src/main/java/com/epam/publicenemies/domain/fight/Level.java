package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public class Level
{
	/*
	 * Якшо userExpirienceOnCurrentLevel > expirienceForNextLevel левел++
	 * різницю експи в базу
	 */
	private int	currentLevel;					// from_DB
	private int	userExpirienceOnCurrentLevel;	// from_DB
	private int	expirienceForNextLevel;
	private int	nextLevelInPercent;
	public Level()
	{
		expirienceForNextLevel = 2 * 1000 * currentLevel;
		nextLevelInPercent = userExpirienceOnCurrentLevel / expirienceForNextLevel;
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
}
