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
	public UserDto registerNewUser(String uEmail, String uPasswd, String uNickName)
	{
		/*
		 * to understand action below: int insertedUserId =
		 * userDao.registerUser(uEmail, uPasswd, uNickName); // get inserted
		 * user User insertedUser = userDao.findUserById(insertedUserId);
		 * UserDto returnObj = new UserDto(insertedUser); return returnObj;
		 */
		return new UserDto(userDao.findUserById(userDao.registerUser(uEmail, uPasswd, uNickName)));
	}
	@Override
	public UserDto getUserByEmailAndPassword(String name, String password)
	{
		User user = userDao.findUserByEmailAndPassword(name, password);
		if (user == null)
		{
			log.info("User wasn't found with email - " + name + " and pass - " + password);
			return null;
		}
		return makeUserDto(user);
	}
	@Override
	public UserDto findUserByEmail(String email)
	{
		User user = userDao.findUserByEmail(email);
		if (user == null)
		{
			log.info("User wasn't found with email - " + email);
			return null;
		}
		return makeUserDto(user);
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
			String avatar, int money, int userCharacter) {
		return userDao.updateUserInfo(userId, email, nickName, avatar, money, userCharacter);
	}
}
