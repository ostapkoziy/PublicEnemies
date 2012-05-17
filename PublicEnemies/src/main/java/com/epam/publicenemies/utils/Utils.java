package com.epam.publicenemies.utils;

import java.util.List;

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
		for (Fight game1 : FightsList.newInstanse().getList())
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
	 */
	public static void deleteGame(long id)
	{
		List<Fight> allGames = FightsList.newInstanse().getList();
		for (Fight game1 : allGames)
		{
			if (game1.getId() == id)
			{
				allGames.remove(game1);
				break;
			}
		}
	}
}
