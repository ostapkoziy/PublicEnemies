package com.epam.publicenemies.utils;

import java.util.List;

import com.epam.publicenemies.domain.fight.Game;
import com.epam.publicenemies.domain.fight.GamesList;

/**
 * @author Alexander Ivanov
 */
// TODO Change to Service
public class Utils
{
	/**
	 * Find game by ID
	 */
	public static Game findGameById(long gameId)
	{
		Game game = null;
		for (Game game1 : GamesList.newInstanse().getList())
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
		List<Game> allGames = GamesList.newInstanse().getList();
		for (Game game1 : allGames)
		{
			if (game1.getId() == id)
			{
				allGames.remove(game1);
				break;
			}
		}
	}
}
