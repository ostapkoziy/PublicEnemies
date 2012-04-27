package com.epam.publicenemies.dao;

import java.util.List;

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
	@Deprecated
	User findUserByEmailAndPassword(String email, String password);

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
}
