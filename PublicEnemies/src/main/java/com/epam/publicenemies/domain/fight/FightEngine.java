package com.epam.publicenemies.domain.fight;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;

import com.epam.publicenemies.chat.MessageList;
import com.epam.publicenemies.domain.Profile;

/**
 * @author Alexander Ivanov
 */
public class FightEngine
{
	private static Logger	log	= Logger.getLogger(FightEngine.class);
	private void clearHitsBlocks(Fight game)
	{
		game.getRound().getCreatorAction().setHit("");
		game.getRound().getCreatorAction().setBlock("");
		game.getRound().getCreatorAction().setDidHit(false);
		// *************************************
		game.getRound().getConnectorAction().setHit("");
		game.getRound().getConnectorAction().setBlock("");
		game.getRound().getConnectorAction().setDidHit(false);
		// ***************************************
		game.getRound().setRoundNumber(game.getRound().getRoundNumber() + 1);
		game.getRound().setRoundStart(true);
		game.getRound().setRoundBeginTime(System.currentTimeMillis() / 1000);
	}
	public static synchronized void sendServerMessage(long gameId, String mess)
	{
		MessageList ml = MessageList.newInstanse();
		ConcurrentHashMap<Long, LinkedList<String>> allMessages = ml.getGameMessages();
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
	public void startEngine(Fight fight)
	{
		log.info("-------------ENGINE STARTED-------------");
		UsersStatus auig = areUsersInGame(fight);
		boolean offline = auig.check(fight);
		if (offline)
		{
			log.info("---------GAME OVER! REASON: USER OFFLINE---------");
			fight.setGameEnd(true);
		}
		else
		{
			boolean isGameEnd = action(fight);
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
		sendServerMessage(fight.getId(), "<b>Server: </b> Round #" + fight.getRound().getRoundNumber() + " end.");
		clearHitsBlocks(fight);
	}
	private boolean action(Fight fight)
	{
		String creatorHit = fight.getRound().getCreatorAction().getHit();
		String creatorBlock = fight.getRound().getCreatorAction().getBlock();
		String connectorHit = fight.getRound().getConnectorAction().getHit();
		String connectorBlock = fight.getRound().getConnectorAction().getBlock();
		int creatorDamage = 0;
		int connectorDamage = 0;
		int creatorHPAfterHit = fight.getCreatorProfile().getHP();
		int connectorHPAfterHit = fight.getConnectorProfile().getHP();
		// if creator HIT(connector not blocked)
		if (!creatorHit.equals(connectorBlock) && !miss(fight, fight.getCreatorProfile(), fight.getConnectorProfile().getMissRate()))
		{
			creatorDamage = damageAfterArmor(creatorDamage(fight), connectorDefence(fight));
			connectorHPAfterHit = hit(fight.getConnectorProfile().getHP(), creatorDamage);
		}
		// if connector HIT(creator not blocked)
		if (!connectorHit.equals(creatorBlock) && !miss(fight, fight.getConnectorProfile(), fight.getCreatorProfile().getMissRate()))
		{
			connectorDamage = damageAfterArmor(connectorDamage(fight), creatorDefence(fight));
			creatorHPAfterHit = hit(fight.getCreatorProfile().getHP(), connectorDamage);
		}
		RoundResult rr = healthAnalizer(creatorHPAfterHit, connectorHPAfterHit);
		log.info("---------HEALTH ANALIZER: " + rr);
		boolean isGameEnd = rr.roundResult(fight, creatorDamage, connectorDamage);
		return isGameEnd;
	}
	/**
	 * 
	 * @param health
	 * @param damage
	 * @return health after hit.
	 */
	private int hit(int health, int damage)
	{
		health = health - damage;
		return health;
	}
	/**
	 * 
	 * @param fight
	 * @param profile
	 * @param missChance
	 *            opponent miss chance. DODGE
	 * @return is player misses
	 */
	private boolean miss(Fight fight, Profile profile, int missChance)
	{
		if (missChance > new Random().nextInt(100))
		{
			FightEngine.sendServerMessage(fight.getId(), profile.getNickName() + ": MISS");
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param damage
	 * @param defencePercent
	 * @return damage after armor
	 */
	private int damageAfterArmor(int damage, int defencePercent)
	{
		damage = (int) (damage - (float) defencePercent / 100 * damage);
		log.info("DAMAGE AFTER ARMOR" + damage);
		return damage;
	}
	private int creatorDamage(Fight fight)
	{
		return fight.getCreatorProfile().getDamage();
	}
	private int connectorDamage(Fight fight)
	{
		return fight.getConnectorProfile().getDamage();
	}
	private int creatorDefence(Fight fight)
	{
		return fight.getCreatorProfile().getDefence();
	}
	private int connectorDefence(Fight fight)
	{
		return fight.getConnectorProfile().getDefence();
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
	private UsersStatus areUsersInGame(Fight fight)
	{
		String creatorHit = fight.getRound().getCreatorAction().getHit();
		String connectorHit = fight.getRound().getConnectorAction().getHit();
		if (creatorHit.equals("") && connectorHit.equals(""))
		{
			return UsersStatus.OFFLINE;
		}
		if (creatorHit.equals(""))
		{
			return UsersStatus.CREATOR_OFFLINE;
		}
		if (connectorHit.equals(""))
		{
			return UsersStatus.CONNECTOR_OFFLINE;
		}
		return UsersStatus.ONLINE;
	}
}
