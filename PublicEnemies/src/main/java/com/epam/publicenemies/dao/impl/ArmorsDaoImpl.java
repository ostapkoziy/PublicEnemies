package com.epam.publicenemies.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.IArmorsDao;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.User;

/**
 * 
 * @author Ivan Kostyrko
 * Updated Chetyrkin_Sviatoslav 20.05.2012
 */
@Repository
public class ArmorsDaoImpl implements IArmorsDao {

	private Logger log	= Logger.getLogger(ArmorsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Armor> getAllArmors() {
		log.info("ArmorsDaoImpl: fetchAllArmors: enter");		
		return this.jdbcTemplate.query( "SELECT * FROM armors", new ArmorMapper());		
	}
	
	private final class ArmorMapper implements RowMapper<Armor> {
	    public Armor mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Armor armor = new Armor();
	        String description = rs.getString("armorDescription");
	        if (description==null) description = "no description";
	        armor.setItemId(rs.getInt("armorId"));
	        armor.setItemName(rs.getString("armorName"));
	        armor.setArmorProtection(rs.getInt("armorProtection"));
	        armor.setItemPicture(rs.getString("armorPicture"));
	        armor.setItemPrice(rs.getInt("armorPrice"));
	        armor.setItemDescription(description);
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
	public int addArmor(final String name, final String picture, final int protection, final int price, final String description) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_SQL = "INSERT IGNORE INTO armors (armorName, armorProtection, armorPicture, armorPrice, armorDescription)" +
				" VALUES (?,?,?,?,?)";
		jdbcTemplate.update(
		new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, name);
				ps.setInt(2, protection);
				ps.setString(3, picture);
				ps.setInt(4, price);
				ps.setString(5, description);
				return ps;
			}
		}, keyHolder);
		int i = keyHolder.getKey().intValue();
			log.info("ArmorsDaoImpl.addArmor : armor id is" + i);
		return i;
	}

	@Override
	public boolean updateArmorInfo(int armorId, String name, int protection,
			String picture, int price, String description) {
		final String UPDATE_SQL = "UPDATE IGNORE armors SET armorName=?, armorProtection=?, armorPicture=?," +
				" armorPrice=?, armorDescription=? WHERE armorId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {name, protection, picture, price, description, armorId});
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
		final String SELECT_SQL = "SELECT * FROM armors WHERE armorname=?";
		Armor armor = jdbcTemplate.queryForObject(SELECT_SQL, new Object[] {name}, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorById : armor("+name+") was fetched");
		return armor;
	}

	@Override
	public List<Armor> getArmorsSortedByName() {
		final String SELECT_SQL = "SELECT * FROM armors ORDER BY armorName DESC";
		List<Armor> armors = jdbcTemplate.query(SELECT_SQL, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorsSortedByName : " + armors.size() + " armors were fetched");
		return armors;
	}

	@Override
	public List<Armor> getArmorsSortedByPrice() {
		final String SELECT_SQL = "SELECT * FROM armors ORDER BY armorPrice DESC";
		List<Armor> armors = jdbcTemplate.query(SELECT_SQL, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorsSortedByPrice : " + armors.size() + " armors were fetched");
		return armors;
	}

	@Override
	public List<Armor> getArmorsSortedByProtection() {
		final String SELECT_SQL = "SELECT * FROM armors ORDER BY armorProtection DESC";
		List<Armor> armors = jdbcTemplate.query(SELECT_SQL, new ArmorMapper());
		log.info("ArmorsDaoImpl.getArmorsSortedByProtection : " + armors.size() + " armors were fetched");
		return armors;
	}

	/**
	 * Get armors amount
	 * @return amount of all armors
	 */
	@Override
	public int getArmorsAmount() {
		final String SELECT_SQL = "SELECT COUNT(*) FROM armors";
		int i = jdbcTemplate.queryForInt(SELECT_SQL);
		return i;
	}	

	/**
	 * Get all users that have same armor
	 * @param armorId - id of armor
	 * @return list of users
	 */
	@Override
	public List<User> getUsersWithArmor(int armorId) {
		final String SELECT_SQL = "SELECT userId, email, password, regDate, money, avatar, " +
				"userCharacter, nickName FROM users, charactersTrunks " +
				"WHERE userCharacter=characterId AND itemType=3 AND itemId=?";
		List<User> users = jdbcTemplate.query(SELECT_SQL, new Object[] {armorId}, new RowMapper<User>() {
			public User mapRow (ResultSet resultSet, int rowNum) throws SQLException {
				return new User(resultSet.getInt("userId"), resultSet.getString("email"), 
						resultSet.getString("password"), resultSet.getString("nickName"),
						resultSet.getInt("money"), resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"), resultSet.getTimestamp("regDate"));
			}
		});
		log.info("ArmorsDaoImpl.getUsersWithArmor : where finded "+users.size()+" users");
		return users;
	}
}
