package com.epam.publicenemies.web;

import org.apache.log4j.Logger;

import com.epam.publicenemies.service.ITableManagerService;
import com.epam.publicenemies.web.listeners.OnContextLoaderListener;

/**
 * 
 * Updated by I. Kostyrko on Apr 26, 2012
 *
 */
public class CreateTableController {
	private Logger log = Logger.getLogger(OnContextLoaderListener.class);
	
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
		
		/* Old version
		 * This functions replaced into TableDaoIpl
		 * Reason: forbid to create single tables
		 * 
		 * After reading, those comments could be deleted by everyone
		
		tableManagerService.createWeaponsTable();
		log.info("TABLE = weapons SUCCESSFULLY ADDED");
		
		tableManagerService.createArmorsTable();
		log.info("TABLE = armors SUCCESSFULLY ADDED");
		
		tableManagerService.createAidsTable();
		log.info("TABLE = aids SUCCESSFULLY ADDED");
		
		tableManagerService.createCharactersTable();
		log.info("TABLE = characters SUCCESSFULLY ADDED");

		tableManagerService.createChatPropertiesTable();
		log.info("TABLE = chatProperties SUCCESSFULLY ADDED");
		
		tableManagerService.createIgnoredUsersTable();
		log.info("TABLE = ignoredUsers SUCCESSFULLY ADDED");

		tableManagerService.createCharactersTrunksTable();
		log.info("TABLE = characterTrunks SUCCESSFULLY ADDED");

		tableManagerService.createUserTable();
		log.info("TABLE = users SUCCESSFULLY ADDED");
		*/
		
	}
}
