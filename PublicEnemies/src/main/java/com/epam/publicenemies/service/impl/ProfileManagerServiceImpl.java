/*
 * Don't remove, please
 * To remember:
 * DTO = Data Transfer Object, used to transfer data between loosly coupled services
 * POCO(POJO) = Plain Old Clr Object, normal CLR object doesn't use any attributes or required inheritance to act as a DAO/DTO
 * BO (Service?) = Business Object, contains business logic, used in the Business Logic part of your solution
 * DAO = Data Access Object, used to transfer data from your database
 * 
 * domain between DAO and BO
 * dto between BO and UI (JSP)
 * 
 */

package com.epam.publicenemies.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IProfileManagerService;

/**
 * Updated by I. Kostyrko on 01.05.12
 * TODO: replace DTO objects! use domain instead
 * Updated by I. Kostyrko on 20.05.12: annotation driven style (tried but no success)
 */
@Service
public class ProfileManagerServiceImpl implements IProfileManagerService {

	private Logger log	= Logger.getLogger(ProfileManagerServiceImpl.class);
	
	@Autowired
	private IProfileDao profileDao;

	/*public void setProfileDao(IProfileDao profileDao) {
		this.profileDao = profileDao;
	}*/

	/*
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#getProfileByUserId(int)
	 */
	@Override
	public Profile getProfileByUserId(int userId) {
		Profile prof = profileDao.getProfile(userId);
		
		if (prof == null) {
			log.info("ProfileDto: getProfileByUser: user was not found");
			return null; 
		}
		log.info("User has been fetched with userId = " + prof.getUserId());
		
		return prof; 
	}	

	/*
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#updateProfile(com.epam.publicenemies.dto.ProfileDto)
	 * TODO: implement it
	 */
	@Deprecated
	@Override
	public ProfileDto updateProfile(ProfileDto profileDto) {
		
		return profileDto;
	}

	/*
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#getProfileByUser(com.epam.publicenemies.dto.UserDto)
	 * no matter
	 */
	@Deprecated
	@Override
	public ProfileDto getProfileByUser(UserDto userDto) {
		return new ProfileDto(); //getProfileByUserId(userDto.getUserId()); 
	}

	/*
	 * Implements user updating
	 * @see com.epam.publicenemies.service.IProfileManagerService#updateProfile(int, java.lang.String, java.lang.String, boolean, java.lang.String)
	 */
	@Override
	public void updateProfile(int uid, String nickName, String avatar,
			boolean sex, String prof) {
		profileDao.updateProfile(uid, nickName, avatar, sex, prof);		
	}

	/**
	 * Undress first weapon
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressWeapon1(int userId) {
		return profileDao.undressWeapon1(userId);
	}

	/**
	 * Undress second weapon
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressWeapon2(int userId) {
		return profileDao.undressWeapon2(userId);
	}

	/**
	 * Undress aid
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressAid(int userId) {
		return profileDao.undresAid(userId);
	}

	/**
	 * Undress armor
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressArmor(int userId) {
		return profileDao.undressArmor(userId);
	}
	
	/**
	 * Dress first weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	public boolean dressWeapon1(int userId, int weaponId) {
		return profileDao.dressWeapon1(userId, weaponId);
	}
	
	/**
	 * Dress second weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	public boolean dressWeapon2(int userId, int weaponId) {
		return profileDao.dressWeapon2(userId, weaponId);
	}
	
	/**
	 * Dress aid
	 * @param userId - id of user
	 * @param aidId - aid id
	 * @return true if operation is successfully
	 */
	public boolean dressAid(int userId, int aidId) {
		return profileDao.dressAid(userId, aidId);
	}
	
	/**
	 * Dress armor
	 * @param userId - id of user
	 * @param armorId - armor id
	 * @return true if operation is successfully
	 */
	public boolean dressArmor(int userId, int armorId) {
		return profileDao.dressArmor(userId, armorId);
	}
}
