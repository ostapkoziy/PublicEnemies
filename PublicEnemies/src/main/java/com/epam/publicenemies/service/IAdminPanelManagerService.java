package com.epam.publicenemies.service;

import java.util.List;

import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;

/**
 * 
 * @author I. Kostyrko
 * Updated by S. Chetyrkin
 *
 */
public interface IAdminPanelManagerService {
	
	/**
	 * Add new user
	 * @param email - user email
	 * @param password - user password
	 * @param nickName - user nickName
	 * @param money - money of user
	 * @param avatar - user avatar
	 * @param userChar - id of user's character
	 * @return id of registered user
	 */
	int addUser(String email, String password, String nickName,
			int money, String avatar);
	
	/**
	 * Get amount of registered users
	 * @return amount of registered users
	 */
	public int getUsersNumber(); 
	
	/**
	 * Get last 5 registered users
	 * @return List of 5 users
	 */
	public List<User> get5LastRegisteredUsers();
	
	/**
	 * Get list of users by their ids
	 * @param usersid - list of users ids
	 * @return list of users
	 */
	public List<User> getUsers(List<Integer> usersid);
	
	/**
	 * Update user's fields
	 * @param userId - user id
	 * @param email - user's email
	 * @param nickname - user's nick name
	 * @param avatar - user's avatar
	 * @param money - user's amount of money
	 * @param userCharacter - id of users's character
	 * @return
	 */
	public boolean updateUserInfo(int userId, String email, String nickName, String avatar, int money, int userCharacter);
	
	/**
	 * Get all registered users
	 * @return list of all registered users
	 */
	public List<User> getAllUsers ();
	
	/**
	 * Get sorted list of users by nick name
	 * @return list of users
	 */
	List<User> sortUsersByNick();
	
	/**
	 * Get sorted list of users by registration date
	 * @return list of users
	 */
	List<User> sortUsersByRegDate();
	
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
	 * Get all weapons
	 * @return list of all weapons
	 */
	public List<Weapon> getAllWeapons(); 
	
	/**
	 * Get list of all weapons sorted by weapon name
	 * @return list of all weapons
	 */
	List<Weapon> sortWeaponsByName();
	
	/**
	 * Get list of all weapons sorted by weapon hit points
	 * @return list of all weapons
	 */
	List<Weapon> sortWeaponsByHitPoints();
	
	/**
	 * Get list of all weapons sorted by weapon price
	 * @return list of all weapons
	 */
	List<Weapon> sortWeaponsByPrice();

	
}
