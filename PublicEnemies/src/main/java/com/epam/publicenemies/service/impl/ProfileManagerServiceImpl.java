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

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.UserDto;
import com.epam.publicenemies.service.IProfileManagerService;
import com.epam.publicenemies.web.LoginUserFormController;

/**
 * Updated by I. Kostyrko on 01.05.12
 */
public class ProfileManagerServiceImpl implements IProfileManagerService {

	private Logger log	= Logger.getLogger(LoginUserFormController.class);
	
	private IProfileDao profileDao;

	public void setProfileDao(IProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	/*
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#getProfileByUserId(int)
	 */
	@Override
	public ProfileDto getProfileByUserId(int userId) {
		User user = profileDao.getUserById(userId);
		if (user == null) {
			log.info("ProfileDto: getProfileByUser: user was not found");
			return null; 
		}
		log.info("User has been fetched with userId = " + user.getUserId());
		UCharacter userChar = profileDao.getCharacterById(user.getCharacterId());
		// TODO: Not sure: is it allowed that dto classes knows about domain classes
		return  new ProfileDto(user, userChar);		
	}	

	/*
	 * 
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#updateProfile(com.epam.publicenemies.dto.ProfileDto)
	 * TODO: implement it
	 */
	@Override
	public ProfileDto updateProfile(ProfileDto profileDto) {
		
		return profileDto;
	}

	/*
	 * 
	 * Updated by I. Kostyrko by May 2, 2012
	 * @see com.epam.publicenemies.service.IProfileManagerService#getProfileByUser(com.epam.publicenemies.dto.UserDto)
	 */
	@Override
	public ProfileDto getProfileByUser(UserDto userDto) {
		return getProfileByUserId(userDto.getUserId()); 
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
}
