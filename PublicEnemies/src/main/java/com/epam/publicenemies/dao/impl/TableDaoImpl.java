package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epam.publicenemies.dao.ITableDao;
import com.epam.publicenemies.web.listeners.OnContextLoaderListener;


//TODO check for table creations
/**
 * This class intended to create and delete all necessary tables
 * Be caution - its destroys all existing data in db
 * Updated by I. Kostyrko on Apr 27, 2012
 *
 */
public class TableDaoImpl implements ITableDao {
	
	private Logger log = Logger.getLogger(TableDaoImpl.class);
	
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
	
	public void fillAllTables()  {
		fillWeapons();
		log.info("TableDaoImpl: \"weapons\" filled");
		fillAids();
		log.info("TableDaoImpl: \"aids\" filled");
		fillArmors();
		log.info("TableDaoImpl: \"armors\" filled");
		fillCharacters();
		log.info("TableDaoImpl: \"characters\" filled");
		fillCharactersTrunks();
		log.info("TableDaoImpl: \"charactersTrunks\" filled");
		fillChatProperties();
		log.info("TableDaoImpl: \"chatProperties\" filled");
		fillUsers();
		log.info("TableDaoImpl: \"users\" filled");
	}
	
	
	// below methods are hidden from external access
	
	private void fillWeapons(){
		StringBuilder sql = new StringBuilder("INSERT INTO weapons ");
		sql.append("(weaponName, weaponHitPoints, weaponType, weaponPrice) ");
		sql.append("VALUES ('valera', 500, 1, 1000)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO weapons ");
		sql.append("(weaponName, weaponHitPoints, weaponType, weaponPrice) ");
		sql.append("VALUES ('zatochka', 10, 0, 10)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillArmors(){
		StringBuilder sql = new StringBuilder("INSERT INTO armors ");
		sql.append("(armorName, armorProtection, armorPrice) ");
		sql.append("VALUES ('kevlavr', 50, 1500)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO armors ");
		sql.append("(armorName, armorProtection, armorPrice) ");
		sql.append("VALUES ('bronik', 500, 7000)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillAids() {
		StringBuilder sql = new StringBuilder("INSERT INTO aids ");
		sql.append("(aidName, AidType, aidEffect, aidPrice) ");
		sql.append("VALUES ('cytramon', 'HP', 30, 10)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO aids ");
		sql.append("(aidName, AidType, aidEffect, aidPrice) ");
		sql.append("VALUES ('amphetamine', 'damage', 50, 1050)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillCharacters() {
		StringBuilder sql = new StringBuilder("INSERT INTO characters ");
		sql.append("(experience, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (500, 20, 25, 1, 'pharaon', 50, 1, 1, 2, 3, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (0, 5, 50, 6, 'baba', 20, 5, 5, 6, 7, 8)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillCharactersTrunks() {
		StringBuilder sql = new StringBuilder("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 2, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 3, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 2)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillChatProperties() {
		StringBuilder sql = new StringBuilder("INSERT INTO chatProperties ");
		sql.append("VALUES (1, 'var')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO chatProperties ");
		sql.append("VALUES (2, 'rav')");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillUsers() {
		StringBuilder sql = new StringBuilder("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName) ");
		sql.append("VALUES ('janukovych@mail.ru', 'asdfasdf', 1000000, 1, 1, 'president')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName) ");
		sql.append("VALUES ('tymoshenko@ukr.net', 'asdfasdf', 100000, 2, 2, 'troublesome')");
		jdbcTemplate.update(sql.toString());
	}
	
	
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
		sql.append("experience INT(10) UNSIGNED NOT NULL DEFAULT 0, ");
		sql.append("strength INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
		sql.append("agility INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
		sql.append("intellect INT(5) UNSIGNED NOT NULL DEFAULT 5, ");
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
