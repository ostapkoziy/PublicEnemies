package com.epam.publicenemies.domain.fight;

import java.util.HashMap;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.epam.publicenemies.chat.MessageList;

/**
 * @author Karamba
 */
public class GameEngine
{
	private static Logger	log	= Logger.getLogger(GameEngine.class);
	private static void clearHitsBlocks(Game game)
	{
		game.getRound().setUser1Hit("");
		game.getRound().setUser2Hit("");
		game.getRound().setUser1Block("");
		game.getRound().setUser2Block("");
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
	public synchronized static void startEngine(Game game)
	{
		int user1Damage = 1;
		int user2HPAfterHit = game.getUser2profile().getStrength() - user1Damage;
		int user2Damage = 2;
		int user1HPAfterHit = game.getUser1profile().getStrength() - user2Damage;
		if (user2HPAfterHit <= 0)
		{
			game.getUser2profile().setStrength(0);
			// game.getUser1().setPage("win.html");
			// game.getUser2().setPage("lose.html");
			GameEngine.sendServerMessage(game.getId(), game.getUser1profile().getNickName() + " WIN!");
		}
		else
		{
			game.getUser2profile().setStrength(user2HPAfterHit);
		}
		if (user1HPAfterHit <= 0)
		{
			game.getUser1profile().setStrength(0);
			// game.getUser2().setPage("win.html");
			// game.getUser1().setPage("lose.html");
			GameEngine.sendServerMessage(game.getId(), game.getUser2profile().getNickName() + " WIN!");
		}
		else
		{
			game.getUser1profile().setStrength(user1HPAfterHit);
		}
		if (game.getUser1profile().getStrength() == 0 || game.getUser2profile().getStrength() == 0)
		{
			game.setGameEnd(true);
			return;
		}
		else
		{
			log.info("-------------ENGINE STARTED-------------");
			game.getRound().setU1Hit(false);
			game.getRound().setU2Hit(false);
			GameEngine.sendServerMessage(game.getId(), "<b>Server: </b> Round №" + game.getRound().getRoundNumber() + " end.");
			game.getRound().setRoundNumber(game.getRound().getRoundNumber() + 1);
			game.getRound().setRoundStart(true);
			game.getRound().setRoundBeginTime(System.currentTimeMillis() / 1000);
			clearHitsBlocks(game);
			log.info("--------------ENGINE END-------------");
		}
	}
}
