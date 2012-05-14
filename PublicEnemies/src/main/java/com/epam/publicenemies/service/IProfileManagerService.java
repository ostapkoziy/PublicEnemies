package com.epam.publicenemies.service;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.dto.ProfileDto;
import com.epam.publicenemies.dto.UserDto;


public interface IProfileManagerService {
	
	/**
	 * Updates profile
	 * Fields that could be updated: 
	 * 		email, 
	 * 		password, 
	 * 		nickName,
	 * 		avatar, 
	 * 		sex (TODO: need to discuss - images)
	 * something else?
	 * 
	 * Updated by I. Kostyrko by May 2, 2012     
	 * @param profileDto
	 * @return
	 */	
	ProfileDto updateProfile(ProfileDto profileDto);
	
		
	/**
	 * Updates nickName, avatar, sex (?) and profession for user (uId)
	 * TODO: change return type (boolean, ProfileDto) 
	 */
	void updateProfile(int uid, String nickName, String avatar, boolean sex, String prof);

	/**
	 * Returns profile for passed user
	 * 
	 * @param userDto 
	 * @return profile for passed user
	 */
	ProfileDto getProfileByUser(UserDto userDto);
	
	/**
	 * Returns profile for passed userId
	 * @param userId
	 * @return profile, that corresponds to passed userId
	 */
	Profile getProfileByUserId(int userId);

}
