/**
 * 
 */
package com.epam.publicenemies.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IDataBaseDao;
import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.service.IDataBaseManagerService;

/**
 * @author Chetyrkin_Sviatoslav
 *
 */
@Service
public class DataBaseManagerServiceImpl implements IDataBaseManagerService {

	private Logger		log	= Logger.getLogger(DataBaseManagerServiceImpl.class);
	
	@Autowired
	private IDataBaseDao	dataBaseDao;

	/**
	 * Get names of all available tables in database 
	 * @return list of names
	 */
	@Override
	public List<String> getAllTables() {
		return dataBaseDao.getAllTables();
	}

	/**
	 * Get data base name
	 * @return name of data base
	 */
	@Override
	public String getDataBaseName() {
		return dataBaseDao.getDataBaseName();
	}

	/**
	 * Get name of user connected to data base
	 * @return name of user
	 */
	@Override
	public String getUserConnected() {
		return dataBaseDao.getUserConnected();
	}

	/**
	 * Get version of MySQL server
	 * @return version of MySQL server
	 */
	@Override
	public String getMySQLVersion() {
		return dataBaseDao.getMySQLVersion();
	}
}
