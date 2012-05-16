package com.epam.publicenemies.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.service.IShopManagerService;
import com.epam.publicenemies.web.ShopController;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public class ShopManagerServiceImpl implements IShopManagerService {
	private Logger log = Logger.getLogger(ShopController.class);
	
	private IAidsDao aidDao;
	
	private IWeaponsDao weaponDao;
	private IArmorsDao armorDao;
	
	public void setAidDao(IAidsDao iad) {
		this.aidDao = iad; 
	}
	public void setArmorDao(IArmorsDao iArmor) {
		this.armorDao = iArmor; 
	}
	public void setWeaponDao(IWeaponsDao iWeapon) {
		this.weaponDao = iWeapon; 
	}
	
	@Override
	public List<Aid> getAllAids() {		 
		if (this.aidDao == null) {
			log.info("aidsDao is null"); 
		}
		return aidDao.fetchAllAids();		
	}

	@Override
	public List<Weapon> getAllWeapons() {
		if (this.weaponDao == null) {
			log.info("weaponDao is null"); 
		}
		return weaponDao.fetchAllWeapons();
	}

	@Override
	public List<Armor> getAllArmors() {
		if (this.armorDao == null) {
			log.info("armorDao is null"); 
		}
		return armorDao.fetchAllArmors();
	}
}
