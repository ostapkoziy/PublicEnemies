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
import com.epam.publicenemies.domain.Profession;
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

	/**
	 * Add new character
	 * @param sex - character gender
	 * @param experience - character experience
	 * @param strength - character strength
	 * @param agility - character agility
	 * @param intellect - character intellect
	 * @param charcaterProfession - profession of character
	 * @param fightsTotal - total spent fights
	 * @param fightsWon - won fights
	 * @param weapon1 - first dressed weapon 
	 * @param weapon2 - second dressed weapon
	 * @param aid - dressed aid
	 * @param armor - dressed armor
	 * @return id of of created character injection
	 */
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

	/**
	 * Create default character
	 * @return id of of created character injection
	 */
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

	/**
	 * Update character info
	 * @param sex - character gender
	 * @param experience - character experience
	 * @param strength - character strength
	 * @param agility - character agility
	 * @param intellect - character intellect
	 * @param charcaterProfession - profession of character
	 * @param fightsTotal - total spent fights
	 * @param fightsWon - won fights
	 * @param weapon1 - first dressed weapon 
	 * @param weapon2 - second dressed weapon
	 * @param aid - dressed aid
	 * @param armor - dressed armor
	 * @return true if operation was successfully
	 */
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


	/**
	 * Get UCharacter object by userId
	 * @param userId - id of user
	 * @return UCharacter object
	 */
	@Override
	public UCharacter getCharacterByUserId(int userId) {
		final String SELECT_SQL = "SELECT characterId, sex, experience, strength, agility, intellect, " +
				"characterProfession,  fightsTotal, fightsWon, weapon1, weapon2, aid, armor, " +
				"professionId, professionName, professionAvatar FROM users, characters, professions " +
				"WHERE userId=? AND userCharacter=characterId AND characterProfession=professionId LIMIT 1";
		UCharacter ch = jdbcTemplate.queryForObject(SELECT_SQL,
				new Object[] { userId }, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("professionId"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharacterByUserId: ID of user is " + userId);
		return ch;
	}

	/**
	 * Get UCharacter object by characterId
	 * @param characterId - id of character
	 * @return UCharacter object
	 */
	@Override
	public UCharacter getCharacterByCharacterId(int characterId) {
		final String SELECT_SQL = "SELECT characterId, sex, experience, strength, agility, intellect, " + 
				"characterProfession, fightsTotal, fightsWon, weapon1, weapon2, aid, armor, " +
				"professionId, professionName, professionAvatar FROM characters, professions " +
				"WHERE characterId=? AND characterProfession=professionId";
		UCharacter uch = this.jdbcTemplate.queryForObject(SELECT_SQL,new Object[] { characterId }, 
				new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("professionId"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharacterById: ID of character is " + characterId);
		return uch;
	}

	/**
	 * Get list of all registered characters
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getAllCharacters() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getAllCharacters: "+list.size()+" characters were fetched");
		return list;
	}

	/**
	 * Get list of all registered characters sorted by strength 
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getCharactersSortedByStrength() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId ORDER BY c.strength DESC";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharactersSortedByStrength: "+list.size()+" characters were fetched");
		return list;
	}

	/**
	 * Get list of all registered characters sorted by agility 
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getCharactersSortedByAgility() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId ORDER BY c.agility DESC";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharactersSortedByAgility: "+list.size()+" characters were fetched");
		return list;
	}

	/**
	 * Get list of all registered characters sorted by intellect
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getCharactersSortedByIntellect() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId ORDER BY c.intellect DESC";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharactersSortedByIntellect: "+list.size()+" characters were fetched");
		return list;
	}

	/**
	 * Get list of all registered characters sorted by spent fights
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getCharactersSortedByFights() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId ORDER BY c.fightsTotal DESC";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharactersSortedByFights: "+list.size()+" characters were fetched");
		return list;
	}

	/**
	 * Get list of all registered characters sorted by won fights
	 * @return list of all characters
	 */
	@Override
	public List<UCharacter> getCharactersSortedByWonFights() {
		final String SELECT_SQL = "SELECT c.characterId, c.sex, c.experience, c.strength, c.agility, c.intellect, " + 
				"c.characterProfession, c.fightsTotal, c.fightsWon, c.weapon1, c.weapon2, c.aid, c.armor, " +
				"p.professionName, p.professionAvatar FROM characters As c, professions As p " +
				"WHERE c.characterProfession=p.professionId ORDER BY c.fightsWon DESC";
		List<UCharacter> list = this.jdbcTemplate.query(SELECT_SQL, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"), resultSet.getBoolean("sex"), 
								resultSet.getInt("experience"),	resultSet.getInt("strength"), 
								resultSet.getInt("agility"), resultSet.getInt("intellect"), 
								new Profession( 
										resultSet.getByte("characterProfession"),
										resultSet.getString("professionName"), 
										resultSet.getString("professionAvatar")
										),
								resultSet.getInt("fightsTotal"), resultSet.getInt("fightsWon"),
								resultSet.getInt("weapon1"), resultSet.getInt("weapon2"),
								resultSet.getInt("armor"), resultSet.getInt("aid"));
					}
				});
		log.info("CharacterDaoImpl.getCharactersSortedByWonFights: "+list.size()+" characters were fetched");
		return list;
	}

	

	
	
}
