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
	
	/**
	 * Fills all tables with some data
	 */
	void fillAllTables();
}
