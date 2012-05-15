package com.epam.publicenemies.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.domain.Aid;
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
	
	public void setAidDao(IAidsDao iad) {
		this.aidDao = iad; 
	}
	
	@Override
	public List<Aid> getAllAids() {	
		//List<Aid> aids = new ArrayList<Aid>(); 
		if (this.aidDao == null) {
			log.info("aidsDao is null"); 
		}
		return aidDao.fetchAllAids(); 
		/*if (aids == null) {
			log.info("ShopManagerServiceImpl: getAll - null"); 
		} else {
			log.info("ShopManagerServiceImpl: getAll - not null");
		}
		return aids;*/
	}
	@Override
	public void voidMethod() {
		log.info("ShopManagerServiceImpl: void method is invoked");		
	}

}
