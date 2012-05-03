package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.ICharacterInfoDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.UCharacter;

public class CharacterInfoDaoImpl implements ICharacterInfoDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int addCharacter(UCharacter character, User user) {
		String query = "INSERT INTO characters (sex, experience, strenght, agility, intellect, profession," +
				" fightsWon, fightsTotal) VALUES (?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,
				new Object[] { character.isSex(), character.getExperience(), character.getStrength(),
				character.getAgility(), character.getIntellect(), character.getProfession(), 
				character.getFightsWon(), character.getFightsTotal()});
		
		query = "SELECT characterId FROM characters WHERE characterId=MAX(characterId)";
		int id =  jdbcTemplate.queryForInt(query, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("characterId"));
					}
				});
		query = "INSERT INTO users (userCharacter) VALUES(?) WHERE userId=?";
		jdbcTemplate.update(query, new Object[] {id, user.getUserId()});

		return id;
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
