package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.ITableDao;


/**
 * 
 * This class intended to create and delete all necessary tables
 * Be caution - its destroys all existing data in db
 * Updated by I. Kostyrko on Apr 27, 2012
 * Updated by I. Kostyrko on May 16, 2012 - filling tables
 * 
 */
@Repository
public class TableDaoImpl implements ITableDao {
	
	private Logger log = Logger.getLogger(TableDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
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
		final String fw = "INSERT INTO weapons (weaponName, weaponHitPoints, weaponType, weaponPicture, weaponPrice) ";
		StringBuilder sql = new StringBuilder("");
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Knuckle', 10, 0, './img/weapons/knuckle.png', 100)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Extinguisher', 120, 0, './img/weapons/extinguisher.png', 200)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Bat', 120, 0, './img/weapons/bat.png', 200)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Sickle', 120, 0, './img/weapons/sickle.png', 200)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());	
		//-------------------------------------------------------		
		sql.append(fw);
		sql.append("VALUES ('Katana', 120, 0, './img/weapons/katana.png', 500)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());		
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Chainsaw', 120, 0, './img/weapons/chainsaw.png', 500)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());		
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Desert Eagle', 120, 1, './img/weapons/desert_eagle.png', 800)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		
		sql.append(fw);
		sql.append("VALUES ('USP Tactical', 120, 0, './img/weapons/usp_tactical.png', 500)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());		
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('Short gun', 60, 1, './img/weapons/short_gun.png', 1000)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('TMP', 120, 1, './img/weapons/tmp.png', 3000)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('M3 Super90', 120, 1, './img/weapons/m3_super90.png', 3000)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('XM1014', 120, 1, './img/weapons/xm1014.png', 3000)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('M4A1', 120, 1, './img/weapons/m4a1.png', 3000)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('AK-47', 150, 1, './img/weapons/ak-47.png', 3500)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fw);
		sql.append("VALUES ('awp', 150, 1, './img/weapons/awp.png', 3500)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
	}
	
	private void fillArmors(){
		final String fa = "INSERT INTO armors (armorName, armorProtection, armorPicture, armorPrice) ";
		StringBuilder sql = new StringBuilder("");
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('low', 50, './img/armors/low.png', 50)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('low_mid', 60, './img/armors/low_mid.png', 60)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('mid', 80, './img/armors/mid.png', 80)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('mid_advanced', 90, './img/armors/mid_advanced.png', 90)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('mid_hight', 100, './img/armors/mid_hight.png', 100)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(fa);
		sql.append("VALUES ('hight', 120, './img/armors/hight.png', 120)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		
	}
	
	private void fillAids() {
		final String aidsSql = "INSERT INTO aids (aidName, AidType, aidEffect, aidPicture, aidPrice) ";
		StringBuilder sql = new StringBuilder("");
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('small', 'HP', 20, './img/aids/small.png', 50)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('medium', 'HP', 50, './img/aids/medium.png', 70)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('lagre', 'HP', 70, './img/aids/large.png', 100)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('very_lagre', 'HP', 100, './img/aids/very_large.png', 150)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());	
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('Average', 'HP', 100, './img/aids/average.png', 150)");
		jdbcTemplate.update(sql.toString());
		
		sql.delete(0, sql.length());	
		//-------------------------------------------------------
		sql.append(aidsSql);
		sql.append("VALUES ('Shugar', 'HP', 100, './img/aids/extra.png', 150)");
		jdbcTemplate.update(sql.toString());
				
		sql.delete(0, sql.length());	
	}
	
	private void fillCharacters() {
		// 1-st character
		StringBuilder sql = new StringBuilder("INSERT INTO characters ");
		sql.append("(experience, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (500, 20, 25, 1, 'Gangster', 50, 1, 1, 2, 5, 7)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		// 2-nd character
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (0, 5, 50, 6, 'Thief', 20, 5, 9, 10, 13, 15)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		// 3-rd character 
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (1, 5, 50, 6, 'Assasin', 20, 5, 17, 18, 22, 23)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		// 4-th character
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (1, 5, 50, 6, 'Criminal', 20, 5, 25, 26, 30, 31)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		// 5-th character
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (1, 5, 50, 6, 'Professor', 20, 5, 33, 34, 38, 39)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		// 6-th character
		sql.append("INSERT INTO characters ");
		sql.append("(sex, strength, agility, intellect, profession, ");
		sql.append("fightsTotal, fightsWon, weapon1, weapon2, aid, armor) ");
		sql.append("VALUES (1, 5, 50, 6, 'Butcher', 20, 5, 41, 42, 46, 47)");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillCharactersTrunks() {
		// ------------------------ janukovych weapons ----------------------------------
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
		sql.append("VALUES (3, 1, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 1, 1)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ janukovych aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 2, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 1)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ janukovych armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 3, 1)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 1)");
		jdbcTemplate.update(sql.toString());
				
		// ------------------------ tymoshenko weapons ----------------------------------
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
		sql.append("VALUES (10, 1, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (12, 1, 2)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ tymoshenko aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 2, 2)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ tymoshenko armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 2)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 3, 2)");
		jdbcTemplate.update(sql.toString());
		
		// ------------------------ admin weapons ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 3)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 3)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (3, 1, 3)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 1, 3)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ admin aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 2, 3)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 3)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ admin armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 3, 3)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 3)");
		jdbcTemplate.update(sql.toString());
		
		// ------------------------ 1 weapons ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (10, 1, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (12, 1, 4)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ 1 aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 2, 4)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ 1 armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 4)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 3, 4)");
		jdbcTemplate.update(sql.toString());
		
		// ------------------------ 2 weapons ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 5)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 5)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (3, 1, 5)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 1, 5)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ 2 aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 2, 5)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 5)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ 2 armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 3, 5)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 5)");
		jdbcTemplate.update(sql.toString());
		
		// ------------------------ someone weapons ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 1, 6)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 1, 6)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (3, 1, 6)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (4, 1, 6)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ someone aids ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 2, 6)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 2, 6)");
		jdbcTemplate.update(sql.toString());
		// ------------------------ someone armors ----------------------------------
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (1, 3, 6)");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO charactersTrunks ");
		sql.append("(itemId, itemType, characterId) ");
		sql.append("VALUES (2, 3, 6)");
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
		sql.delete(0, sql.length());
		sql.append("INSERT INTO chatProperties ");
		sql.append("VALUES (3, 'rav')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO chatProperties ");
		sql.append("VALUES (4, 'rav')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO chatProperties ");
		sql.append("VALUES (5, 'rav')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		sql.append("INSERT INTO chatProperties ");
		sql.append("VALUES (6, 'rav')");
		jdbcTemplate.update(sql.toString());
	}
	
	private void fillUsers() {
		// janukovych
		StringBuilder sql = new StringBuilder("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('janukovych@mail.ru', 'asdfasdf', 1000000, 1, 1, 'president', './img/avatars/godfather.png')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// tymoshenko
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('tymoshenko@ukr.net', 'asdfasdf', 100000, 2, 2, 'troublesome', './img/avatars/angelina.png')");
		jdbcTemplate.update(sql.toString());
		sql.delete(0, sql.length());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// admin
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('admin@admin', 'admin', 100000, 3, 3, 'admin', './img/avatars/tommy.png')");
		jdbcTemplate.update(sql.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 1
		sql.delete(0, sql.length());
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('1', '1', 100000, 4, 4, '1', './img/avatars/gangster.png')");
		jdbcTemplate.update(sql.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 2
		sql.delete(0, sql.length());
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('2', '2', 100000, 5, 5, '2', './img/avatars/mafia.png')");
		jdbcTemplate.update(sql.toString());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// someone
		sql.delete(0, sql.length());
		sql.append("INSERT INTO users ");
		sql.append("(email, password, money, chatProperty, userCharacter, nickName, avatar) ");
		sql.append("VALUES ('someone@some.ua', 'someone', 100000, 6, 6, 'someone', './img/avatars/default.png')");
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
		sql.append("FOREIGN KEY (userCharacter) REFERENCES characters(characterId) ON DELETE CASCADE ");
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
		sql.append("profession VARCHAR(100) NOT NULL DEFAULT 'Gangster' ");
		sql.append("check (profession in('Butcher', 'Gangster', 'Criminal', ");
		sql.append("'Thief', 'Assasin', 'Professor' )), ");
		sql.append("professionAvatar VARCHAR(100) NOT NULL DEFAULT '', ");
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
		sql.append("FOREIGN KEY (characterId) REFERENCES characters(characterId) ON DELETE CASCADE ");
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
		sql.append("weaponDescription TEXT NULL, ");
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
		sql.append("armorDescription TEXT NULL, ");
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
		sql.append("aidDescription TEXT NULL, ");
		sql.append("PRIMARY KEY (aidId) ");
		sql.append(") ENGINE=INNODB");
		jdbcTemplate.execute(sql.toString());
	}
}
