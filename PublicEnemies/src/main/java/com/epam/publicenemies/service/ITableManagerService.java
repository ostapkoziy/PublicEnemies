package com.epam.publicenemies.service;

public interface ITableManagerService {	
	/**
	 * Allows to delete all tables in publicenemies database
	 */
	void deleteTables();
	
	/**
	 * Creates all necessary tables for publicenemies database
	 */
	void createTables();
	
	/* Old version of interface here
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
