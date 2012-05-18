package com.epam.publicenemies.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profile;
import com.epam.publicenemies.domain.UCharacter;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;
import com.epam.publicenemies.domain.Aid;
import com.epam.publicenemies.domain.Armor;
import com.mysql.jdbc.Statement;

/**
 * Profile data access object
 * 
 * @author Chetyrkin S.V. 14.05.2012
 * 
 *         TODO: Null Pointer exception if profile doesn't exist. Fix it!
 * 
 */
public class ProfileDaoImpl implements IProfileDao {

	private Logger log = Logger.getLogger(ProfileDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	
	private boolean buyWeapon(final int userId, final int weaponId) {
		final String TRUNK_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 1 " +
				"FROM users WHERE userId=?";
		jdbcTemplate.update(TRUNK_SQL, new Object[] {weaponId, userId});
		final String MONEY_SQL = "UPDATE users SET money=money-(SELECT weaponPrice FROM weapon WHERE weaponID=?)" +
				"WHERE userid=?";
		int i = jdbcTemplate.update(MONEY_SQL, new Object[] {weaponId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.buyWeapon: ID of weapon is " + weaponId);
			return true;
		} else return false;
	}
	
	private boolean buyAid(final int userId, final int aidId) {
		return false;
	}
	
	/**
	 * Buy weapons for user
	 * @param userId - id of user
	 * @param weapons - List of weapons
	 * @return true if operation was successfully
	 */
	public boolean buyWeapons(int userId, List<Integer> weapons) {
		int count=0;
		for (Integer i : weapons) {
			if(buyWeapon(userId, i))
			count++;
		}
		if (count==weapons.size()){
			log.info("ProfileDaoImpl.buyWeapons: Were added " + count + " weapons");
			return true;
		}
		else return false;
	}
	
	
	/**
	 * Get Profile information from database
	 * 
	 * @param userId
	 *            - id of user
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
			profile.setDressedAid((Aid) profile
					.getTrunkAid(pCharacter.getAid()).getItem());
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
		log.info("ProfileDaoImpl.getUserById: ID of user is " + userId);
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	/**
	 * Get UCharacter by user id
	 * 
	 * @param userId
	 *            - id of user
	 * @return - UCharacter object
	 */
	@Override
	public UCharacter getCharacterByUserId(int userId) {
		String sql = "SELECT characterId, sex, experience, strength, agility, intellect, "
				+ "profession,  fightsTotal, fightsWon, weapon1, weapon2, aid, armor "
				+ "FROM users, characters WHERE userId=? AND userCharacter=characterId";
		UCharacter ch = jdbcTemplate.queryForObject(sql,
				new Object[] { userId }, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(resultSet.getInt("characterId"),
								resultSet.getBoolean("sex"), resultSet
										.getInt("experience"), resultSet
										.getInt("strength"), resultSet
										.getInt("agility"), resultSet
										.getInt("intellect"), resultSet
										.getString("profession"), resultSet
										.getInt("fightsTotal"), resultSet
										.getInt("fightsWon"), resultSet
										.getInt("weapon1"), resultSet
										.getInt("weapon2"), resultSet
										.getInt("armor"), resultSet
										.getInt("aid"));
					}
				});
		log.info("ProfileDaoImpl.getCharacterByUserId: ID of user is " + userId);
		return ch;
	}

	/**
	 * Get character by character Id
	 * 
	 * @param characterId
	 *            - id of character
	 * @return UCharacter object
	 */
	@Override
	public UCharacter getCharacterById(final int characterId) {
		log.info("ProfileDaoImpl: GetCharacterById, characterId = "
				+ characterId);
		UCharacter uch = this.jdbcTemplate.queryForObject(
				"SELECT * FROM characters WHERE characterId=?",
				new Object[] { characterId }, new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new UCharacter(characterId,
								rs.getBoolean("sex"), rs.getInt("experience"),
								rs.getInt("strength"), rs.getInt("agility"), 
								rs.getInt("intellect"), rs.getString("profession"), 
								rs.getInt("fightsTotal"), rs.getInt("fightsWon"), 
								rs.getInt("weapon1"), rs.getInt("weapon2"), 
								rs.getInt("armor"),	rs.getInt("aid"));
					}
				});
		log.info("ProfileDaoImpl.getCharacterById: ID of character is "
				+ characterId);
		return uch;
	}

	/**
	 * Update nick name, avatar, sex and profession by user id
	 * 
	 * @param uid
	 *            - user id
	 * @param nickName
	 *            - nick name
	 * @param avatar
	 *            - avatar
	 * @param prof
	 *            - profession
	 */
	@Override
	public void updateProfile(int uid, String nickName, String avatar,
			boolean sex, String prof) {
		this.jdbcTemplate
				.update("UPDATE users, characters SET nickName = ?, avatar = ?, sex=?, profession=? WHERE userId = ? and characterId=userCharacter",
						new Object[] { nickName, avatar, sex, prof, uid });
		log.info("ProfileDaoImpl.getUpdateProfile: ID of user is " + uid);
	}

	/**
	 * Get Character by User object
	 * 
	 * @param user
	 *            - User object
	 * @return uCharacter object
	 */
	@Override
	public UCharacter getCharacter(final User user) {
		String sql = "SELECT sex, experience, strength, agility, intellect, "
				+ "profession,  fightsTotal, fightsWon, weapon1, weapon2, aid, armor "
				+ "FROM characters WHERE characterId=?";
		UCharacter ch = jdbcTemplate.queryForObject(sql,
				new Object[] { user.getCharacterId() },
				new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(user.getCharacterId(), resultSet
								.getBoolean("sex"), resultSet
								.getInt("experience"), resultSet
								.getInt("strength"), resultSet
								.getInt("agility"), resultSet
								.getInt("intellect"), resultSet
								.getString("profession"), resultSet
								.getInt("fightsTotal"), resultSet
								.getInt("fightsWon"), resultSet
								.getInt("weapon1"),
								resultSet.getInt("weapon2"), resultSet
										.getInt("armor"), resultSet
										.getInt("aid"));
					}
				});
		log.info("ProfileDaoImpl.getCharacterByUserId: ID of character is "
				+ user.getCharacterId());
		return ch;
	}

	/**
	 * Update character sex
	 * 
	 * @param userId
	 *            - id of user
	 * @param sex
	 *            - UCharacter sex
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileSex(int userId, boolean sex) {
		String sql = "UPDATE characters, users SET sex = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { sex, userId });
		if (i > 0) {
			log.info("ProfileDaoImpl.updateProfileSex: ID of user is " + userId);
			return true;
		}
		else {
			log.info("ProfileDaoImpl.updateProfileSex: ID of user is " + userId);
			return false;
		}
	}

	/**
	 * Update character experience
	 * @param userId - id of user
	 * @param experiance - amount of experience
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileExpirience(int userId, int experiance) {
		String sql = "UPDATE characters, users SET experience = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { experiance, userId });
		if (i > 0){
			log.info("ProfileDaoImpl.updateProfileExperience: ID of user is " + userId);
			return true;
		}
		else {
			log.info("ProfileDaoImpl.updateProfileExperience: ID of user is " + userId);
			return false;
		}
	}

	/**
	 * Update character strength
	 * @param userId - id of user
	 * @param strength - amount of strength
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileStrength(int userId, int strength) {
		String sql = "UPDATE characters, users SET strength = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { strength, userId });
		if (i > 0){
			log.info("ProfileDaoImpl.updateProfileStrength: ID of user is " + userId);
			return true;
		}
		else {
			log.info("ProfileDaoImpl.updateProfileStrength: ID of user is " + userId);
			return false;
		}
	}

	/**
	 * Update character agility
	 * @param userId - id of user
	 * @param agility - amount of agility
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileAgilty(int userId, int agility) {
		String sql = "UPDATE characters, users SET agility = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { agility, userId });
		if (i > 0){
			log.info("ProfileDaoImpl.updateProfileAgility: ID of user is " + userId);
			return true;
		}
		else {
			log.info("ProfileDaoImpl.updateProfileAgility: ID of user is " + userId);
			return false;
		}
	}

	/**
	 * Update character intellect
	 * @param userId - id of user
	 * @param intelect - amount of intellect
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileIntelect(int userId, int intellect) {
		String sql = "UPDATE characters, users SET intellect = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { intellect, userId });
		if (i > 0) {
			log.info("ProfileDaoImpl.updateProfileIntellect: ID of user is " + userId);
			return true;
		}
		else{
			log.info("ProfileDaoImpl.updateProfileIntellect: ID of user is " + userId);
			return false;
		}
			
	}

	/**
	 * Update character profession
	 * @param userId - id of user
	 * @param profession - character profession
	 * @return true if operation is successfully
	 */
	@Override
	public boolean updateProfileProffesion(int userId, String profession) {
		String sql = "UPDATE characters, users SET profession = ? WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { profession, userId });
		if (i > 0){
			log.info("ProfileDaoImpl.updateProfileProfession: ID of user is " + userId);
			return true;
		}
		else
			log.info("ProfileDaoImpl.updateProfileProfession: ID of user is " + userId);
			return false;
	}

	/**
	 * Add won fight
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	@Override
	public boolean addWonFight(int userId) {
		String sql = "UPDATE characters, users SET fightsWon = fightsWon+1, fightsTotal=fightsTotal+1 WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { userId });
		if (i > 0){
			log.info("ProfileDaoImpl.addWonFight: ID of user is " + userId);
			return true;
		}
		else
			log.info("ProfileDaoImpl.addWonFight: ID of user is " + userId);
			return false;
	}

	/**
	 * Add lost fight 
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	@Override
	public boolean addLostFight(int userId) {
		String sql = "UPDATE characters, users SET fightsTotal=fightsTotal+1 WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.update(sql, new Object[] { userId });
		if (i > 0){
			log.info("ProfileDaoImpl.addLostFight: ID of user is " + userId);
			return true;
		}
		else
			log.info("ProfileDaoImpl.addLostFight: ID of user is " + userId);
			return false;
	}

	/**
	 * Delete character(and user)
	 * @param userId - id of user
	 * @return true if operation is successfully
	 */
	@Override
	public boolean deleteCharacter(int userId) {
		String sql = "DELETE ch FROM users user, characters ch " +
				"WHERE user.userId=? AND user.userCharacter=ch.characterId";
		int j = jdbcTemplate.update(sql, new Object[] { userId });
		if (j > 0){
			log.info("ProfileDaoImpl.deleteCharacter: ID of user is " + userId);
			return true;
		}
		else
			log.info("ProfileDaoImpl.deleteCharacter: ID of user is " + userId);
			return false;
	}

}
