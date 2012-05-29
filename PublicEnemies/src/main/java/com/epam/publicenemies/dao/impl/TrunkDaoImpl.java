package com.epam.publicenemies.dao.impl;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.ITrunkDao;

/**
 * 
 * @author Chetyrkin_Sviatoslav 20.05.2012
 *
 */
@Repository
public class TrunkDaoImpl implements ITrunkDao {

	private Logger log = Logger.getLogger(TrunkDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Get amount of all weapons
	 * @return amount of all weapons
	 */
	public int getWeaponsAmount() {
		final String WEAPONS_SQL = "SELECT COUNT(*) FROM weapons";
		int i = jdbcTemplate.queryForInt(WEAPONS_SQL);
		log.info("TrunkDaoImpl.getWeaponsAmount: Getting weapons amount");
		return i;
	}
	
	/**
	 * Get amount of all armors
	 * @return amount of all armors
	 */
	public int getArmorsAmount() {
		final String ARMORS_SQL = "SELECT COUT(*) FROM armors";
		int i = jdbcTemplate.queryForInt(ARMORS_SQL);
		log.info("TrunkDaoImpl.getArmorsAmount: Getting armors amount");
		return i;
	}
	
	/**
	 * Get amount of all aids
	 * @return get amount of all aids
	 */
	public int getAidsAmount() {
		final String AIDS_SQL = "SELECT COUNT(*) FROM aids";
		int i = jdbcTemplate.queryForInt(AIDS_SQL);
		log.info("TrunkDaoImpl.getAidsAmount: Getting aids amount");
		return i;
	}
	
}
