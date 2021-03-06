package com.epam.publicenemies.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IUserManagerService;

/**
 * Updated by I. Kostyrko on May 19, 2012: removed unnecessary code 
 * TODO: REMOVE DTO (use domain instead)
 */
@Service
public class UserManagerServiceImpl implements IUserManagerService
{
	private Logger		log	= Logger.getLogger(UserManagerServiceImpl.class);
	
	@Autowired
	private IUserDao	userDao;
	
	private UserDto makeUserDto(User user) {
		return new UserDto(user);
	}
	/**
	 * Registers user based on email, pass and nickname First of all it inserts
	 * new entry into db and returns id of inserted entry After that - fetches
	 * inserted entry from bd by id and builds User object and UserDto object It
	 * seems to be unnecessary to write and then read from bd, but in this way
	 * we'll be sure that transaction done well and get more fields
	 */
	@Override
	public User registerNewUser(String uEmail, String uPasswd, String uNickName)
	{
		return userDao.findUserById(userDao.registerUser(uEmail, uPasswd, uNickName));
	}
	@Override
	public User getUserByEmailAndPassword(String name, String password)
	{
		User user = userDao.findUserByEmailAndPassword(name, password);
		if (user == null)
		{
			log.info("User wasn't found with email - " + name + " and pass - " + password);
			return null;
		}
		return user;
	}
	@Override
	public User findUserByEmail(String email)
	{
		User user = userDao.findUserByEmail(email);
		if (user == null)
		{
			log.info("User wasn't found with email - " + email);
			return null;
		}
		return user;
	}
	
	
	/**
	 * Find Admin by its unique email and not unique password
	 * @param email - admin email
	 * @param password - admin password
	 * @return User object
	 */
	public User getAdmin(String email, String password) {
		return userDao.findAdmin(email, password);
	}
	
	/**
	 * Update money amount
	 * 
	 * @param userId
	 *            - id of user
	 * @param money
	 *            - amount of money
	 * @return true if operation was successful
	 */
	public boolean updateMoney(int userId, int money)
	{
		if (userDao.updateMoney(userId, money))
		{
			log.info("User's (" + userId + ") money (" + money + ") was updated");
			return true;
		}
		else
			return false;
	}
	
	
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
			String avatar, int money, int userCharacter, String role) {
		return userDao.updateUserInfo(userId, email, nickName, avatar, money, userCharacter, role);
	}
	
	/**
	 * Get User object by user id
	 * @param userId - user id
	 * @return User object
	 */
	public User getUserById(int userId) {
		return userDao.findUserById(userId);
	}
}
