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
	public synchronized void startEngine(Fight game)
	{
		int user1Damage = 50;
		int user2HPAfterHit = game.getUser2profile().getHP() - user1Damage;
		int user2Damage = 45;
		int user1HPAfterHit = game.getUser1profile().getHP() - user2Damage;
		if (user2HPAfterHit <= 0)
		{
			game.getUser2profile().setHP(0);
			game.setUser1resaultPage("win.html");
			game.setUser2resaultPage("lose.html");
			FightEngine.sendServerMessage(game.getId(), game.getUser1profile().getNickName() + " WIN!");
		}
		else
		{
			game.getUser2profile().setHP(user2HPAfterHit);
		}
		if (user1HPAfterHit <= 0)
		{
			game.getUser1profile().setHP(0);
			game.setUser1resaultPage("lose.html");
			game.setUser2resaultPage("win.html");
			FightEngine.sendServerMessage(game.getId(), game.getUser2profile().getNickName() + " WIN!");
		}
		else
		{
			game.getUser1profile().setHP(user1HPAfterHit);
		}
		if (game.getUser1profile().getHP() == 0 || game.getUser2profile().getHP() == 0)
		{
			game.setGameEnd(true);
			return;
		}
		else
		{
			log.info("-------------ENGINE STARTED-------------");
			FightEngine.sendServerMessage(game.getId(), "<b>Server: </b> Round №" + game.getRound().getRoundNumber() + " end.");
			clearHitsBlocks(game);
			log.info("--------------ENGINE END-------------");
		}
	}
	// private void
}
