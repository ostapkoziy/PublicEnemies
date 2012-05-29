package com.epam.publicenemies.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.publicenemies.dao.impl.UserDaoImpl;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.service.IUserRatingService;

public class UserRatingServiceImpl implements IUserRatingService {

	@Autowired
	private UserDaoImpl userDao;
	
	/**
	 * Get list of Maps. Map has two values: nickname with key 'nickName'
	 * and experience with key 'experience' 
	 * @return list of maps
	 */
	@Override
	public List<Map<String, Object>> sortUsersByExperience() {
		return userDao.getUsersSortedByExperience();
	}

	/**
	 * Get list of all users sorted by money amount
	 * @return list of all users
	 */
	@Override
	public List<User> sortUsersByMoney() {
		return userDao.getUsersSortedByMoney();
	}

	/**
	 * Get list of all users sorted by registration date
	 * @return list of all users
	 */
	@Override
	public List<User> sortUsersByRegDate() {
		return userDao.getUsersSortedByRegDate();
	}

}
