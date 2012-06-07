package com.epam.publicenemies.dao;

import java.util.List;

import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;

public interface IProfileDao {
	
	void updateProfile(int uid, String nickName, String avatar, boolean sex,
			byte prof);
	
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
	 * Add weapons for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	boolean addWeapons(int userId, List<Integer> weapons);
	
	/**
	 * Add armors for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param armors - List of armors ids
	 * @return true if operation was successfully
	 */
	boolean addArmors(int userId, List<Integer> armors);
	
	/**
	 * Add aids for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	boolean addAids(int userId, List<Integer> aids);
	
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
	 * Remove weapons from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param weapons - id of weapon
	 * @return true if operation was successfully
	 */
	boolean removeWeapons(int userId, List<Integer> weapons);
	
	/**
	 * Remove aids from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param aids - id of aid
	 * @return true if operation was successfully
	 */
	boolean removeAids(int userId, List<Integer> aids);
	
	/**
	 * Remove armors from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param armors - id of armor
	 * @return true if operation was successfully
	 */
	boolean removeArmors(int userId, List<Integer> armors);
	
	
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
	boolean updateProfileProfession(int userId, String profession);
	
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
	
	/**
	 * Check weapon2 slot
	 * @param userId - id of user
	 * @return true if weapon2 slot is empty
	 */
	boolean isEmptyWeapon2(int userId);
	
	/**
	 * Add some experience amount to character
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
	 * @param fightsWon - amount of won fights
	 * @return true if operation was successfully
	 */
	boolean updateWonFights(int characterId, int fightsWon);
	
	/**
	 * Update lost fights amount
	 * @param characterId - character Id
	 * @param fightsTotal - amount of all fights
	 * @return true if operation was successfully
	 */
	boolean updateTotalFights(int characterId, int fightsTotal);
	
	/**
	 * Uses aid in battle
	 * @param characterId - character id
	 * @return true if operation was successfully
	 */
	boolean useAid(int characterId);
}
