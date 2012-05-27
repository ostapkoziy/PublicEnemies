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
		boolean isGameEnd = shooting(fight);
		log.info("-------------ENGINE STARTED-------------");
		if (!isGameEnd)
		{
			setupGame(fight);
		}
		else
		{
			gameOver(fight);
		}
		log.info("--------------ENGINE END-------------");
	}
	private void setupGame(Fight fight)
	{
		sendServerMessage(fight.getId(), "<b>Server: </b> Round №" + fight.getRound().getRoundNumber() + " end.");
		clearHitsBlocks(fight);
	}
	private void gameOver(Fight fight)
	{
		fight.setGameEnd(true);
	}
	/**
	 * Startes when one user is offline
	 */
	public void startEngine(String whoOnline, Fight fight)
	{
	}
	private void clearHitsBlocks(Fight game)
	{
		game.getRound().setCreatorHit("");
		game.getRound().setConnectorHit("");
		game.getRound().setCreatorBlock("");
		game.getRound().setConnectorBlock("");
		game.getRound().setFirstHit("");
		game.getRound().setCreatorDoHit(false);
		game.getRound().setConnectorDoHit(false);
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
	private int creatorBlockedDamage(Fight fight)
	{
		return fight.getCreatorProfile().getDamage();
	}
	private int connectorBlockedDamage(Fight fight)
	{
		return fight.getConnectorProfile().getDamage();
	}
	private boolean shooting(Fight fight)
	{
		String creatorHit = fight.getRound().getCreatorHit();
		String creatorBlock = fight.getRound().getCreatorBlock();
		String connectorHit = fight.getRound().getConnectorHit();
		String connectorBlock = fight.getRound().getConnectorBlock();
		int creatorDamage = creatorBlockedDamage(fight);
		int connectorDamage = connectorBlockedDamage(fight);
		int creatorHPAfterHit = fight.getCreatorProfile().getHP();
		int connectorHPAfterHit = fight.getConnectorProfile().getHP();
		if (!creatorHit.equals(connectorBlock))
		{
			connectorHPAfterHit = connectorHPAfterHit - creatorDamage;
		}
		else
		{
			creatorDamage = 0;
		}
		if (!connectorHit.equals(creatorBlock))
		{
			creatorHPAfterHit = creatorHPAfterHit - connectorDamage;
		}
		else
		{
			connectorDamage = 0;
		}
		RoundResult rr = healthAnalizer(creatorHPAfterHit, connectorHPAfterHit, "");
		boolean isGameEnd = rr.roundResult(fight, creatorDamage, connectorDamage);
		return isGameEnd;
	}
	private RoundResult healthAnalizer(int creatorHP, int connectorHP, String firstHit)
	{
		if (creatorHP <= 0 && connectorHP <= 0)
		{
			return RoundResult.Double_Deth;
		}
		if (creatorHP <= 0)
		{
			return RoundResult.Creator_Deth;
		}
		if (connectorHP <= 0)
		{
			return RoundResult.Connector_deth;
		}
		else
		{
			return RoundResult.Alive;
		}
	}
	// TODO ДОРОБИТИ СКІЛИ
	/*
	 * Skills damage not blocked
	 */
	private int skillDamage()
	{
		return 0;
	}
}
