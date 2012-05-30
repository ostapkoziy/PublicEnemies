package com.epam.publicenemies.domain.fight;

import java.util.HashMap;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.epam.publicenemies.chat.MessageList;

/**
 * @author Alexander Ivanov
 */
public class FightEngine
{
	private static Logger	log	= Logger.getLogger(FightEngine.class);
	public void startEngine(Fight fight)
	{
		log.info("-------------ENGINE STARTED-------------");
		AreUsersInGame auig = areUsersInGame(fight.getRound().getCreatorHit(), fight.getRound().getConnectorHit());
		boolean offline = auig.start(fight);
		if (offline)
		{
			log.info("---------GAME OVER! REASON: USER OFFLINE---------");
			fight.setGameEnd(true);
		}
		else
		{
			boolean isGameEnd = shooting(fight);
			if (isGameEnd)
			{
				log.info("---------GAME OVER---------");
				fight.setGameEnd(true);
			}
			else
			{
				setupGame(fight);
			}
		}
		log.info("--------------ENGINE END-------------");
	}
	/**
	 * Starts when one or all users are offline.
	 * 
	 * @param fight
	 */
	private void setupGame(Fight fight)
	{
		log.info("---------GAME SETUP IN ENGINE--------");
		sendServerMessage(fight.getId(), "<b>Server: </b> Round №" + fight.getRound().getRoundNumber() + " end.");
		clearHitsBlocks(fight);
	}
	private boolean shooting(Fight fight)
	{
		String creatorHit = fight.getRound().getCreatorHit();
		String creatorBlock = fight.getRound().getCreatorBlock();
		String connectorHit = fight.getRound().getConnectorHit();
		String connectorBlock = fight.getRound().getConnectorBlock();
		int creatorDamage = 0;
		int connectorDamage = 0;
		int creatorHPAfterHit = fight.getCreatorProfile().getHP();
		int connectorHPAfterHit = fight.getConnectorProfile().getHP();
		if (!creatorHit.equals(connectorBlock))
		{
			creatorDamage = creatorBlockedDamage(fight);
			connectorHPAfterHit = connectorHPAfterHit - creatorDamage;
		}
		if (!connectorHit.equals(creatorBlock))
		{
			connectorDamage = connectorBlockedDamage(fight);
			creatorHPAfterHit = creatorHPAfterHit - connectorDamage;
		}
		/*
		 * Add skill damage
		 */
		RoundResult rr = healthAnalizer(creatorHPAfterHit, connectorHPAfterHit);
		log.info("---------HEALTH ANALIZER: " + rr);
		boolean isGameEnd = rr.roundResult(fight, creatorDamage, connectorDamage);
		return isGameEnd;
	}
	private void clearHitsBlocks(Fight game)
	{
		game.getRound().setCreatorHit("");
		game.getRound().setConnectorHit("");
		game.getRound().setCreatorBlock("");
		game.getRound().setConnectorBlock("");
		game.getRound().setCreatorDoHit(false);
		game.getRound().setConnectorDoHit(false);
		game.getRound().setRoundNumber(game.getRound().getRoundNumber() + 1);
		game.getRound().setRoundStart(true);
		game.getRound().setRoundBeginTime(System.currentTimeMillis() / 1000);
	}
	public static synchronized void sendServerMessage(long gameId, String mess)
	{
		MessageList ml = MessageList.newInstanse();
		HashMap<Long, LinkedList<String>> allMessages = ml.getGameMessages();
		LinkedList<String> msListInGame = allMessages.get(gameId);
		if (msListInGame == null)
		{
			msListInGame = new LinkedList<String>();
			msListInGame.addFirst(mess);
			ml.getGameMessages().put(gameId, msListInGame);
		}
		else
		{
			msListInGame.addFirst(mess);
		}
	}
	private int creatorBlockedDamage(Fight fight)
	{
		return fight.getCreatorProfile().getDamage();
	}
	private int connectorBlockedDamage(Fight fight)
	{
		return fight.getConnectorProfile().getDamage();
	}
	private RoundResult healthAnalizer(int creatorHP, int connectorHP)
	{
		if (creatorHP <= 0 && connectorHP <= 0)
		{
			return RoundResult.DOUBLE_DEATH;
		}
		if (creatorHP <= 0)
		{
			return RoundResult.CREATOR_DEATH;
		}
		if (connectorHP <= 0)
		{
			return RoundResult.CONNECTOR_DEATH;
		}
		return RoundResult.ALIVE;
	}
	private AreUsersInGame areUsersInGame(String creatorHit, String connectorHit)
	{
		if (creatorHit.equals("") && connectorHit.equals(""))
		{
			return AreUsersInGame.OFFLINE;
		}
		if (creatorHit.equals(""))
		{
			return AreUsersInGame.CREATOR_OFFLINE;
		}
		if (connectorHit.equals(""))
		{
			return AreUsersInGame.CONNECTOR_OFFLINE;
		}
		return AreUsersInGame.ONLINE;
	}
}
