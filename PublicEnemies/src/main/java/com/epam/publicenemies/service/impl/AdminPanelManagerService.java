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
import com.epam.publicenemies.service.IAdminPanelManagerService;


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
	
	private IUserDao userDao;
	
	private Logger log	= Logger.getLogger(AdminPanelManagerService.class);
	
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
	public List<User> getNewUsers() {
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

}
