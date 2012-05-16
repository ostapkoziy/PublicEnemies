package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Aid;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public interface IAidsDao {
	/**
	 * Gets all aids entry from db
	 * @return list of aids
	 */
	public List<Aid> fetchAllAids();
	

}
