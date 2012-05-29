/**
 * 
 */
package com.epam.publicenemies.service;

import java.util.List;
import java.util.Map;

import com.epam.publicenemies.domain.User;

/**
 * @author Chetyrkin_Sviatoslav 29.05.2012
 *
 */
public interface IUserRatingService {
	
	/**
	 * Get list of Maps. Map has two values: nickname with key 'nickName'
	 * and experience with key 'experience' 
	 * @return list of maps
	 */
	List<Map<String, Object>> sortUsersByExperience();
	
	/**
	 * Get list of all users sorted by money amount
	 * @return list of all users
	 */
	List<User> sortUsersByMoney();
	
	/**
	 * Get list of all users sorted by registration date
	 * @return list of all users
	 */
	List<User> sortUsersByRegDate();
	
	

}
