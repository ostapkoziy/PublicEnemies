/**
 * 
 */
package com.epam.publicenemies.service;

/**
 * @author Chetyrkin_Sviatoslav
 *
 */
public interface IPokerStatisticsService {

	/**
	 * Increment total amount of played poker games
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	boolean incrementPlayedGames(int userId);
	
	/**
	 * Add played games to total played poker games
	 * @param games - games amount to add
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	boolean addPlayedGames(int userId, int games);
	
	/**
	 * Update amount of total played poker games
	 * @param userId - user id
	 * @param games - amount of played games
	 * @return true if operation was successfully
	 */
	boolean updatePlayedGames(int userId, int games);
	
	/**
	 * Get amount of total played poker games
	 * @param userId - user Id
	 * @return amount of total played poker games
	 */
	int getTotalGames(int userId);
	
	/**
	 * Get VPIP indicator
	 * @param userId - user id
	 * @return VPIP indicator
	 */
	byte getVPIP(int userId);
	
	/**
	 * Update VPIP index
	 * @param userId - user id
	 * @param VPIP - VPIP index
	 * @return true if operation was successfully
	 */
	boolean updateVPIP(int userId, byte VPIP);
	
	/**
	 * Get PFR indicator
	 * @param userId - user id
	 * @return PFR indicator
	 */
	byte getPFR(int userId);
	
	/**
	 * Update PFR index
	 * @param userId - user id
	 * @param PFR - VPIP index
	 * @return true if operation was successfully
	 */
	boolean updatePFR(int userId, byte PFR);
	
	/**
	 * Get 3BET indicator
	 * @param userId - user id
	 * @return 3BET indicator
	 */
	byte get3BET(int userId);
	
	/**
	 * Update 3BET index
	 * @param userId - user id
	 * @param 3BET - 3BET index
	 * @return true if operation was successfully
	 */
	boolean update3BET(int userId, byte threeBET);
	
	/**
	 * Get F3BET indicator
	 * @param userId - user id
	 * @return F3BET indicator
	 */
	byte getF3BET(int userId);
	
	/**
	 * Update F3BET index
	 * @param userId - user id
	 * @param F3BET - F3BET index
	 * @return true if operation was successfully
	 */
	boolean updateF3BET(int userId, byte F3BET);
}
