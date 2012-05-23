package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Weapon;

/**
 * 
 * @author Ivan Kostyrko
 *
 * Updated by Chetyrkin S.V.
 */
public interface IWeaponsDao {
	
	/**
	 * Gets all weapons entry from db
	 * @return list of weapons
	 */
	List<Weapon> fetchAllWeapons();

	/**
	 * Add new weapon
	 * @param name - weapon name
	 * @param hitPoints - weapon hit points
	 * @param picture - weapon picture
	 * @param weaponType - weapon type
	 * @param price - weapon price
	 * @return id of created weapon
	 */
	int addWeapon(String name, int hitPoints, String picture, boolean weaponType, int price);
	
	/**
	 * Add new weapon
	 * @param weapon - Weapon object
	 * @return id of created weapon
	 */
	int addWeapon(Weapon weapon);
	
	/**
	 * Get Weapon object by id
	 * @param weaponId - weapon id
	 * @return Weapon object
	 */
	Weapon getWeaponById(int weaponId);
	
	/**
	 * Get Weapon object by weapon name 
	 * @param name - weapon name
	 * @return Weapon object
	 */
	Weapon getWeaponByName(String name);
	
	/**
	 * Get all firearms
	 * @return list of firearms
	 */
	List<Weapon> getAllFirearm();
	
	/**
	 * Get all cold steel
	 * @return list of all cold steel
	 */
	List<Weapon> getAllColdSteel();
	
	/**
	 * Update weapon name
	 * @param weaponId - weapon id
	 * @param name - weapon name
	 * @return true if operation was successfully
	 */
	boolean updateWeaponName(int weaponId, String name);
	
	/**
	 * Update weapon hit points	
	 * @param weaponId - weapon id
	 * @param hitPoints - weapon hit points
	 * @return true if operation was successfully
	 */
	boolean updateWeaponHitPoints(int weaponId, int hitPoints);
	
	/**
	 * Update weapon picture
	 * @param weaponId - weapon id
	 * @param picture - weapon picture
	 * @return true if operation was successfully
	 */
	boolean updateWeaponPicture(int weaponId, String picture);
	
	/**
	 * Update weapon type
	 * @param weaponid - weapon Id
	 * @param weaponType - weapon type
	 * @return true if operation was successfully
	 */
	boolean updateWeaponType(int weaponId, boolean weaponType);
	
	/**
	 * Update weapon price
	 * @param weaponid - weapon id
	 * @param price - weapon price
	 * @return true if operation was successfully
	 */
	boolean updateWeaponPrice (int weaponId, int price);
	
	/**
	 * Get List of weapons by ids
	 * @param weaponsIds - list of weapons ids
	 * @return list of weapons
	 */
	List<Weapon> getWeapons(List<Integer> weaponsIds);
	
	/**
	 * Update weapon info
	 * @param weaponId - id of weapon
	 * @param weaponName - name of weapon
	 * @param hitPoints - weapon hit points
	 * @param Picture - weapon picture
	 * @param type - weapon type
	 * @param price - weapon price
	 * @return true if operation was successfully
	 */
	boolean updateWeaponInfo(int weaponId, String weaponName, int hitPoints, String picture, boolean type, int price);
	
}
