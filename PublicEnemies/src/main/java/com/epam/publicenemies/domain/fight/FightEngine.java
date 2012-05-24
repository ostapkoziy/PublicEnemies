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
	private static void clearHitsBlocks(Fight game)
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
	private synchronized static void sendServerMessage(long gameId, String mess)
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
	public synchronized void startEngine(Fight fight)
	{
		int creatorDamage = 50;
		int connectorHPAfterHit = fight.getConnectorProfile().getHP() - creatorDamage;
		int connectorDamage = 45;
		int creatorHPAfterHit = fight.getCreatorProfile().getHP() - connectorDamage;
		if (connectorHPAfterHit <= 0)
		{
			fight.getConnectorProfile().setHP(0);
			fight.setWhoWins("creator");
			FightEngine.sendServerMessage(fight.getId(), fight.getCreatorProfile().getNickName() + " WIN!");
		}
		else
		{
			fight.getConnectorProfile().setHP(connectorHPAfterHit);
		}
		if (creatorHPAfterHit <= 0)
		{
			fight.getCreatorProfile().setHP(0);
			fight.setWhoWins("connector");
			FightEngine.sendServerMessage(fight.getId(), fight.getConnectorProfile().getNickName() + " WIN!");
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
			FightEngine.sendServerMessage(fight.getId(), "<b>Server: </b> Round №" + fight.getRound().getRoundNumber() + " end.");
			clearHitsBlocks(fight);
			log.info("--------------ENGINE END-------------");
		}
	}
}
