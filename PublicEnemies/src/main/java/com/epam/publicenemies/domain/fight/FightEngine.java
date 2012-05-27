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
	public void startEngine(Fight fight, String whoStartes)
	{
		int creatorDamage = creatorDamage(fight);
		int connectorHPAfterHit = fight.getConnectorProfile().getHP() - creatorDamage;
		int connectorDamage = connectorDamage(fight);
		int creatorHPAfterHit = fight.getCreatorProfile().getHP() - connectorDamage;
		if (connectorHPAfterHit <= 0)
		{
			fight.getConnectorProfile().setHP(0);
			fight.setWhoWins("creator");
			sendServerMessage(fight.getId(), fight.getCreatorProfile().getNickName() + " WIN!");
		}
		else
		{
			fight.getConnectorProfile().setHP(connectorHPAfterHit);
		}
		if (creatorHPAfterHit <= 0)
		{
			fight.getCreatorProfile().setHP(0);
			fight.setWhoWins("connector");
			sendServerMessage(fight.getId(), fight.getConnectorProfile().getNickName() + " WIN!");
		}
		else
		{
			fight.getCreatorProfile().setHP(creatorHPAfterHit);
		}
		if (fight.getCreatorProfile().getHP() == 0 || fight.getConnectorProfile().getHP() == 0)
		{
			fight.setGameEnd(true);
			return;
		}
		else
		{
			log.info("-------------ENGINE STARTED-------------");
			sendServerMessage(fight.getId(), "<b>Server: </b> Round №" + fight.getRound().getRoundNumber() + " end.");
			clearHitsBlocks(fight);
			log.info("--------------ENGINE END-------------");
		}
	}
	/**
	 * Startes when one user is offline
	 */
	public void startEngine(String whoOnline, Fight fight)
	{
	}
	private void clearHitsBlocks(Fight game)
	{
		game.getRound().setUser1Hit("");
		game.getRound().setUser2Hit("");
		game.getRound().setUser1Block("");
		game.getRound().setUser2Block("");
		game.getRound().setFirstHit("");
		game.getRound().setU1Hit(false);
		game.getRound().setU2Hit(false);
		game.getRound().setRoundNumber(game.getRound().getRoundNumber() + 1);
		game.getRound().setRoundStart(true);
		game.getRound().setRoundBeginTime(System.currentTimeMillis() / 1000);
	}
	private synchronized void sendServerMessage(long gameId, String mess)
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
	private int creatorDamage(Fight fight)
	{
		return fight.getCreatorProfile().getDamage() + skillDamage();
	}
	private int connectorDamage(Fight fight)
	{
		return fight.getConnectorProfile().getDamage() + skillDamage();
	}
	private void shooting()
	{
	}
	// TODO ДОРОБИТИ СКІЛИ
	private int skillDamage()
	{
		return 0;
	}
}
