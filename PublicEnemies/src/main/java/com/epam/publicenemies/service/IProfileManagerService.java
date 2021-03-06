package com.epam.publicenemies.service;

import com.epam.publicenemies.domain.Profile;
//import com.epam.publicenemies.dto.ProfileDto;
//import com.epam.publicenemies.dto.UserDto;

/**
 * 
 * Updated by I. Kostyrko
 * TODO: remove unnecessary methods, dto
 *
 */
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
	//ProfileDto updateProfile(ProfileDto profileDto);
	
		
	/**
	 * Updates nickName, avatar, sex (?) and profession for user (uId)
	 * TODO: change return type (boolean, ProfileDto) 
	 */
	void updateProfile(int uid, String nickName, String avatar, boolean sex, byte prof);

	/**
	 * Returns profile for passed user
	 * 
	 * @param userDto 
	 * @return profile for passed user
	 */
	//ProfileDto getProfileByUser(UserDto userDto);
	
	/**
	 * Returns profile for passed userId
	 * @param userId
	 * @return profile, that corresponds to passed userId
	 */
	Profile getProfileByUserId(int userId);
	
	/**
	 * Undress first weapon
	 * @return true if operation is successfully
	 */
	boolean undressWeapon1(int userId);
	
	/**
	 * Undress second weapon
	 * @return true if operation is successfully
	 */
	boolean undressWeapon2(int userId);
	
	/**
	 * Undress aid
	 * @return true if operation is successfully
	 */
	boolean undressAid(int userId);
	
	/**
	 * Undress armor
	 * @return true if operation is successfully
	 */
	boolean undressArmor(int userId);
	
	/**
	 * Dress first weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	boolean dressWeapon1(int userId, int weaponId);
	
	/**
	 * Dress second weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	boolean dressWeapon2(int userId, int weaponId);
	
	/**
	 * Dress aid
	 * @param userId - id of user
	 * @param aidId - aid id
	 * @return true if operation is successfully
	 */
	boolean dressAid(int userId, int aidId);
	
	/**
	 * Dress armor
	 * @param userId - id of user
	 * @param armorId - armor id
	 * @return true if operation is successfully
	 */
	boolean dressArmor(int userId, int armorId);
	
	/**
	 * Check weapon2 slot
	 * @param userId - id of user
	 * @return true if weapon2 slot is empty
	 */
	boolean isEmptyWeapon2(int userId);
	
	/**
	 * Update money amount
	 * @param userId - id of user
	 * @param money - amount of money
	 * @return true if operation was successful
	 */
	boolean updateMoney(int userId, int money);

	/**
	 * Add some experience amount to userCharacter
	 * @param characterId - id of character
	 * @param experience - experience amount to add
	 * @return true if operation was successfully
	 */
	boolean addExperience(int characterId, int experience);
	
	/**
	 * Update experience amount for character
	 * @param characterId - id of character
	 * @param experience - new experience amount
	 * @return true if operation was successfully
	 */
	boolean updateExperience(int characterId, int experience);
	
	/**
	 * Update character's stats
	 * @param strength - strength of character
	 * @param agility - agility of character
	 * @param intellect - intellect of character
	 * @return
	 */
	boolean updateStats(int characterId, int strength, int agility, int intellect);
	
	/**
	 * Update won fights amount
	 * @param characterId - character Id
	 * @param wonFights - amount of won fights
	 * @return true if operation was successfully
	 */
	boolean updateWonFights(int characterId, int wonFights);
	
	/**
	 * Update lost fights amount
	 * @param characterId - character Id
	 * @param lostFights - amount of lost fights
	 * @return true if operation was successfully
	 */
	boolean updateTotalFights(int characterId, int lostFights);

	/**
	 * Uses aid in battle
	 * @param characterId - character id
	 * @return true if operation was successfully
	 */
	boolean useAid(int characterId);
}
