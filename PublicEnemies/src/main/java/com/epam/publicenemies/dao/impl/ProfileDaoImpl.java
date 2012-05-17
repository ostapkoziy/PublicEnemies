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
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;

/**
 * Profile data access object
 * 
 * @author Chetyrkin S.V. 14.05.2012
 * 
 * TODO: Null Pointer exception if profile doesn't exist. Fix it!
 * 
 */
public class ProfileDaoImpl implements IProfileDao {

	private Logger log = Logger.getLogger(ProfileDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Get Profile information from database
	 * @param userId - id of user
	 * @return - Profile object
	 */
	@Override
	public Profile getProfile(final int userId) {
		/** Get User object */
		User user = getUserById(userId);
		/** Get User object */
		UCharacter pCharacter = getCharacterById(user.getCharacterId());
		/** Initiate Profile object with user and character */
		Profile profile = new Profile(user, pCharacter);
		/** Get all character's weapons from trunk */
		List<Integer> keys = getWeaponKeys(user.getCharacterId());
		List<Weapon> uWeapons = getWeapons(user.getCharacterId());
		profile.fillWeaponsMap(keys, uWeapons);
		/** Get all character's aids from trunk */
		List<Integer> aidKeys = getAidKeys(user.getCharacterId());
		List<Aid> uAids = getAids(user.getCharacterId());
		profile.fillAidsMap(aidKeys, uAids);
		/** Get all character's armors from trunk */
		List<Integer> armorKeys = getArmorKeys(user.getCharacterId());
		List<Armor> uArmors = getArmors(user.getCharacterId());
		profile.fillArmorsMap(armorKeys, uArmors);
		/** Set dressed items */
		if (pCharacter.getWeapon1() != 0) {
			profile.setDressedWeapon1((Weapon) profile.getTrunkWeapon(
					pCharacter.getWeapon1()).getItem());
			profile.getTrunkWeapon(pCharacter.getWeapon1()).setWearing(true);
		} 
		if (pCharacter.getWeapon2() != 0) {
			profile.setDressedWeapon2((Weapon) profile.getTrunkWeapon(
					pCharacter.getWeapon2()).getItem());
			profile.getTrunkWeapon(pCharacter.getWeapon2()).setWearing(true);
		} 
		if (pCharacter.getAid() != 0) {
			profile.setDressedAid((Aid) profile.getTrunkAid(
					pCharacter.getAid()).getItem());
			profile.getTrunkAid(pCharacter.getAid()).setWearing(true);
		} 
		if (pCharacter.getArmor() != 0) {
			profile.setDressedArmor((Armor) profile.getTrunkArmor(
					pCharacter.getArmor()).getItem());
			profile.getTrunkArmor(pCharacter.getArmor()).setWearing(true);
		} 
		
		log.info("ProfileDaoImpl.getProfile: ID of user is " + userId);
		return profile;
	}

	private List<Integer> getWeaponKeys(int characterId) {
		String sql = "SELECT trunkId FROM weapons, charactersTrunks WHERE characterId=? AND itemType=1 AND weaponId=ItemId";
		List<Integer> keys = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("trunkId"));
					}
				});
		return keys;
	}

	private List<Weapon> getWeapons(int characterId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT weaponId, weaponName, weaponHitPoints, weaponPicture, weaponType, weaponPrice ");
		sql.append("FROM weapons, charactersTrunks WHERE characterId=? AND itemType=1 AND weaponId=ItemId");
		List<Weapon> weapons = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Weapon>() {
					public Weapon mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Weapon(resultSet.getInt("weaponId"),
								resultSet.getString("weaponName"), resultSet
										.getInt("weaponHitPoints"), resultSet
										.getString("weaponPicture"), resultSet
										.getBoolean("weaponType"), resultSet
										.getInt("weaponPrice"));
					}
				});
		return weapons;
	}

	private List<Integer> getAidKeys(int characterId) {
		String sql = "SELECT trunkId FROM aids, charactersTrunks WHERE characterId=? AND itemType=2 AND aidId=ItemId";
		List<Integer> keys = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("trunkId"));
					}
				});
		return keys;
	}

	private List<Aid> getAids(int characterId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT aidId, aidName, aidType, aidPicture, aidEffect, aidPrice ");
		sql.append("FROM aids, charactersTrunks WHERE characterId=? AND itemType=2 AND aidId=ItemId");
		List<Aid> aids = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Aid>() {
					public Aid mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Aid(resultSet.getInt("aidId"), resultSet
								.getString("aidName"), resultSet
								.getString("aidPicture"), resultSet
								.getInt("aidPrice"), resultSet
								.getString("aidType"), resultSet
								.getInt("aidEffect"));
					}
				});
		return aids;
	}

	private List<Integer> getArmorKeys(int characterId) {
		String sql = "SELECT trunkId FROM armors, charactersTrunks WHERE characterId=? AND itemType=3 AND armorId=ItemId";
		List<Integer> keys = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("trunkId"));
					}
				});
		return keys;
	}

	private List<Armor> getArmors(int characterId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT armorId, armorName, armorPicture, armorProtection, armorPrice ");
		sql.append("FROM armors, charactersTrunks WHERE characterId=? AND itemType=3 AND armorId=ItemId");
		List<Armor> armors = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Armor>() {
					public Armor mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Armor(resultSet.getInt("armorId"), resultSet
								.getString("armorName"), resultSet
								.getString("armorPicture"), resultSet
								.getInt("armorPrice"), resultSet
								.getInt("armorProtection"));
					}
				});
		return armors;
	}

	/**
	 * Returns necessary user Duplicates code. see UserDaoImpl
	 */
	@Override
	public User getUserById(final int userId) {
		String query = "SELECT * FROM users WHERE userId=?";
		List<User> list = jdbcTemplate.query(query, new Object[] { userId },
				new RowMapper<User>() {
					public User mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new User(userId, resultSet.getString("email"),
								resultSet.getString("password"), resultSet
										.getString("nickName"), resultSet
										.getInt("money"), resultSet
										.getString("avatar"), resultSet
										.getInt("userCharacter"));
					}
				});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	@Override
	public UCharacter getCharacterByUserId(int userId) {
//		String sql = "SELECT characterId, sex, experience, strength, agility, intellect, " +
//				"profession,  fightsTotal, fightsWon, weapon1, weapon2, aid, armor " +
//				"FROM users, characters WHERE userId=? AND userCharacter=characterId";
//		UCharacter ch = jdbcTemplate.queryForObject(sql, new Object [] {userId}, 
//				new RowMapper<UCharacter>() {
//			public UCharacter mapRow (ResultSet resultSet, int rowNum)
//			throws SQLException {
//				return new UCharacter(resultSet.getInt("characterId"),
//						resultSet.getBoolean("sex") ,resultSet.getInt("experience"), 
//		resultSet.getInt("strength"), agility, intelect, profession, fightsTotal, fightsWon, weapon1, weapon2, armor, aid)
//			}
//		});
		return null;
	}

	@Override
	public UCharacter getCharacterById(final int characterId) {
		log.info("ProfileDaoImpl: GetCharacterById, characterId = "
				+ characterId);
		UCharacter uch = this.jdbcTemplate.queryForObject(
				"SELECT * FROM characters WHERE characterId=?",
				new Object[] { characterId }, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UCharacter selectedCh = new UCharacter(characterId, rs
								.getBoolean("sex"), rs.getInt("experience"), rs
								.getInt("strength"), rs.getInt("agility"), rs
								.getInt("intellect"), rs
								.getString("profession"), rs
								.getInt("fightsTotal"), rs.getInt("fightsWon"),
								rs.getInt("weapon1"), rs.getInt("weapon2"), rs
										.getInt("armor"), rs.getInt("aid"));
						return selectedCh;
					}
				});
		return uch;
	}

	/*
	 * TODO: changes only nickName and avatar. Add prof. and sex
	 * 
	 * @see com.epam.publicenemies.dao.IProfileDao#updateProfile(int,
	 * java.lang.String, java.lang.String, boolean, java.lang.String)
	 */
	@Override
	public void updateProfile(int uid, String nickName, String avatar,
			boolean sex, String prof) {
		this.jdbcTemplate.update(
				"UPDATE users SET nickName = ?, avatar = ? WHERE userId = ?",
				new Object[] { nickName, avatar, new Integer(uid) });

	}

	@Override
	public UCharacter getCharacter(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProfileSex(int characterId, boolean sex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfileExpirience(int characterId, int experiance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfileStrength(int characterId, int strength) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfileAgilty(int characterId, int agility) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfileIntelect(int characterId, int intelect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProfileProffesion(int characterId, String profession) {
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
	public boolean deleteCharacter(UCharacter character) {
		// TODO Auto-generated method stub
		return false;
	}

}
