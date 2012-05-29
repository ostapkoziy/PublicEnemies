package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.User;

/**
 * 
 * @author Ivan Kostyrko
 * Updated Chetyrkin S.V.
 *
 */
public interface IAidsDao {
	
	/**
	 * Gets all aids entry from db
	 * @return list of aids
	 */
	public List<Aid> getAllAids();
	
	/**
	 * Add new aid
	 * @param name - aid name
	 * @param type - aid type
	 * @param effect - aid effect
	 * @param picture - aid picture
	 * @param price - aid price
	 * @param description - aid description
	 * @return id of new aid
	 */
	int addAid (String name, String type, int effect, String picture, int price, String description);
	
	/**
	 * Update aid info
	 * @param name - aid name
	 * @param type - aid type
	 * @param effect - aid effect
	 * @param picture - aid picture
	 * @param price - aid price
	 * @param description - aid description
	 * @return true if operation was successfully
	 */
	boolean updateAidInfo (int aidId, String name, String type, int effect, String picture, int price, String description);

	/**
	 * Get Aid object by id
	 * @param aidId - aid id 
	 * @return
	 */
	Aid getAidById(int aidId);
	
	/**
	 * Get Aid object by aid name
	 * @param aidName - aid name
	 * @return Aid object
	 */
	Aid getAidByName(String aidName);
	
	/**
	 * Get list of all aids sorted by their names
	 * @return list of all aids
	 */
	List<Aid> getAidsSortedByName();
	
	/**
	 * Get list of all aids sorted by their prices
	 * @return list of all aids
	 */
	List<Aid> getAidsSortedByPrice();
	
	/**
	 * Get list of all aids sorted by their effects
	 * @return list of all aids
	 */
	List<Aid> getAidsSortedByEffect();
	
	/**
	 * Get aids amount 
	 * @return amount of aids
	 */
	int getAidsAmount();
	
	/**
	 * Get all users that have same aid
	 * @param aidId - id of aid
	 * @return list of users
	 */
	List<User> getUsersWithAid(int aidId);
}
