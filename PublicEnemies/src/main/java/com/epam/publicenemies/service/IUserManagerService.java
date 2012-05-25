package com.epam.publicenemies.service;

import com.epam.publicenemies.dto.UserDto;

/**
 * TODO: remove DTO objects
 */
public interface IUserManagerService {
	
	UserDto registerNewUser(String uEmail, String uPasswd, String uNickName);

	UserDto findUserByEmail(String email);
	
	UserDto getUserByEmailAndPassword(String name, String password);
	
	/**
	 * Update money amount
	 * @param userId - id of user
	 * @param money - amount of money
	 * @return true if operation was successful
	 */
	boolean updateMoney(int userId, int money);
	
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
}
