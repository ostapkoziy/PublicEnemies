package com.epam.publicenemies.dao;

public interface ITrunkDao {

	
	/**
	 * Get amount of all weapons
	 * @return amount of all weapons
	 */
	int getWeaponsAmount();
	
	/**
	 * Get amount of all armors
	 * @return amount of all armors
	 */
	int getArmorsAmount();
	
	/**
	 * Get amount of all aids
	 * @return get amount of all aids
	 */
	int getAidsAmount();
	
}
