package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;

public interface IProfileDao {
	
	void updateProfile(int uid, String nickName, String avatar, boolean sex,
			String prof);
	
	User getUserById(int userId);

	UCharacter getCharacterByUserId(int userId);

	UCharacter getCharacterById(int characterId);
	
	Profile getProfile(int userId);
	
	
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
	boolean undresAid(int userId);
	
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
	 * Buy weapons for user
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	boolean buyWeapons(int userId, List<Integer> weapons);

	/**
	 * Buy aids for user
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	boolean buyAids(int userId, List<Integer> aids);
	
	/**
	 * Buy armors for user
	 * @param userId - id of user
	 * @param armors - List armors ids
	 * @return true if operation was successfully
	 */
	boolean buyArmors(int userId, List<Integer> armors);
	
	/**
	 * Sell user's weapons
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	boolean sellWeapons(int userId, List<Integer> weapons);
	
	/**
	 * Sell user's aids
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	boolean sellAids(int userId, List<Integer> aids);
	
	/**
	 * Sell user's armors
	 * @param userId - id of user
	 * @param armors - List of armors ids
	 * @return true if operation was successfully
	 */
	boolean sellArmors(int userId, List<Integer> armors);
	
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
