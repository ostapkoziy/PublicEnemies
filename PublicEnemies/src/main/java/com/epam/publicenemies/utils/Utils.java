package com.epam.publicenemies.utils;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;

/**
 * @author Alexander Ivanov
 */
// TODO Change to Service
public class Utils
{
	/**
	 * Find game by ID
	 */
	public static Fight findGameById(long gameId)
	{
		Fight game = null;
		for (Fight game1 : FightsList.newInstanse().getMap().values())
		{
			if (game1.getId() == gameId)
			{
				game = game1;
				break;
			}
		}
		return game;
	}
	/**
	 * Delete game by ID
	 * 
	 * @throws NotImplementedExeption
	 */
	public static void deleteGame(long id) throws NotImplementedExeption
	{
		throw new NotImplementedExeption();
	}
}
