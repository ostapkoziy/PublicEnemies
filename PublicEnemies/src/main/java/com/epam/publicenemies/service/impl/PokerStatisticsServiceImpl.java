/**
 * 
 */
package com.epam.publicenemies.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.dao.ICharacterDao;
import com.epam.publicenemies.dao.IPokerStaticticsDao;
import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.service.IPokerStatisticsService;

/**
 * @author Chetyrkin_Sviatoslav
 *
 */
@Service
public class PokerStatisticsServiceImpl implements IPokerStatisticsService {

	
	@Autowired
	private IPokerStaticticsDao pokerDao;
	
	private Logger log = Logger.getLogger(PokerStatisticsServiceImpl.class);
	
	/**
	 * Increment total amount of played poker games
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	public boolean incrementPlayedGames(int userId) {
		return pokerDao.incrementPlayedGames(userId);
	}
	
	/**
	 * Add played games to total played poker games
	 * @param games - games amount to add
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	public boolean addPlayedGames(int userId, int games) {
		return pokerDao.addPlayedGames(userId, games);
	}
	
	/**
	 * Update amount of total played poker games
	 * @param userId - user id
	 * @param games - amount of played games
	 * @return true if operation was successfully
	 */
	public boolean updatePlayedGames(int userId, int games) {
		return pokerDao.updatePlayedGames(userId, games);
	}
	
	/**
	 * Get amount of total played poker games
	 * @param userId - user Id
	 * @return amount of total played poker games
	 */
	public int getTotalGames(int userId) {
		return pokerDao.getTotalGames(userId);
	}
	
	/**
	 * Get VPIP indicator
	 * @param userId - user id
	 * @return VPIP indicator
	 */
	public byte getVPIP(int userId) {
		return pokerDao.getVPIP(userId);
	}
	
	/**
	 * Update VPIP index
	 * @param userId - user id
	 * @param VPIP - VPIP index
	 * @return true if operation was successfully
	 */
	public boolean updateVPIP(int userId, byte VPIP) {
		return pokerDao.updateVPIP(userId, VPIP);
	}
	
	/**
	 * Get PFR indicator
	 * @param userId - user id
	 * @return PFR indicator
	 */
	public byte getPFR(int userId) {
		return pokerDao.getPFR(userId);
	}
	
	/**
	 * Update PFR index
	 * @param userId - user id
	 * @param PFR - VPIP index
	 * @return true if operation was successfully
	 */
	public boolean updatePFR(int userId, byte PFR) {
		return pokerDao.updatePFR(userId, PFR);
	}
	
	/**
	 * Get 3BET indicator
	 * @param userId - user id
	 * @return 3BET indicator
	 */
	public byte get3BET(int userId) {
		return pokerDao.get3BET(userId);
	}
	
	/**
	 * Update 3BET index
	 * @param userId - user id
	 * @param 3BET - 3BET index
	 * @return true if operation was successfully
	 */
	public boolean update3BET(int userId, byte threeBET) {
		return pokerDao.update3BET(userId, threeBET);
	}
	
	/**
	 * Get F3BET indicator
	 * @param userId - user id
	 * @return F3BET indicator
	 */
	public byte getF3BET(int userId) {
		return pokerDao.getF3BET(userId);
	}
	
	/**
	 * Update F3BET index
	 * @param userId - user id
	 * @param F3BET - F3BET index
	 * @return true if operation was successfully
	 */
	public boolean updateF3BET(int userId, byte F3BET) {
		return pokerDao.updateF3BET(userId, F3BET);
	}

}
