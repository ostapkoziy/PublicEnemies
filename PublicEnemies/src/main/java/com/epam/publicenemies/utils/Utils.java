package com.epam.publicenemies.utils;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.FightsList;
import com.epam.publicenemies.domain.fight.Level;

/**
 * @author Alexander Ivanov
 */
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
	public static void expAnalizer(Level level)
	{
		int allExp = level.getAllExpirience();
		int leftBound = 0;
		int rightBound = 0;
		int newLvl = 0;
		while (true)
		{
			newLvl++;
			rightBound = rightBound + 1000 + newLvl * newLvl * 100;
			if (rightBound > allExp)
			{
				break;
			}
			leftBound = rightBound;
		}
		int expOnCurrentLvl = allExp - leftBound;
		level.setCurrentLevel(newLvl);
		level.setExpOnCurrentLevel(expOnCurrentLvl);
		level.setRightBound(rightBound);
		level.setLeftBound(leftBound);
		level.setNextLevelInPercent((int) ((float) (expOnCurrentLvl) / (rightBound - leftBound) * 100));
	}
	public static void isNewLevel(Level level, int oldLvl, int newLvl)
	{
		if (newLvl > oldLvl)
		{
			level.setNewLevel(true);
		}
	}
	public static void creatorWins(Fight fight)
	{
		int allExp = fight.getCreatorProfile().getLevel().getAllExpirience();
		int lvlDiff = fight.getConnectorProfile().getLevel().getCurrentLevel() - fight.getCreatorProfile().getLevel().getCurrentLevel();
		int expAfterFight = 250 + lvlDiff * 20;
		fight.getCreatorProfile().getLevel().setExpirienceAfterFight(expAfterFight);
		fight.getCreatorProfile().getLevel().setAllExpirience(allExp + expAfterFight);
	}
	public static void connectorWins(Fight fight)
	{
		int allExp = fight.getConnectorProfile().getLevel().getAllExpirience();
		int lvlDiff = fight.getCreatorProfile().getLevel().getCurrentLevel() - fight.getConnectorProfile().getLevel().getCurrentLevel();
		int expAfterFight = 250 + lvlDiff * 20;
		fight.getConnectorProfile().getLevel().setExpirienceAfterFight(expAfterFight);
		fight.getConnectorProfile().getLevel().setAllExpirience(allExp + expAfterFight);
	}
}
