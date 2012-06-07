package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.utils.Utils;

/**
 * @author Alexander Ivanov
 */
public enum RoundResult
{
	DOUBLE_DEATH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(0);
			fight.setWhoWins(null);
			return true;
		}
	},
	CREATOR_DEATH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			Profile profile = fight.getProfile("connector");
			int connectorHP = fight.getConnectorProfile().getHP();
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(connectorHP - creatorDamage);
			fight.setWhoWins(profile);
			fight.setWhoLoses(fight.getProfile("creator"));
			// TODO chit;
			// fight.getConnectorProfile().getLevel().setNewLevel(true);
			Utils.connectorWins(fight);
			return true;
		}
	},
	CONNECTOR_DEATH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			Profile profile = fight.getProfile("creator");
			int creatorHP = fight.getCreatorProfile().getHP();
			fight.getConnectorProfile().setHP(0);
			fight.getCreatorProfile().setHP(creatorHP - connectorDamage);
			fight.setWhoWins(profile);
			fight.setWhoLoses(fight.getProfile("connector"));
			// TODO chit
			// fight.getCreatorProfile().getLevel().setNewLevel(true);
			Utils.creatorWins(fight);
			return true;
		}
	},
	ALIVE
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int creatorHP = fight.getCreatorProfile().getHP();
			int connectorHP = fight.getConnectorProfile().getHP();
			fight.getCreatorProfile().setHP(creatorHP - connectorDamage);
			fight.getConnectorProfile().setHP(connectorHP - creatorDamage);
			FightEngine.sendServerMessage(fight.getId(), "Server: " + fight.getCreatorProfile().getNickName() + " HIT : "
					+ fight.getRound().getCreatorAction().getHit() + " BLOCK: " + fight.getRound().getCreatorAction().getBlock());
			FightEngine.sendServerMessage(fight.getId(), "Server: " + fight.getConnectorProfile().getNickName() + " HIT : "
					+ fight.getRound().getConnectorAction().getHit() + " BLOCK: " + fight.getRound().getConnectorAction().getBlock());
			return false;
		}
	};
	/**
	 * 
	 * @param fight
	 * @param creatorDamage
	 * @param connectorDamage
	 * @return is Game End
	 */
	public abstract boolean roundResult(Fight fight, int creatorDamage, int connectorDamage);
}
