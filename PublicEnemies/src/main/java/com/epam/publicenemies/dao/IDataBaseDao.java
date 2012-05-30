package com.epam.publicenemies.dao;

import java.util.List;

public interface IDataBaseDao {
	
	/**
	 * Get names of all available tables in database 
	 * @return list of names
	 */
	List<String> getAllTables();
	
	/**
	 * Get data base name
	 * @return name of data base
	 */
	String getDataBaseName();
	
	/**
	 * Get name of user connected to data base
	 * @return name of user
	 */
	String getUserConnected();
	
	/**
	 * Get version of MySQL server
	 * @return version of MySQL server
	 */
	String getMySQLVersion();
	
}
