package com.epam.publicenemies.web;

import org.apache.log4j.Logger;

import com.epam.publicenemies.service.ITableManagerService;

/**
 * 
 * @author Danylo_Batyuk
 * Updated by I. Kostyrko on Apr 26, 2012
 *
 */
public class CreateTableController {
	private Logger log = Logger.getLogger(CreateTableController.class);
	
	private ITableManagerService tableManagerService;
	

	public void setTableManagerService(ITableManagerService tableManagerService) {
		this.tableManagerService = tableManagerService;
	}

	/**
	 * Recreates all necessary tables in database
	 * Warning: it deletes all existing data in database 
	 */
	public void createAllTables() {
		log.info("CreateTableController - deletedTables was invoked");
		tableManagerService.deleteTables();		
		
		log.info("CreateTableController - createTables was invoked");
		tableManagerService.createTables(); 
		
		log.info("CreateTableController - fillAllTables was invoked");
		tableManagerService.fillAllTables(); 		
	}
}
