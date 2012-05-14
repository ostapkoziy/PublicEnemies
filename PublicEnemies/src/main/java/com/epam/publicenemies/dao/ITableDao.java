package com.epam.publicenemies.dao;

/**
 * Allows to create/delete tables 
 * Updated by I. Kostyrko on Apr 26, 2012
 *
 */
public interface ITableDao {
	
	/**
	 * Adds necessary tables in db 
	 */
	void createAllTables();
	
	/**
	 * Fill tables with some default values
	 */
	void fillAllTables();
	/**
	 * Removes tables from db 
	 */
	void deleteAllTable();	
	
	/* Old version
	 * Why old version is bad:
	 * 		it is required to create tables in particular order (new version)
	 * 		
	 * 
	void createUserTable();	
	void createProfileTable();	
	void createStatsTable();	
	void createInventoryTable();	
	void createTrunkTable();	
	void createWeaponsTable();	
	void createArmorsTable();	
	void createAidsTable(); 
	*/	
}
