package com.epam.publicenemies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.service.IShopManagerService;

/**
 * Provides necessary facilities for the functioning of the PE shop
 * 
 * @author Ivan Kostyrko
 * Updated by I. Kostyrko on 19.05.12: sell/buy methods implemented
 * Updated by I. Kostyrko on 20.05.12: annotation style
 */
@Service
public class ShopManagerServiceImpl implements IShopManagerService {
	//private Logger log = Logger.getLogger(ShopController.class);
	@Autowired
	private IAidsDao aidDao;
	@Autowired
	private IWeaponsDao weaponDao;
	@Autowired
	private IArmorsDao armorDao;
	@Autowired
	private IProfileDao profileDao; 
	
	@Override
	public List<Aid> getAllAids() {		
		return aidDao.fetchAllAids();		
	}

	@Override
	public List<Weapon> getAllWeapons() {		
		return weaponDao.fetchAllWeapons();
	}

	@Override
	public List<Armor> getAllArmors() {		
		return armorDao.fetchAllArmors();
	}
	// In methods below are passed user ID and lists of ID's items to sell/buy
	// ------------------------------------------------------------------------
	@Override
	public boolean sellWeaponsForUser(int uid, List<Integer> wIds) {
		return profileDao.sellWeapons(uid, wIds);
	}
	@Override
	public boolean sellArmorsForUser(int uid, List<Integer> arIds) {
		return profileDao.sellArmors(uid, arIds);
	}
	@Override
	public boolean sellAidsForUser(int uid, List<Integer> aidIds) {
		return profileDao.sellAids(uid, aidIds);
	}
	@Override
	public boolean buyWeaponsForUser(int uid, List<Integer> wIds) {		
		return profileDao.buyWeapons(uid, wIds);
	}
	@Override
	public boolean buyArmorsForUser(int uid, List<Integer> arIds) {
		return profileDao.buyArmors(uid, arIds);
	}
	@Override
	public boolean buyAidsForUser(int uid, List<Integer> aidIds) {
		return profileDao.buyAids(uid, aidIds);
	}	
	// ------------------------------------------------------------------------
}
