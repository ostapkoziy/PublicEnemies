package com.epam.publicenemies.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.impl.UserDaoImpl;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.service.IUserRatingService;

@Service
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
	public List<Map<String, Object>> sortUsersByMoney() {
		return userDao.getUsersSortedByMoney();
	}

}
