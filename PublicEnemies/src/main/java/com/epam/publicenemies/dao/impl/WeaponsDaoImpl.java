package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IWeaponsDao;
import com.epam.publicenemies.domain.Weapon;

/**
 * 
 * @author Ivan Kostyrko
 *
 */
public class WeaponsDaoImpl implements IWeaponsDao {

	private Logger log	= Logger.getLogger(WeaponsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weapon> fetchAllWeapons() {
		log.info("WeaponsDaoImpl: fetchAllWeapons: enter");		
		return this.jdbcTemplate.query( "SELECT * FROM weapons", new WeaponMapper());		
	}
	
	private final class WeaponMapper implements RowMapper<Weapon> {
	    public Weapon mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Weapon weapon = new Weapon();
	        weapon.setItemId(rs.getInt("weaponId"));
	        weapon.setItemName(rs.getString("weaponName"));
	        weapon.setHitPoints(rs.getInt("weaponHitPoints"));
	        weapon.setWeaponType(rs.getBoolean("weaponType"));
	        weapon.setItemPicture(rs.getString("weaponPicture"));
	        weapon.setItemPrice(rs.getInt("weaponPrice"));
	        return weapon;
	    } 
	}	

	
}
