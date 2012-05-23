package com.epam.publicenemies.service;

import java.util.List;

import com.epam.publicenemies.domain.User;

/**
 * 
 * @author I. Kostyrko
 * Updated by S. Chetyrkin
 *
 */
public interface IAdminPanelManagerService {
	
	/**
	 * Get amount of registered users
	 * @return amount of registered users
	 */
	public int getUsersNumber(); 
	
	/**
	 * Get last 5 registered users
	 * @return List of 5 users
	 */
	public List<User> get5LastRegisteredUsers();
	
	/**
	 * Get list of users by their ids
	 * @param usersid - list of users ids
	 * @return list of users
	 */
	public List<User> getUsers(List<Integer> usersid);
}
