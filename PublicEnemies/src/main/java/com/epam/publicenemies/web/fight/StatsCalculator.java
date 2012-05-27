package com.epam.publicenemies.web.fight;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;

/**
 * @author Alexander Ivanov
 */
public class StatsCalculator
{
	public static void makeStats(Fight fight, String role)
	{
		Profile profile = null;
		if (role.equals("creator"))
		{
			profile = fight.getCreatorProfile();
		}
		else
		{
			profile = fight.getConnectorProfile();
		}
		profile.setAllHP(400 + profile.getStrength() * 10);
		profile.setHP(profile.getAllHP());
		profile.setDamage(20 + profile.getAgility() * 3);
		profile.setDefence(10);
	}
}
