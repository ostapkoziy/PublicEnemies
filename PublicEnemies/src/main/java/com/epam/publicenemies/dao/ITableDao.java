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
	
	
}
