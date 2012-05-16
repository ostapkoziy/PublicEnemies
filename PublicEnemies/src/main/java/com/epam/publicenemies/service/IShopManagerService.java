package com.epam.publicenemies.service;

import java.util.List;

import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.Weapon;

/**
 * Contains all necessary methods for shop
 * 
 * @author Ivan Kostyrko
 *
 */
public interface IShopManagerService {
	
	// --- returns list of all aids, weapons and armors into database ---
	List <Aid> getAllAids();	
	List <Weapon> getAllWeapons();	
	List <Armor> getAllArmors();
	// ---	
}
