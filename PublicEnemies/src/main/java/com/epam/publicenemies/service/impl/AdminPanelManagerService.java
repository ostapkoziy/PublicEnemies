package com.epam.publicenemies.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.service.IAdminPanelManagerService;

/**
 * 
 * @author I. Kostyrko
 * Updated by S. Chetyrkin
 *
 */
@Service
public class AdminPanelManagerService implements IAdminPanelManagerService {

	@Autowired
	private IProfileDao profileDao;
	
	@Autowired
	private IAidsDao aidsDao; 
	
	@Autowired 
	private IArmorsDao armorsDao;
	
	@Autowired
	private IWeaponsDao weaponsDao; 
	
	@Autowired
	private IUserDao userDao;
	
	private Logger log = Logger.getLogger(AdminPanelManagerService.class);
	
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
	public int addUser(String email, String password, String nickName,
			int money, String avatar) {
		return userDao.registerUser(email, password, nickName, money, avatar);
	}
	
	/**
	 * Get amount of registered users
	 * @return amount of registered users
	 */
	@Override
	public int getUsersNumber() {
		log.info("getting users amount");				
		return userDao.getUsersAmount();
	}
	
	/**
	 * Get last 5 registered users
	 * @return List of 5 users
	 */
	public List<User> get5LastRegisteredUsers() {
		List<User> list = userDao.getNewUsers();
		log.info("Getting new users");
		return list;
	}
	
	/**
	 * Get list of users by their ids
	 * @param usersid - list of users ids
	 * @return list of users
	 */
	public List<User> getUsers(List<Integer> usersId) {
		ArrayList<User> list = new ArrayList<User>();
		for(Integer i : usersId) {
			list.add(userDao.findUserById(i));
		}
		return list;
	}

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
	public boolean updateUserInfo(int userId, String email, String nickName, 
			String avatar, int money, int userCharacter) {
		return userDao.updateUserInfo(userId, email, nickName, avatar, money, userCharacter);
	}
	
	/**
	 * Get all registered users
	 * @return list of all registered users
	 */
	public List<User> getAllUsers () {
		log.info("Getting all users");
		return userDao.findAllUsers();
	}
	
	/**
	 * Add new weapon
	 * @param name - weapon name
	 * @param hitPoints - weapon hit points
	 * @param picture - weapon picture
	 * @param weaponType - weapon type
	 * @param price - weapon price
	 * @return id of created weapon
	 */
	public int addWeapon(String name, int hitPoints, String picture, boolean weaponType, int price) {
		return weaponsDao.addWeapon(name, hitPoints, picture, weaponType, price);
	}
	
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
	public boolean updateWeaponInfo(int weaponId, String weaponName, int hitPoints, String picture, boolean type, int price) {
		return weaponsDao.updateWeaponInfo(weaponId, weaponName, hitPoints, picture, type, price);
	}
	
	/**
	 * Get Weapon object by id
	 * @param weaponId - weapon id
	 * @return Weapon object
	 */
	public Weapon getWeaponById(int weaponId) {
		return weaponsDao.getWeaponById(weaponId);
	}
	
	/**
	 * Get Weapon object by weapon name 
	 * @param name - weapon name
	 * @return Weapon object
	 */
	public Weapon getWeaponByName(String name) {
		return weaponsDao.getWeaponByName(name);
	}
	
	/**
	 * Get all firearms
	 * @return list of firearms
	 */
	public List<Weapon> getAllFirearm() {
		return weaponsDao.getAllFirearm();
	}
	
	/**
	 * Get all cold steel
	 * @return list of all cold steel
	 */
	public List<Weapon> getAllColdSteel() {
		return weaponsDao.getAllColdSteel();
	}
	
	/**
	 * Get all weapons
	 * @return list of all weapons
	 */
	public List<Weapon> getAllWeapons() {
		return weaponsDao.fetchAllWeapons();
	}
	
	/**
	 * Get sorted list of users by nick name
	 * @return list of users
	 */
	public List<User> sortUsersByNick() {
		return userDao.getUsersSortedByNick();
	}
	
	/**
	 * Get sorted list of users by registration date
	 * @return list of users
	 */
	public List<User> sortUsersByRegDate() {
		return userDao.getUsersSortedByRegDate();
	}
	
	/**
	 * Get list of all weapons sorted by weapon name
	 * @return list of all weapons
	 */
	public List<Weapon> sortWeaponsByName() {
		return weaponsDao.getWeaponsSortedByName();
	}
	
	/**
	 * Get list of all weapons sorted by weapon hit points
	 * @return list of all weapons
	 */
	public List<Weapon> sortWeaponsByHitPoints() {
		return weaponsDao.getWeaponsSortedByHitPoints();
	}
	
	/**
	 * Get list of all weapons sorted by weapon price
	 * @return list of all weapons
	 */
	public List<Weapon> sortWeaponsByPrice() {
		return weaponsDao.getWeaponsSortedByPrice();
	}
	
}
