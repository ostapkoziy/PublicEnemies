package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.publicenemies.dao.ITableDao;
import com.epam.publicenemies.web.listeners.OnContextLoaderListener;

/**
 * This class intended to create and delete all necessary tables
 * Be caution - its destroys all existing data in db
 * Updated by I. Kostyrko on Apr 27, 2012
 *
 */
public class TableDaoImpl implements ITableDao {
	
	private Logger log = Logger.getLogger(OnContextLoaderListener.class);
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Creates necessary empty tables in publicenemies database
	 * 
	 * Keep hands out of this code! Order of calls does matter 
	 */
	@Override
	public void createAllTables() {
		createWeaponsTable();	
		log.info("TableDaoImpl: table \"weapons\" added"); 
		createArmorsTable();		
		log.info("TableDaoImpl: \"armors\" added");
		createAidsTable();		
		log.info("TableDaoImpl: \"aids\" added");
		createCharactersTable();
		log.info("TableDaoImpl: \"characters\" added");
		createChatPropertiesTable();		
		log.info("TableDaoImpl: \"chatProperties\" added");
		createIgnoredUsersTable();
		log.info("TableDaoImpl: \"ignoredUsers\" added");
		createCharactersTrunksTable();
		log.info("TableDaoImpl: \"charactersTrunks\" added");
		createUsersTable();		
		log.info("TableDaoImpl: \"user\" added");
	}
	
	/**
	 * Destroys tables if exists 
	 * 
	 * Keep hands out of this code! Order of calls does matter 
	 */
	@Override
	public void deleteAllTable(){
		StringBuilder sql = new StringBuilder();
		sql.append("DROP TABLE IF EXISTS aids");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS armors");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS weapons");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS users");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS ignoredUsers");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS charactersTrunks");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS characters");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());
		sql.append("DROP TABLE IF EXISTS chatProperties");
		jdbcTemplate.execute(sql.toString());
		sql.delete(0, sql.length());	
		log.info("TableDaoImpl: all tables DELETED");
	}	
	
	// below methods are hidden from external access
	private void createUsersTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE users ( ");
		sql.append("userId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("email VARCHAR(100) NOT NULL UNIQUE, ");
		sql.append("password VARCHAR(100) NOT NULL, ");
		sql.append("regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, ");
		sql.append("money INT(10) UNSIGNED NOT NULL DEFAULT 200, ");
		sql.append("avatar VARCHAR(100) NOT NULL DEFAULT 'avatar', ");
		sql.append("chatProperty INT(10) UNSIGNED NULL UNIQUE, ");
		sql.append("userCharacter INT(10) UNSIGNED NULL UNIQUE, ");
		sql.append("nickName VARCHAR(100) NULL UNIQUE, ");
		sql.append("PRIMARY KEY (userId), ");
		sql.append("INDEX (chatProperty), ");
		sql.append("FOREIGN KEY (chatProperty) REFERENCES chatProperties(chatpropertyId), ");
		sql.append("INDEX (userCharacter), ");
		sql.append("FOREIGN KEY (userCharacter) REFERENCES characters(characterId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}

	private void createCharactersTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE characters ( ");
		sql.append("characterId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("sex BIT NOT NULL DEFAULT 1, ");
		sql.append("experiance INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("strength INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
		sql.append("agility INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
		sql.append("intelect INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
		sql.append("profession VARCHAR(100) NOT NULL DEFAULT '', ");
		sql.append("fightsTotal INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("fightsWon INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("weapon1 INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("weapon2 INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("aid INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("armor INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("PRIMARY KEY (characterId) ) ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}

	private void createChatPropertiesTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE chatProperties ( ");
		sql.append("chatPropertyId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("someProperty1 VARCHAR(100) NOT NULL DEFAULT '', ");
		sql.append("PRIMARY KEY (chatPropertyId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}

	private void createIgnoredUsersTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE ignoredUsers ( ");
		sql.append("ignoredId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("chatPropertyId INT(10) UNSIGNED NOT NULL UNIQUE, ");
		sql.append("userId INT(10) UNSIGNED NOT NULL, ");
		sql.append("PRIMARY KEY (ignoredId), ");
		sql.append("INDEX (chatPropertyId), ");
		sql.append("FOREIGN KEY (chatPropertyId) REFERENCES chatProperties(chatPropertyId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}
	
	private void createCharactersTrunksTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE charactersTrunks ( ");
		sql.append("trunkId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("itemId INT(10) UNSIGNED NOT NULL, ");
		sql.append("itemType INT(10) UNSIGNED NOT NULL CHECK (itemType in(1-3)), ");
		sql.append("characterId INT(10) UNSIGNED NOT NULL, ");
		sql.append("PRIMARY KEY (trunkId), ");
		sql.append("INDEX (characterId), ");
		sql.append("FOREIGN KEY (characterId) REFERENCES characters(characterId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}

	private void createWeaponsTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE weapons ( ");
		sql.append("weaponId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("weaponName VARCHAR(100) NOT NULL UNIQUE, ");
		sql.append("weaponHitPoints INT(10) UNSIGNED NOT NULL, ");
		sql.append("weaponPicture VARCHAR(100) NOT NULL DEFAULT 'picture', ");
		sql.append("weaponType BIT NOT NULL DEFAULT 0, ");
		sql.append("weaponPrice INT(10) UNSIGNED NOT NULL DEFAULT 100, ");
		sql.append("PRIMARY KEY (weaponId) ");
		sql.append(") ENGINE=INNODB ");
		jdbcTemplate.execute(sql.toString());
	}

	private void createArmorsTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE armors ( ");
		sql.append("armorId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("armorName VARCHAR(100) NOT NULL UNIQUE, ");
		sql.append("armorProtection INT(10) UNSIGNED NOT NULL DEFAULT 10, ");
		sql.append("armorPicture VARCHAR(100) NOT NULL DEFAULT 'picture', ");
		sql.append("armorPrice INT(10) UNSIGNED NOT NULL DEFAULT 100, ");
		sql.append("PRIMARY KEY (armorId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}

	private void createAidsTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE aids ( ");
		sql.append("aidId INT(10) UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE, ");
		sql.append("aidName VARCHAR(100) NOT NULL UNIQUE, ");
		sql.append("aidType VARCHAR(100) NOT NULL, ");
		sql.append("aidEffect INT(10) UNSIGNED NOT NULL DEFAULT 20, ");
		sql.append("aidPicture VARCHAR(100) NOT NULL DEFAULT 'picture', ");
		sql.append("aidPrice INT(10) UNSIGNED NOT NULL DEFAULT 100, ");
		sql.append("PRIMARY KEY (aidId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}
}
