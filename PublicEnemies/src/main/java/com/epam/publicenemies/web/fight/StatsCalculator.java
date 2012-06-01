package com.epam.publicenemies.web.fight;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.fight.Fight;
import com.epam.publicenemies.domain.fight.Level;

/**
 * @author Alexander Ivanov
 */
public class StatsCalculator
{
	public static void makeStats(Fight fight, String role)
	{
		Profile profile = fight.getProfile(role);
		makeStats(profile);
	}
	public static void makeStats(Profile profile)
	{
		profile.setAllHP(400 + profile.getStrength() * 15);
		profile.setHP(profile.getAllHP());
		profile.setDamage(20 + profile.getAgility() * 3 + profile.getDressedWeapon1().getHitPoints() + profile.getDressedWeapon2().getHitPoints());
		profile.setDefence(profile.getDressedArmor().getArmorProtection());
		profile.setLevel(new Level(profile.getExperience()));
		// TODO add miss percent INTELIGANCE
	}
}
