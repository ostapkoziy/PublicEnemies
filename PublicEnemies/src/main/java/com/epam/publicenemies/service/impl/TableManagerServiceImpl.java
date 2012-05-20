package com.epam.publicenemies.service.impl;

import com.epam.publicenemies.dao.ITableDao;
import com.epam.publicenemies.service.ITableManagerService;
/**
 * Allows to create/delete all necessary tables. 
 * Implements interface methods only, except of setter
 *    
 * Updated by I. Kostyrko on May 19, 2012: Removed unnecessary code 
 * @see com.epam.publicenemies.service.ITableManagerService
 */
public class TableManagerServiceImpl implements ITableManagerService {
	
	private ITableDao tableDao;

	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	@Override
	public void deleteTables() {
		tableDao.deleteAllTable();
	}
	
	@Override
	public void createTables() {
		tableDao.createAllTables();		
	}

	@Override
	public void fillAllTables() {
		tableDao.fillAllTables();
	}	
}
