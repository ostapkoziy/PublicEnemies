package com.epam.publicenemies.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.service.IUserRatingService;

@Service
public class UserRatingServiceImpl implements IUserRatingService {

	private Logger		log	= Logger.getLogger(UserRatingServiceImpl.class);
	
	@Autowired
	private IUserDao userDao;
	
	
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
	public List<Map<String, Object>> sortUsersByMoney() {
		return userDao.getUsersSortedByMoney();
	}

}
