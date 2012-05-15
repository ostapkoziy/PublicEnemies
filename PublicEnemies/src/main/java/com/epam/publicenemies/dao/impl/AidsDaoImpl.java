package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IAidsDao;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.web.LoginUserFormController;

/**
 * Works with aids table
 * @author Ivan Kostyrko
 *
 */
public class AidsDaoImpl implements IAidsDao{
	
	private Logger log	= Logger.getLogger(AidsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Aid> fetchAllAids() {
		log.info("AidsDaoImpl: fetchAllAids: enter");		
		return this.jdbcTemplate.query( "SELECT * FROM aids", new AidMapper());		
	}
	
	private final class AidMapper implements RowMapper<Aid> {
	    public Aid mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Aid aid = new Aid();
	        aid.setItemId(rs.getInt("aidId"));
	        aid.setItemName(rs.getString("aidName"));
	        aid.setAidType(rs.getString("aidType"));
	        aid.setAidEffect(rs.getInt("aidEffect"));
	        aid.setItemPicture(rs.getString("aidPicture"));
	        aid.setItemPrice(rs.getInt("aidPrice"));
	        return aid;
	    } 
	}
		
}


