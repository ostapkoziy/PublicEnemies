package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public interface IArmorsDao {
	
	/**
	 * Gets all armors entry from db
	 * @return list of armors
	 */
	List<Armor> getAllArmors();
	
	/**
	 * Add new armor
	 * @param name - armor name
	 * @param picture - armor picture
	 * @param protection - armor protection
	 * @param price - armor price
	 * @return id of created weapon
	 */
	int addArmor(String name, String picture, int protection, int price, String description);
	
	/**
	 * Update armor info
	 * @param armorId - id of armor
	 * @param name - armor name
	 * @param protection - armor protection
	 * @param picture - armor picture
	 * @param price - armor price
	 * @return true if operation was successfully
	 */
	boolean updateArmorInfo(int armorId, String name, int protection, String picture, int price, String description);
	
	/**
	 * Get Armor object by id
	 * @param armorId - armor id
	 * @return Armor object
	 */
	Armor getArmorById(int armorId);
	
	/**
	 * Get Armor object by armor name 
	 * @param name - armor name
	 * @return Armor object
	 */
	Armor getArmorByName(String name);
	
	/**
	 * Get all armors sorted by name
	 * @return - list of all armors
	 */
	List<Armor> getArmorsSortedByName();
	
	/**
	 * Get all armors sorted by price
	 * @return - list of all armors
	 */
	List<Armor> getArmorsSortedByPrice();
	
	/**
	 * Get all armors sorted by protection
	 * @return - list of all armors
	 */
	List<Armor> getArmorsSortedByProtection();
	
	/**
	 * Get armors amount
	 * @return amount of all armors
	 */
	int getArmorsAmount();
	
	/**
	 * Get all users that have same armor
	 * @param armorId - id of armor
	 * @return list of users
	 */
	List<User> getUsersWithArmor(int armorId);
}
