package com.epam.publicenemies.domain.fight;

import org.apache.log4j.Logger;

/**
 * TODO Move to FightEngine!!!!
 * 
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
			fight.setGameEnd(true);
			return true;
		}
	},
	CREATOR_DEATH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int connectorHP = fight.getConnectorProfile().getHP();
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(connectorHP - creatorDamage);
			fight.setWhoWins(fight.getProfile("connector"));
			fight.setGameEnd(true);
			return true;
		}
	},
	CONNECTOR_DEATH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int creatorHP = fight.getCreatorProfile().getHP();
			fight.getConnectorProfile().setHP(0);
			fight.getCreatorProfile().setHP(creatorHP - connectorDamage);
			fight.setWhoWins(fight.getProfile("creator"));
			fight.setGameEnd(true);
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
	private Logger	log	= Logger.getLogger(RoundResult.class);
}
