package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.web.LoginUserFormController;

public class ProfileDaoImpl implements IProfileDao {

	private Logger log	= Logger.getLogger(LoginUserFormController.class);
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void updateProfile(Profile profile) {
		/*
		String query = "UPDATE profile SET nickName=?,avatar=?,gender=?,proffesion=?,fightsTotal=?,fightsWon=? WHERE id = ?";
		jdbcTemplate.update(
				query,
				new Object[] { profile.getNickName(), profile.getAvatar(),
						profile.getGender(), profile.getProffesion(),
						profile.getFightsTotal(), profile.getFightsWon() });
		*/
	}

	@Override
	public void deleteProfile(Profile profile) {
		/*String query = "DELETE FROM profile WHERE id = ?";
		jdbcTemplate.update(query, new Object[] { profile.getId() });*/
	}
	
	/**
	 * Returns necessary user 
	 * Duplicates code. see UserDaoImpl
	 */
	@Override
	public User getUserById(final int userId) {		
		String query = "SELECT * FROM users WHERE userId=?";
		List<User> list = jdbcTemplate.query(query, new Object[]{userId}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(userId, 
						resultSet.getString("email"), 
						resultSet.getString("password"), 
						resultSet.getString("nickName"),
						resultSet.getInt("money"),
						resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"));
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public UCharacter getCharacterByUserId(int userId) {
		//String query = "SELECT " + 
		//		"u.userId, u.email, u.money, u.avatar u.nickName, characters.* FROM users INNER JOIN characters ON";
		return null;
	}

	@Override
	public UCharacter getCharacterById(final int characterId) {
		log.info("ProfileDaoImpl: GetCharacterById, characterId = " + characterId); 
		UCharacter uch =  this.jdbcTemplate.queryForObject(
				"SELECT * FROM characters WHERE characterId=?",
		        new Object[]{characterId},
		        new RowMapper<UCharacter>() {
		            public UCharacter mapRow(ResultSet rs, int rowNum) throws SQLException {
		                UCharacter selectedCh = new UCharacter(
		                		characterId, 
		                		rs.getBoolean("sex"),		                		
		                		rs.getInt("experience"),
		                		rs.getInt("strength"),
		                		rs.getInt("agility"),
		                		rs.getInt("intellect"),
		                		rs.getString("profession"),
		                		rs.getInt("fightsTotal"),
		                		rs.getInt("fightsWon"),
		                		rs.getInt("weapon1"),
		                		rs.getInt("weapon2"),
		                		rs.getInt("armor"),
		                		rs.getInt("aid"));
		                return selectedCh;
		            }
		        });
		return uch;		
	}

	/*
	 * TODO: changes only nickName and avatar. Add prof. and sex
	 * @see com.epam.publicenemies.dao.IProfileDao#updateProfile(int, java.lang.String, java.lang.String, boolean, java.lang.String)
	 */
	@Override
	public void updateProfile(int uid, String nickName, String avatar,
			boolean sex, String prof) {
		this.jdbcTemplate.update(
				"UPDATE users SET nickName = ?, avatar = ? WHERE userId = ?",
				new Object[] { nickName, avatar, new Integer(uid) });

	}
	
}
