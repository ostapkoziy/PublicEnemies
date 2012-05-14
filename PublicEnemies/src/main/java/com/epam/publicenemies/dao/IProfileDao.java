package com.epam.publicenemies.dao;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;

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
	 * Get character by user note
	 * @param user - User object
	 * @return UCharacter object
	 */
	UCharacter getCharacter(User user);
	
	/**
	 * Update character sex
	 * @param characterId - id of character
	 * @param sex - UCharacter sex
	 * @return true if operation is successfully
	 */
	boolean updateProfileSex(int characterId, boolean sex);
	
	/**
	 * Update character experience
	 * @param characterId - id of character 
	 * @param experiance - amount of experience
	 * @return true if operation is successfully
	 */
	boolean updateProfileExpirience(int characterId, int experiance);
	
	/**
	 * Update character strength
	 * @param characterId - id of character 
	 * @param strength - amount of strength
	 * @return true if operation is successfully
	 */
	boolean updateProfileStrength(int characterId, int strength);
	
	/**
	 * Update character agility
	 * @param characterId - id of character 
	 * @param agility - amount of agility
	 * @return true if operation is successfully
	 */
	boolean updateProfileAgilty(int characterId, int agility);
	
	/**
	 * Update character intelect
	 * @param characterId - id of character
	 * @param intelect - amount of intelect
	 * @return true if operation is successfully
	 */
	boolean updateProfileIntelect(int characterId, int intelect);
	
	/**
	 * Update character profession
	 * @param characterId - id of character
	 * @param profession - character profession
	 * @return true if operation is successfully
	 */
	boolean updateProfileProffesion(int characterId, String profession);
	
	/**
	 * Add won fight
	 * @param characterId - id of character
	 * @return true if operation is successfully
	 */
	boolean addWonFight(int characterId);
	
	/**
	 * Add lost fight 
	 * @param characterId - id of character
	 * @return true if operation is successfully
	 */
	boolean addLostFight(int characterId);
	
	/**
	 * Delete character
	 * @param UCharacter - Character object
	 * @return true if operation is successfully
	 */
	boolean deleteCharacter(UCharacter character);
	
	
}
