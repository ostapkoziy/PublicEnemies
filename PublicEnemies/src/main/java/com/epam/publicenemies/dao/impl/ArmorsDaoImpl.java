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

	/**
	 * Add new armor
	 * @param name - armor name
	 * @param picture - armor picture
	 * @param protection - armor protection
	 * @param price - armor price
	 * @return id of created weapon
	 */
	@Override
	public int addArmor(final String name, final String picture, final int protection, final int price) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_SQL = "INSERT INTO armors (armorName, armorProtection, armorPicture, armorPrice)" +
				" VALUES (?,?,?,?)";
		jdbcTemplate.update(
		new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setInt(2, protection);
				ps.setString(3, picture);
				ps.setInt(4, price);
				return ps;
			}
		}, keyHolder);
		int i = keyHolder.getKey().intValue();
			log.info("ArmorsDaoImpl.addArmor : armor id is" + i);
		return i;
	}

	@Override
	public boolean updateArmorInfo(int armorId, String name, int protection,
			String picture, int price) {
		final String UPDATE_SQL = "UPDATE armors SET armorName=?, armorProtection=?, armorPicture=?," +
				" armorPrice=? WHERE armorId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {name, protection, picture, price, armorId});
		if (i>0) {
			log.info("ArmorsDaoImpl.updateArmorInfo : armor(" + armorId + ") info was updated");
			return true;
		} else
			return false;
	}

	@Override
	public Armor getArmorById(int armorId) {
		final String SELECT_SQL = "SELECT * from armors WHERE armorId=?";
		Armor armor = jdbcTemplate.queryForObject(SELECT_SQL, new Object[] {armorId}, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorById : armor("+armorId+") was fetched");
		return armor;
	}

	@Override
	public Armor getArmorByName(String name) {
		final String SELECT_SQL = "SELECT * from armors WHERE armorname=?";
		Armor armor = jdbcTemplate.queryForObject(SELECT_SQL, new Object[] {name}, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorById : armor("+name+") was fetched");
		return armor;
	}

	@Override
	public List<Armor> getArmorsSortedByName() {
		final String SELECT_SQL = "SELECT * FROM";
		return null;
	}

	@Override
	public List<Armor> getArmorsSortedByPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Armor> getArmorsSortedByProtection() {
		// TODO Auto-generated method stub
		return null;
	}	

}
