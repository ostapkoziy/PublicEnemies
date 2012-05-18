package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;

public interface IProfileDao {
	/*Profile getProfileByUser(User user);*/

	//void updateProfile(Profile profile);
	
	void updateProfile(int uid, String nickName, String avatar, boolean sex,
			String prof);
	
	//void deleteProfile(Profile profile);
	
	User getUserById(int userId);

	UCharacter getCharacterByUserId(int userId);

	UCharacter getCharacterById(int characterId);
	
	Profile getProfile(int userId);
	
	
	
	/**
	 * Buy weapons for user
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	boolean buyWeapons(int userId, List<Integer> weapons);

	/**
	 * Buy aids for user
	 * @param userId - id of user
	 * @param aids - List of weapons ids
	 * @return true if operation was successfully
	 */
	boolean buyAids(int userId, List<Integer> aids);
	
	
	/**
	 * Get character by user note
	 * @param user - User object
	 * @return UCharacter object
	 */
	UCharacter getCharacter(User user);
	
	/**
	 * Update character sex
	 * @param userId - id of user
	 * @param sex - UCharacter sex
	 * @return true if operation is successfully
	 */
	boolean updateProfileSex(int userId, boolean sex);
	
	/**
	 * Update character experience
	 * @param userId - id of user
	 * @param experiance - amount of experience
	 * @return true if operation is successfully
	 */
	boolean updateProfileExpirience(int userId, int experiance);
	
	/**
	 * Update character strength
	 * @param userId - id of user
	 * @param strength - amount of strength
	 * @return true if operation is successfully
	 */
	boolean updateProfileStrength(int userId, int strength);
	
	/**
	 * Update character agility
	 * @param userId - id of user
	 * @param agility - amount of agility
	 * @return true if operation is successfully
	 */
	boolean updateProfileAgilty(int userId, int agility);
	
	/**
	 * Update character intellect
	 * @param userId - id of user
	 * @param intelect - amount of intellect
	 * @return true if operation is successfully
	 */
	boolean updateProfileIntelect(int userId, int intellect);
	
	/**
	 * Update character profession
	 * @param userId - id of user
	 * @param profession - character profession
	 * @return true if operation is successfully
	 */
	boolean updateProfileProffesion(int userId, String profession);
	
	/**
	 * Add won fight
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	boolean addWonFight(int userId);
	
	/**
	 * Add lost fight 
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	boolean addLostFight(int userId);
	
	/**
	 * Delete character(and user)
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	boolean deleteCharacter(int userId);
	
	
}
