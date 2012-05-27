package com.epam.publicenemies.domain.fight;

/**
 * @author Alexander Ivanov
 */
public enum RoundResult
{
	Double_Deth
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(0);
			return true;
		}
	},
	Creator_Deth
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int connectorHP = fight.getConnectorProfile().getHP();
			fight.getCreatorProfile().setHP(0);
			fight.getConnectorProfile().setHP(connectorHP - creatorDamage);
			return true;
		}
	},
	Connector_deth
	{
		@Override
		public boolean roundResult(Fight fight, int creatorDamage, int connectorDamage)
		{
			int creatorHP = fight.getCreatorProfile().getHP();
			fight.getConnectorProfile().setHP(0);
			fight.getCreatorProfile().setHP(creatorHP - connectorDamage);
			return true;
		}
	},
	Alive
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
