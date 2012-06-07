package com.epam.publicenemies.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.epam.publicenemies.domain.User;

/**
 * Updated by Chetyrkin S.V. 26 квіт. 2012
 */

public interface IUserDao {
	
	/**
	 * Register new user with email, password and nick name
	 * @param user - User object
	 * @return id of inserted user
	 */
	int registerUser(User user);
	
	/**
	 * Register new user
	 * @param email - user email
	 * @param password - user password
	 * @param nickName - user nickName
	 * @param money - money of user
	 * @param avatar - user avatar
	 * @param userChar - id of user's character
	 * @return id of registered user
	 */
	int registerUser(String email, String password, String nickName,
			int money, String avatar);
	
	/**
	 * Get amount of of registered users
	 * @return amount of of registered users
	 */
	int getUsersAmount ();
	
	/**
	 * Get last 5 registered users
	 * @return List of 5 users
	 */
	List<User> getNewUsers();
	
	/**
	 * Register new user with email, password and nick name
	 * @param email - email of new user
	 * @param password - password of new user
	 * @param nickname - nick name of new user
	 * @return id of inserted user
	 */
	int registerUser(String email, String password, String nickName);
	
	/**
	* Check for existing registered email
	* @param email - checked email
	* @return boolean exist or not
	* */
	boolean checkExistedUserEmail (String email);
	
	/**
	* Find user by its unique id
	* @param id - id of user you are looking for
	* @return User object
	* */
	User findUserById(int id);
	
	/**
	* Find user by its unique email and not unique password
	* @param email - user email
	* @param password - user password
	* @return User object
	* */
	User findUserByEmailAndPassword(String email, String password);
	
	/**
	 * Find Admin by its unique email and not unique password
	 * @param email - admin email
	 * @param password - admin password
	 * @return User object
	 */
	User findAdmin(String email, String password);

	/**
	* Find user by his/her unique email
	* @param email - email of user you are looking for
	* @return User object
	* */
	User findUserByEmail(String email);
	
	/**
	* Update user email and password
	* @param user - User object
	* @return true if operation successfully 
	* */
	boolean updateUserEmailAndPassword(User user);

	/**
	* Update user avatar
	* @param userId - id of user
	* @param avatar - path to avatar image on server
	* @return true if operation successfully  
	* */
	boolean updateUserAvatar(int userId, String avatar);

	/**
	* Update user nick name
	* @param userId - id of user
	* @param nickName - nick name of user
	* @return true if operation successfully  
	* */
	boolean updateUserNickName(int userId, String nickName);
	
	/**
	* Change all user personal information (user are fetched by id)
	* @param user - User object
	* @return true if operation successfully  
	* */
	boolean updateUserInfo (User user);
	
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
	boolean updateUserInfo (int userId, String email, String nickName, String avatar, int money, int userCharacter, String role);
	
	/**
	* Delete user
	* @param userId - id of user
	* */
	boolean deleteUser(int userId);
	
	/**
	* Delete user
	* @param user - User object
	* */
	boolean deleteUser(User user);
	
	/**
	* Fetch all users from database
	* @return List<User> - list of all users on database
	* */
	List<User> findAllUsers();
	
	/**
	 * Update money amount
	 * @param userId - id of user
	 * @param money - amount of money
	 * @return true if operation was successful
	 */
	boolean updateMoney (int userId, int money);
	
	/**
	 * Get user registration date
	 * @param userId - id of user
	 * @return - registration date
	 */
	Timestamp getUserRegDate (int userId);
	
	/**
	 * Get list of all users sorted by nick name
	 * @return list of all users
	 */
	List<User> getUsersSortedByNick();
	
	/**
	 * Get list of all users sorted by registration date
	 * @return list of all users
	 */
	List<User> getUsersSortedByRegDate();
	
	/**
	 * Get list of Maps. Map has two values: nickname with key 'nickName'
	 * and experience with key 'experience' 
	 * @return list of maps
	 */
	List<Map<String, Object>> getUsersSortedByExperience();
	
	/**
	 * Get list of all users sorted by money amount
	 * @return list of all users
	 */
	List<Map<String, Object>> getUsersSortedByMoney();
}
