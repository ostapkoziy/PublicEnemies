package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Weapon;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public interface IWeaponsDao {
	/**
	 * Gets all weapons entry from db
	 * @return list of weapons
	 */
	List<Weapon> fetchAllWeapons();

}
