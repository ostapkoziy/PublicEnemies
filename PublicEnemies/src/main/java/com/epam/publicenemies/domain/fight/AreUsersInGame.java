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
			fight.setWhoWins(fight.getProfile("connector"));
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
			fight.setWhoWins(fight.getProfile("creator"));
			return true;
		}
	},
	/**
	 * No exp No money. Game over.
	 */
	OFFLINE
	{
		@Override
		public boolean start(Fight fight)
		{
			fight.setWhoWins(null);
			return true;
		}
	},
	ONLINE
	{
		@Override
		public boolean start(Fight fight)
		{
			return false;
		}
	};
	public abstract boolean start(Fight fight);
}