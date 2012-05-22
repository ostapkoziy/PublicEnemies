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
}
