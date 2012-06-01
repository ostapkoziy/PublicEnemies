package com.epam.publicenemies.domain.fight;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.utils.Utils;

/**
 * Users status in fight
 * 
 * @author Alexander Ivanov
 */
public enum UsersStatus
{
	/**
	 * Creator is offline. Add to connector some exp and money. Game over.
	 */
	CREATOR_OFFLINE
	{
		@Override
		public boolean check(Fight fight)
		{
			Profile profile = fight.getProfile("connector");
			fight.setWhoWins(profile);
			fight.setWhoLoses(fight.getProfile("creator"));
			Utils.connectorWins(fight);
			return true;
		}
	},
	/**
	 * Connector is offline. Add to creator some exp and money. Game over.
	 */
	CONNECTOR_OFFLINE
	{
		@Override
		public boolean check(Fight fight)
		{
			Profile profile = fight.getProfile("creator");
			fight.setWhoWins(profile);
			fight.setWhoLoses(fight.getProfile("connector"));
			Utils.creatorWins(fight);
			return true;
		}
	},
	/**
	 * No exp No money. Game over.
	 */
	OFFLINE
	{
		@Override
		public boolean check(Fight fight)
		{
			fight.setWhoWins(null);
			return true;
		}
	},
	ONLINE
	{
		@Override
		public boolean check(Fight fight)
		{
			return false;
		}
	};
	public abstract boolean check(Fight fight);
}