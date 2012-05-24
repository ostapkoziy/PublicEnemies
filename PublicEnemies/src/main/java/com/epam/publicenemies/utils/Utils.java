package com.epam.publicenemies.utils;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;

/**
 * @author Alexander Ivanov
 */
// TODO Change to Service
public class Utils
{
	private static Logger	log	= Logger.getLogger(Utils.class);
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
	 */
	public static synchronized void deleteGame(Fight fight)
	{
		HashMap<Long, Fight> hm = FightsList.newInstanse().getMap();
		hm.remove(fight.getId());
		log.info("************************************");
		log.info("TOTAL GAMES AFTER DELETE GAME WITH ID: " + fight.getId() + ":::" + hm.size());
		log.info("************************************");
	}
	/**
	 * Check if users are online. 2 offline - delete game
	 */
	public static void isUsersOffline(Fight fight)
	{
		if (!fight.isCreatorOnline() && !fight.isConnectorOnline())
		{
			deleteGame(fight);
		}
	}
	public static void isOldGameInSession(Fight oldFight, String role)
	{
		if (oldFight != null && role != null)
		{
			if (role.equals("creator"))
			{
				oldFight.setCreatorOnline(false);
			}
			else
			{
				oldFight.setConnectorOnline(false);
			}
			Utils.isUsersOffline(oldFight);
		}
	}
}
