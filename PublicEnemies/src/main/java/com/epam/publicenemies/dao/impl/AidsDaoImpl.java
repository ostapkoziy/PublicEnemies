package com.epam.publicenemies.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.domain.Aid;

/**
 * Works with aids table
 * @author Ivan Kostyrko
 * Updated Chetyrkin S.V.
 *
 */
public class AidsDaoImpl implements IAidsDao{
	
	private Logger log	= Logger.getLogger(AidsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Gets all aids entry from db
	 * @return list of aids
	 */
	@Override
	public List<Aid> getAllAids() {
		log.info("AidsDaoImpl: fetchAllAids: enter");		
		return this.jdbcTemplate.query( "SELECT * FROM aids", new AidMapper());		
	}
	
	private final class AidMapper implements RowMapper<Aid> {
	    public Aid mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Aid aid = new Aid();
	        String description = rs.getString("aidDescription");
	        if (description==null) description = "no description";
	        aid.setItemId(rs.getInt("aidId"));
	        aid.setItemName(rs.getString("aidName"));
	        aid.setAidType(rs.getString("aidType"));
	        aid.setAidEffect(rs.getInt("aidEffect"));
	        aid.setItemPicture(rs.getString("aidPicture"));
	        aid.setItemPrice(rs.getInt("aidPrice"));
	        aid.setItemDescription(description);
	        return aid;
	    } 
	}

	/**
	 * Add new aid
	 * @param name - aid name
	 * @param type - aid type
	 * @param effect - aid effect
	 * @param picture - aid picture
	 * @param price - aid price
	 * @param description - aid description
	 * @return id of new aid
	 */
	@Override
	public int addAid(final String name, final String type, final int effect, final String picture,
			final int price, final String description) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_SQL = "INSERT IGNORE INTO aids (aidName, aidType, aidEffect, aidPicture, aidPrice, aidDescription)" +
				" VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(
		new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setString(2, type);
				ps.setInt(3, effect);
				ps.setString(4, picture);
				ps.setInt(5, price);
				ps.setString(6, description);
				return ps;
			}
		}, keyHolder);
		int i = keyHolder.getKey().intValue();
			log.info("AidsDaoImpl.addAid: aid id is" + i);
		return i;	
		}

	/**
	 * Update aid info
	 * @param name - aid name
	 * @param type - aid type
	 * @param effect - aid effect
	 * @param picture - aid picture
	 * @param price - aid price
	 * @param description - aid description
	 * @return true if operation was successfully
	 */
	@Override
	public boolean updateAidInfo(int aidId, String name, String type, int effect,
			String picture, int price, String description) {
		final String UPDATE_SQL = "UPDATE IGNORE aids SET aidName=?, aidType=?, aidEffect=?, aidPicture=?, " +
				"aidPrice=?, aidDescription=? WHERE aidId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {name, type, effect, picture, price, description, aidId});
		if (i>0) {
			log.info("AidDaoImpl.updateAidInfo : aid(" + aidId + ") was updated");
			return true;
		} else
			return false;
	}

	/**
	 * Get Aid object by id
	 * @param aidId - aid id 
	 * @return
	 */
	@Override
	public Aid getAidById(int aidId) {
		final String SELECT_SQL = "SELECT * FROM aids WHERE aidId=?";
		Aid aid = jdbcTemplate.queryForObject(SELECT_SQL, new Object[] {aidId}, new AidMapper());
		log.info("AidDaoImpl.getAidById : aid(" + aidId + ") were fetched");
		return aid;
	}

	/**
	 * Get Aid object by aid name
	 * @param aidName - aid name
	 * @return Aid object
	 */
	@Override
	public Aid getAidByName(String aidName) {
		final String SELECT_SQL = "SELECT * FROM aids WHERE aidName=?";
		Aid aid = jdbcTemplate.queryForObject(SELECT_SQL, new AidMapper());
		log.info("AidDaoImpl.getAidByName : aid(" + aidName + ") were fetched");
		return aid;
	}

	/**
	 * Get list of all aids sorted by their names
	 * @return list of all aids
	 */
	@Override
	public List<Aid> getAidsSortedByName() {
		final String SELECT_SQL = "SELECT * FROM aids ORDER BY aidName";
		List<Aid> aids = jdbcTemplate.query(SELECT_SQL, new AidMapper());
		return aids;
	}

	/**
	 * Get list of all aids sorted by their prices
	 * @return list of all aids
	 */
	@Override
	public List<Aid> getAidsSortedByPrice() {
		final String SELECT_SQL = "SELECT * FROM aids ORDER BY aidPrice";
		List<Aid> aids = jdbcTemplate.query(SELECT_SQL, new AidMapper());
		return aids;
	}

	/**
	 * Get list of all aids sorted by their effects
	 * @return list of all aids
	 */
	@Override
	public List<Aid> getAidsSortedByEffect() {
		final String SELECT_SQL = "SELECT * FROM aids ORDER BY aidEffect";
		List<Aid> aids = jdbcTemplate.query(SELECT_SQL, new AidMapper());
		return aids;
	}

	/**
	 * Get aids amount 
	 * @return amount of aids
	 */
	@Override
	public int getAidsAmount() {
		final String SELECT_SQL = "SELECT COUNT(*) FROM aids";
		int i = jdbcTemplate.queryForInt(SELECT_SQL);
		return i;
	}
}


