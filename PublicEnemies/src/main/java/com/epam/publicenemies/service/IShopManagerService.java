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
 * Updated by I. Kostyrko on 19.05.12: added sell/buy methods
 *
 */
public interface IShopManagerService {
	
	// --- returns list of all aids, weapons and armors into database ---
	List <Aid> getAllAids();	
	List <Weapon> getAllWeapons();	
	List <Armor> getAllArmors();
	// ---	
	
	// --- allow to sell/buy items
	boolean sellWeaponsForUser(int uid, List<Integer> wIds);
	boolean sellArmorsForUser(int uid, List<Integer> arIds);
	boolean sellAidsForUser(int uid, List<Integer> aidIds);
	
	boolean buyWeaponsForUser(int uid, List<Integer> wIds);
	boolean buyArmorsForUser(int uid, List<Integer> arIds);
	boolean buyAidsForUser(int uid, List<Integer> aidIds);
	// ---
	
}
