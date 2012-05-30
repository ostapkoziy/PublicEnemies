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

import com.epam.publicenemies.dao.ICharacterDao;
import com.epam.publicenemies.domain.Armor;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.UCharacter;

/**
 * 
 * @author Chetyrkin_Sviatoslav 18.05.2012
 *
 */
@Repository
public class CharacterDaoImpl implements ICharacterDao {
	
	private Logger log = Logger.getLogger(CharacterDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
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
		final String INSERT_CHARACTER_SQL = "INSERT INTO characters (sex, experience, strenght, agility, intellect, characterProfession," +
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
						ps.setByte(6, character.getCharacterProfession().getProfessionId());
						ps.setInt(7, character.getFightsWon());
						ps.setInt(8, character.getFightsTotal());
						return ps;
					}
				}, keyHolder);
		int i = keyHolder.getKey().intValue();
		log.info("CharacterDaoImpl.addCharacter: character("+i+") was added"  );
		String query = "UPDATE users SET userCharacter=? WHERE userID=?";
		jdbcTemplate.update(query, new Object[] {i, user.getUserId()});
		return i;
	}

	@Override
	public int addCharacter(final boolean sex, final int experience, final int strength,
			final int agility, final int intellect, final byte characterProfession) {
		final String INSERT_SQL = "INSERT INTO characters (sex, experience, strength, agility, intellect," +
				"characterProfession) VALUES (?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
						ps.setBoolean(1, sex);	
						ps.setInt(2, experience);
						ps.setInt(3, strength);
						ps.setInt(4, agility);
						ps.setInt(5, intellect);
						ps.setByte(6, characterProfession);
						return ps;
					}
				}, keyHolder);
		int i = keyHolder.getKey().intValue();
		log.info("CharacterDaoImpl.add: character("+i+") was created");
		return i;
	}

	@Override
	public int addCharacter() {
		final String INSERT_SQL = "INSERT INTO characters VALUES ()";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
						return ps;
					}
				}, keyHolder);
		int i = keyHolder.getKey().intValue();
		log.info("CharacterDaoImpl.add: character("+i+") was created");
		return i;
	}

	@Override
	public boolean updateCharacterInfo(int characterId, boolean sex, int experience,
			int strength, int agility, int intellect, byte charcaterProfession,
			int fightsTotal, int fightsWon) {
		final String UPDATE_SQL = "UPDATE characters SET sex=?, experience=?, strength=?, agility=?," +
				" intellect=?, characterProfession=?, fightsTotal=?, fightsWon=? WHERE characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {sex, experience, strength, agility, intellect,
				charcaterProfession, fightsTotal, fightsWon});
		if (i>0) {
			log.info("CharcaterDaoImpl.updateCharacterInfo : character("+characterId+") was updated");
			return true;
		} else 
			return false;
	}

	@Override
	public boolean getCharacterByUserId(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCharacterByCharacterId(int characterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharacterByUserId(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCharacterByCharacterId(int characterId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UCharacter> getAllCharacters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UCharacter> getCharactersSortedByStrength() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UCharacter> getCharactersSortedByAgility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UCharacter> getCharactersSortedByIntellect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UCharacter> getCharactersSortedByFights() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UCharacter> getCharactersSortedByWonFughts() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
}
