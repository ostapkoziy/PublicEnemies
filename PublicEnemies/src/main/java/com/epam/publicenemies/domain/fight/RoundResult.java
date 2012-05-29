package com.epam.publicenemies.domain.fight;

/**
 * TODO Move to FightEngine!!!!
 * 
 * @author Alexander Ivanov
 */
public enum RoundResult
{
	DOUBLE_DETH
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
	CREATOR_DETH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int connectorHP = fight.getConnectorProfile().getHP();
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(connectorHP - creatorDamage);
			fight.setWhoWins(fight.getProfile("connector"));
			return true;
		}
	},
	CONNECTOR_DETH
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int creatorHP = fight.getCreatorProfile().getHP();
			fight.getConnectorProfile().setHP(0);
			fight.getCreatorProfile().setHP(creatorHP - connectorDamage);
			fight.setWhoWins(fight.getProfile("creator"));
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
	public abstract boolean roundResult(Fight fight, int creatorDamage, int connectorDamage);
}
