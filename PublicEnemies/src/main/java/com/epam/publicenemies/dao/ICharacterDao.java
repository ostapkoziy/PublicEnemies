package com.epam.publicenemies.dao;

//import com.epam.publicenemies.domain.UCharacter;
import java.util.List;

import com.epam.publicenemies.domain.*;


/**
 * @author Chetyrkin S.V.
 * Updated by Chetyrkin S.V. 27 ���. 2012
 */
public interface ICharacterDao {

	/**
	 * Add new character for user
	 * @param character - Character object
	 * @param user - User object
	 * @return id of new character
	 */
	int addCharacter(UCharacter character, User user);
	
	/**
	 * Add new character
	 * @param sex - character gender
	 * @param experience - character experience
	 * @param strength - character strength
	 * @param agility - character agility
	 * @param intellect - character intellect
	 * @param charcaterProfession - profession of character
	 * @param fightsTotal - total spent fights
	 * @param fightsWon - won fights
	 * @param weapon1 - first dressed weapon 
	 * @param weapon2 - second dressed weapon
	 * @param aid - dressed aid
	 * @param armor - dressed armor
	 * @return id of of created character injection
	 */
	int addCharacter(boolean sex, int experience, int strength, int agility, int intellect,
			byte charcaterProfession);
	
	/**
	 * Create default character
	 * @return id of of created character injection
	 */
	int addCharacter();
	
	/**
	 * Update character info
	 * @param sex - character gender
	 * @param experience - character experience
	 * @param strength - character strength
	 * @param agility - character agility
	 * @param intellect - character intellect
	 * @param charcaterProfession - profession of character
	 * @param fightsTotal - total spent fights
	 * @param fightsWon - won fights
	 * @param weapon1 - first dressed weapon 
	 * @param weapon2 - second dressed weapon
	 * @param aid - dressed aid
	 * @param armor - dressed armor
	 * @return true if operation was successfully
	 */
	boolean updateCharacterInfo(int characterId, boolean sex, int experience, int strength, int agility, int intellect,
			byte charcaterProfession, int fightsTotal, int fightsWon);
	
	/**
	 * Get UCharacter object by userId
	 * @param userId - id of user
	 * @return UCharacter object
	 */
	boolean getCharacterByUserId(int userId);
	
	/**
	 * Get UCharacter object by characterId
	 * @param characterId - id of character
	 * @return UCharacter object
	 */
	boolean getCharacterByCharacterId(int characterId);
	
	/**
	 * Delete character 
	 * @param userId - id of user
	 * @return true if operation was successfully
	 */
	boolean deleteCharacterByUserId(int userId);
	
	/**
	 * Delete character 
	 * @param characterId - id of character
	 * @return true if operation was successfully
	 */
	boolean deleteCharacterByCharacterId(int characterId);
	
	/**
	 * Get list of all registered characters
	 * @return list of all characters
	 */
	List<UCharacter> getAllCharacters();
	
	/**
	 * Get list of all registered characters sorted by strength 
	 * @return list of all characters
	 */
	List<UCharacter> getCharactersSortedByStrength();
	
	/**
	 * Get list of all registered characters sorted by agility 
	 * @return list of all characters
	 */
	List<UCharacter> getCharactersSortedByAgility();
	
	/**
	 * Get list of all registered characters sorted by intellect
	 * @return list of all characters
	 */
	List<UCharacter> getCharactersSortedByIntellect();
	
	/**
	 * Get list of all registered characters sorted by spent fights
	 * @return list of all characters
	 */
	List<UCharacter> getCharactersSortedByFights();
	
	/**
	 * Get list of all registered characters sorted by won fights
	 * @return list of all characters
	 */
	List<UCharacter> getCharactersSortedByWonFughts();
	
}
