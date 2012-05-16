package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Armor;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public interface IArmorsDao {
	/**
	 * Gets all armors entry from db
	 * @return list of armors
	 */
	List<Armor> fetchAllArmors();

}
