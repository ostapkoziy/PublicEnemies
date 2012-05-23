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

	@Override
	public int addWeapon(final String name, final int hitPoints, final String picture,
			final boolean weaponType, final int price) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_SQL = "INSERT INTO weapons (weaponName, weaponHitPoints, weponPicture, weaponType," +
				"weaponPrice) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
		new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setInt(2, hitPoints);
				ps.setString(3, picture);
				ps.setBoolean(4, weaponType);
				ps.setInt(5, price);
				return ps;
			}
		}, keyHolder);
		int i = keyHolder.getKey().intValue();
			log.info("WeaponsDaoImpl.addWeapon : weapon id is" + i);
		return i;
	}

	@Override
	public int addWeapon(final Weapon weapon) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_SQL = "INSERT INTO weapons (weaponName, weaponHitPoints, weponPicture, weaponType," +
				"weaponPrice) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
		new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, weapon.getItemName());
				ps.setInt(2, weapon.getHitPoints());
				ps.setString(3, weapon.getItemPicture());
				ps.setBoolean(4, weapon.isWeaponType());
				ps.setInt(5, weapon.getItemPrice());
				return ps;
			}
		}, keyHolder);
		int i = keyHolder.getKey().intValue();
			log.info("WeaponsDaoImpl.addWeapon : weapon id is " + i);
		return i;
	}

	@Override
	public Weapon getWeaponById(int weaponId) {
		final String SELECT_SQL = "SELECT * FROM weapons WHERE weaponId=?";
		Weapon weapon = jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{ weaponId }, new WeaponMapper());
			log.info("WeaponDaoImpl.getWeaponById : weapon id is " + weaponId);
			return weapon;
	}

	@Override
	public Weapon getWeaponByName(String name) {
		final String SELECT_SQL = "SELECT * FROM weapons WHERE weaponName=?";
		Weapon weapon = jdbcTemplate.queryForObject(SELECT_SQL, new Object[]{ name }, new WeaponMapper());
		log.info("WeaponDaoImpl.getWeaponByName : weapon id is " + weapon.getItemId());
		return weapon;
	}

	@Override
	public List<Weapon> getAllFirearm() {
		final String SELECT_SQL = "SELECT * FROM weapons WHERE weaponType=1";
		List<Weapon> weapons = jdbcTemplate.query(SELECT_SQL, new WeaponMapper());
		log.info("WeaponDaoImpl.getAllFirearms : were " + weapons.size() + " weapons selected");
		return weapons;
	}

	@Override
	public List<Weapon> getAllColdSteel() {
		final String SELECT_SQL = "SELECT * FROM weapons WHERE weaponType=0";
		List<Weapon> weapons = jdbcTemplate.query(SELECT_SQL, new WeaponMapper());
		log.info("WeaponDaoImpl.getAllColdSteel : were " + weapons.size() + " weapons selected");
		return weapons;
	}

	@Override
	public boolean updateWeaponName(int weaponId, String name) {
		final String UPDATE_SQL = "UPDATE weapons SET weaponName=? WHERE weaponId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {name, weaponId});
		if (i>0) {
			log.info("WeaponDaoImpl.updateWeaponName : weapon(" + weaponId + ") was renamed to " + name);
			return true;
		} else	return false;
	}

	@Override
	public boolean updateWeaponHitPoints(int weaponId, int hitPoints) {
		final String UPDATE_SQL = "UPDATE weapons SET weaponHitPoints=? WHERE weaponId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {hitPoints, weaponId});
		if (i>0) {
			log.info("WeaponDaoImpl.updateWeaponName : weapon(" + weaponId + ") hit points now are " + hitPoints);
			return true;
		} else	return false;
	}

	@Override
	public boolean updateWeaponPicture(int weaponId, String picture) {
		final String UPDATE_SQL = "UPDATE weapons SET weaponPicture=? WHERE weaponId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {picture, weaponId});
		if (i>0) {
			log.info("WeaponDaoImpl.updateWeaponName : weapon(" + weaponId + ") picture now are " + picture);
			return true;
		} else	return false;
	}

	
	@Override
	public boolean updateWeaponType(int weaponId, boolean weaponType) {
		final String UPDATE_SQL = "UPDATE weapons SET weaponType=? WHERE weaponId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {weaponType, weaponId});
		if (i>0) {
			log.info("WeaponDaoImpl.updateWeaponName : weapon(" + weaponId + ") type now are " + weaponType);
			return true;
		} else	return false;
	}

	@Override
	public boolean updateWeaponPrice(int weaponId, int price) {
		final String UPDATE_SQL = "UPDATE weapons SET weaponPrice=? WHERE weaponId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {price, weaponId});
		if (i>0) {
			log.info("WeaponDaoImpl.updateWeaponName : weapon(" + weaponId + ") price now are " + price);
			return true;
		} else	return false;
	}	

	
}
