package com.epam.publicenemies.dao;

//import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.*;


/**
 * @author Chetyrkin S.V.
 * Updated by Chetyrkin S.V. 27.04.2012
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
	 * Add new character with default values
	 * @param userId - user id
	 * @return id of new character
	 */
	int addCharacter(int userId);
	
	
//	int addCharacter(boolean sex, int experience, int strength, int agility, int intellect,
//			String profession, );
//	
	/**
	 * Get Character by its id
	 * @param characterId - character id
	 * @return character object
	 */
	UCharacter getCharacter(int CharacterId);
	
	
	
	/**
	 * Get Character by user note
	 * @param user - User object
	 * @return character object
	 */
	UCharacter getCharacter(User user);
	
	/**
	 * Update character sex
	 * @param characterId - id of character
	 * @param sex - character sex
	 * @return true if operation is successfully
	 */
	boolean updateCharacterSex(int characterId, boolean sex);
	
	/**
	 * Update character experience
	 * @param characterId - id of character 
	 * @param experiance - amount of experience
	 * @return true if operation is successfully
	 */
	boolean updateCharacterExpirience(int characterId, int experiance);
	
	/**
	 * Update character strength
	 * @param characterId - id of character 
	 * @param strength - amount of strength
	 * @return true if operation is successfully
	 */
	boolean updateCharacterStrength(int characterId, int strength);
	
	/**
	 * Update character agility
	 * @param characterId - id of character 
	 * @param agility - amount of agility
	 * @return true if operation is successfully
	 */
	boolean updateCharacterAgilty(int characterId, int agilty);
	
	/**
	 * Update character intellect
	 * @param characterId - id of character
	 * @param intellect - amount of intellect
	 * @return true if operation is successfully
	 */
	boolean updateCharacterIntellect(int characterId, int intellect);
	
	/**
	 * Update character profession
	 * @param characterId - id of character
	 * @param profession - character profession
	 * @return true if operation is successfully
	 */
	boolean updateCharacterProffesion(int characterId, String proffesion);
	
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
	 * Update Character information
	 * @param character - Character object
	 * @return true if operation is successfully
	 */
	boolean updateCharacterInfo(UCharacter character);

	/**
	 * Delete character
	 * @param character - Character object
	 * @return true if operation is successfully
	 */
	boolean deleteCharacter(UCharacter character);
	
}
