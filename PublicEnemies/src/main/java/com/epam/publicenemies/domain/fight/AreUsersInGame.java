package com.epam.publicenemies.domain.fight;

/**
 * Users status in fight
 * 
 * @author Alexander Ivanov
 */
public enum AreUsersInGame
{
	/**
	 * Creator is offline. Add to connector some exp and money. Game over.
	 */
	CREATOR_OFFLINE
	{
		@Override
		public boolean start(Fight fight)
		{
			fight.getCreatorProfile().setHP(0);
			fight.setWhoWins("connector");
			return true;
		}
	},
	/**
	 * Connector is offline. Add to creator some exp and money. Game over.
	 */
	CONNECTOR_OFFLINE
	{
		@Override
		public boolean start(Fight fight)
		{
			fight.getConnectorProfile().setHP(0);
			fight.setWhoWins("creator");
			return true;
		}
	},
	/**
	 * No exp No money. Continue game.
	 */
	OFFLINE
	{
		@Override
		public boolean start(Fight fight)
		{
			fight.setWhoWins("noWiners");
			return true;
		}
	};
	public abstract boolean start(Fight fight);
}