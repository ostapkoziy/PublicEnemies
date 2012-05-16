package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.domain.Armor;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public class ArmorsDaoImpl implements IArmorsDao {

	private Logger log	= Logger.getLogger(ArmorsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Armor> fetchAllArmors() {
		log.info("ArmorsDaoImpl: fetchAllArmors: enter");		
		return this.jdbcTemplate.query( "SELECT * FROM armors", new ArmorMapper());		
	}
	
	private final class ArmorMapper implements RowMapper<Armor> {
	    public Armor mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Armor armor = new Armor();
	        armor.setItemId(rs.getInt("armorId"));
	        armor.setItemName(rs.getString("armorName"));
	        armor.setArmorProtection(rs.getInt("armorProtection"));
	        armor.setItemPicture(rs.getString("armorPicture"));
	        armor.setItemPrice(rs.getInt("armorPrice"));
	        return armor;
	    } 
	}	

}
