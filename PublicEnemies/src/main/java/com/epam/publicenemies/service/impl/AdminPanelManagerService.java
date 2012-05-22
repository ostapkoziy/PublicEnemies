package com.epam.publicenemies.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.service.IAdminPanelManagerService;


@Service
public class AdminPanelManagerService implements IAdminPanelManagerService {

	@Autowired
	private IProfileDao profileDao;
	
	@Autowired
	private IAidsDao aidsDao; 
	
	@Autowired 
	private IArmorsDao armorsDao;
	
	@Autowired
	private IWeaponsDao weaponsDao; 
	
	@Override
	public int getUsersNumber() {
		// TODO Auto-generated method stub
		//profileDao.getCharacterByUserId(1);
		return 5;
	}

}
