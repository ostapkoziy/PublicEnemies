/**
 * 
 */
package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.IPokerStaticticsDao;

/**
 * @author Chetyrkin_Sviatoslav
 *
 */
@Repository
public class PokerStatisticsDaoImpl implements IPokerStaticticsDao {
	
	private Logger log = Logger.getLogger(PokerStatisticsDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Increment total amount of played poker games
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	public boolean incrementPlayedGames(int userId) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET totalGames=totalGames+1 WHERE userId=? AND userPoker=pokerId";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {userId});
		if(i>0) {
			log.info("PokerStatisticsDaoImpl.incrementPlayedGames : user's("+userId+") total games was incremented");
			return true;
		} else
			return false;
	}
	
	/**
	 * Add played games to total played poker games
	 * @param games - games amount to add
	 * @param userId - user id
	 * @return true if operation was successfully
	 */
	public boolean addPlayedGames(int userId, int games) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET totalGames=totalGames+? WHERE userId=? AND userPoker=pokerId";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {games, userId});
		if(i>0) {
			log.info("PokerStatisticsDaoImpl.addPlayedGames : user's("+userId+") played games was increased");
			return true;
		} else
			return false;
	}
	
	/**
	 * Update amount of total played poker games
	 * @param userId - user id
	 * @param games - amount of played games
	 * @return true if operation was successfully
	 */
	public boolean updatePlayedGames(int userId, int games) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET totalGames=? WHERE userId=? AND userPoker=pokerId";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {games, userId});
		if(i>0) {
			log.info("PokerStatisticsDaoImpl.updatePlayedGames : user's("+userId+") played games was updated to "+games);
			return true;
		} else
			return false;
	}
	
	/**
	 * Get amount of total played poker games
	 * @param userId - user Id
	 * @return amount of total played poker games
	 */
	public int getTotalGames(int userId) {
		final String SELECT_SQL = "SELECT totalGames FROM users, pokerStatistics WHERE userId=? AND userPoker=pokerId";
		int i = 0;
		i = jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId});
		log.info("PokerStatisticsDaoImpl.getTotalGames : user("+userId+") have "+i+" total games");
		return i;
	}
	
	/**
	 * Get VPIP indicator
	 * @param userId - user id
	 * @return VPIP indicator
	 */
	public byte getVPIP(int userId) {
		final String SELECT_SQL = "SELECT VPIP FROM users, pokerStatistics WHERE userId=? AND userPoker=pokerId";
		byte i = 0;
		i =(byte) jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId});
		log.info("PokerStatisticsDaoImpl.getVPIP : user's("+userId+") VPIP index("+i+") was fetched");
		return i;
	}
	
	/**
	 * Update VPIP index
	 * @param userId - user id
	 * @param VPIP - VPIP index
	 * @return true if operation was successfully
	 */
	public boolean updateVPIP(int userId, byte VPIP) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET VPIP=? WHERE userId=? AND userPoker=pokerId";
		int i = 0;
		i =  jdbcTemplate.update(UPDATE_SQL, new Object[] {VPIP, userId});
		if(i>0){
			log.info("PokerStatisticsDaoImpl.updateVPIP : user's("+userId+") VPIP index ("+VPIP+") was updated");
			return true;
		} else 
			return false;
	}
	
	/**
	 * Get PFR indicator
	 * @param userId - user id
	 * @return PFR indicator
	 */
	public byte getPFR(int userId) {
		final String SELECT_SQL = "SELECT PFR FROM users, pokerStatistics WHERE userId=? AND userPoker=pokerId";
		byte i = 0;
		i =(byte) jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId});
		log.info("PokerStatisticsDaoImpl.getPFR : user's("+userId+") PFR index("+i+") was fetched");
		return i;
	}
	
	/**
	 * Update PFR index
	 * @param userId - user id
	 * @param PFR - VPIP index
	 * @return true if operation was successfully
	 */
	public boolean updatePFR(int userId, byte PFR) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET PFR=? WHERE userId=? AND userPoker=pokerId";
		int i = 0;
		i =  jdbcTemplate.update(UPDATE_SQL, new Object[] {PFR, userId});
		if(i>0){
			log.info("PokerStatisticsDaoImpl.updatePFR : user's("+userId+") PFR index ("+PFR+") was updated");
			return true;
		} else 
			return false;
	}
	
	/**
	 * Get 3BET indicator
	 * @param userId - user id
	 * @return 3BET indicator
	 */
	public byte get3BET(int userId) {
		final String SELECT_SQL = "SELECT 3BET FROM users, pokerStatistics WHERE userId=? AND userPoker=pokerId";
		byte i = 0;
		i =(byte) jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId});
		log.info("PokerStatisticsDaoImpl.get3BET : user's("+userId+") 3BET index("+i+") was fetched");
		return i;
	}
	
	/**
	 * Update 3BET index
	 * @param userId - user id
	 * @param 3BET - 3BET index
	 * @return true if operation was successfully
	 */
	public boolean update3BET(int userId, byte threeBET) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET 3BET=? WHERE userId=? AND userPoker=pokerId";
		int i = 0;
		i =  jdbcTemplate.update(UPDATE_SQL, new Object[] {threeBET, userId});
		if(i>0){
			log.info("PokerStatisticsDaoImpl.update3BET : user's("+userId+") 3BET index ("+threeBET+") was updated");
			return true;
		} else 
			return false;
	}
	
	/**
	 * Get F3BET indicator
	 * @param userId - user id
	 * @return F3BET indicator
	 */
	public byte getF3BET(int userId) {
		final String SELECT_SQL = "SELECT F3BET FROM users, pokerStatistics WHERE userId=? AND userPoker=pokerId";
		byte i = 0;
		i =(byte) jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId});
		log.info("PokerStatisticsDaoImpl.getF3BET : user's("+userId+") F3BET index("+i+") was fetched");
		return i;
	}
	
	/**
	 * Update F3BET index
	 * @param userId - user id
	 * @param F3BET - F3BET index
	 * @return true if operation was successfully
	 */
	 public boolean updateF3BET(int userId, byte F3BET) {
		final String UPDATE_SQL = "UPDATE pokerStatistics, users SET F3BET=? WHERE userId=? AND userPoker=pokerId";
		int i = 0;
		i =  jdbcTemplate.update(UPDATE_SQL, new Object[] {F3BET, userId});
		if(i>0){
			log.info("PokerStatisticsDaoImpl.updateF3BET : user's("+userId+") F3BET index ("+F3BET+") was updated");
			return true;
		} else 
			return false;
	}

}
