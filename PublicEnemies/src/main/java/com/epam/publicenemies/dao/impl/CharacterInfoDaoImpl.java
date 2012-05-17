package com.epam.publicenemies.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.publicenemies.dao.ICharacterInfoDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.UCharacter;

public class CharacterInfoDaoImpl implements ICharacterInfoDao {
	
	private Logger log = Logger.getLogger(CharacterInfoDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Add new character for user
	 * @param character - Character object
	 * @param user - User object
	 * @return id of new character
	 */
	@Override
	public int addCharacter(final UCharacter character, User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_CHARACTER_SQL = "INSERT INTO characters (sex, experience, strenght, agility, intellect, profession," +
				" fightsWon, fightsTotal) VALUES (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(INSERT_CHARACTER_SQL, Statement.RETURN_GENERATED_KEYS);
						ps.setBoolean(1, character.isSex());	
						ps.setInt(2, character.getExperience());
						ps.setInt(3, character.getStrength());
						ps.setInt(4, character.getAgility());
						ps.setInt(5, character.getIntellect());
						ps.setString(6, character.getProfession());
						ps.setInt(7, character.getFightsWon());
						ps.setInt(8, character.getFightsTotal());
						return ps;
					}
				}, keyHolder);
		log.info("UserDaoImpl.createCharacterEntry: ID is " + keyHolder.getKey().intValue());
		
		String query = "UPDATE users SET userCharacter=? WHERE userID=?";
		jdbcTemplate.update(query, new Object[] {keyHolder.getKey().intValue(), user.getUserId()});
		return keyHolder.getKey().intValue();
	}

	@Override
	public int addCharacter(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UCharacter getCharacter(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UCharacter getCharacter(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCharacterSex(int characterId, boolean sex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterExpirience(int characterId, int experiance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterStrength(int characterId, int strength) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterAgilty(int characterId, int agilty) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterIntellect(int characterId, int intellect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterProffesion(int characterId, String proffesion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addWonFight(int characterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addLostFight(int characterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCharacterInfo(UCharacter character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharacter(UCharacter character) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
