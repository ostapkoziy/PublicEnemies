package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.IProfileDao;
import com.epam.publicenemies.domain.Profession;
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
 * Updated Chetyrkin S.V. 18.05.2012
 *			added selling and buying methods for weapons, armors and aids
 * 
 *         TODO: Null Pointer exception if profile doesn't exist. Fix it!
 * 
 */
@Repository
public class ProfileDaoImpl implements IProfileDao {

	private Logger log = Logger.getLogger(ProfileDaoImpl.class);

	private JdbcTemplate jdbcTemplate;
	
	final static public double KOEF = 0.6;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private boolean buyWeapon(final int userId, final int weaponId) {
		final String TRUNK_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 1 " +
				"FROM users WHERE userId=?";
		jdbcTemplate.update(TRUNK_SQL, new Object[] {weaponId, userId});
		final String MONEY_SQL = "UPDATE users SET money=money-(SELECT weaponPrice FROM weapons WHERE weaponID=?)" +
				"WHERE userId=?";
		int i = jdbcTemplate.update(MONEY_SQL, new Object[] {weaponId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.buyWeapon: ID of weapon is " + weaponId);
			return true;
		} else return false;
	}
	
	private boolean buyAid(final int userId, final int aidId) {
		final String TRUNK_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 2 " +
				"FROM users WHERE userId=?";
		jdbcTemplate.update(TRUNK_SQL, new Object[] {aidId, userId});
		final String MONEY_SQL = "UPDATE users SET money=money-(SELECT aidPrice FROM aids WHERE aidID=?)" +
				"WHERE userId=?";
		int i = jdbcTemplate.update(MONEY_SQL, new Object[] {aidId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.buyWeapon: ID of aid is " + aidId);
			return true;
		} else return false;
	}
	
	private boolean buyArmor (final int userId, final int armorId) {
		final String TRUNK_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 3 " +
				"FROM users WHERE userId=?";
		jdbcTemplate.update(TRUNK_SQL, new Object[] {armorId, userId});
		final String MONEY_SQL = "UPDATE users SET money=money-(SELECT armorPrice FROM armors WHERE armorID=?)" +
				"WHERE userId=?";
		int i = jdbcTemplate.update(MONEY_SQL, new Object[] {armorId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.buyWeapon: ID of armor is " + armorId);
			return true;
		} else return false;
	}
	
	
	private boolean sellWeapon (final int userId, final int weaponId) {
		final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=1 AND "
				+ "itemId=? AND trunkId<>? AND trunkId<>? LIMIT 1";
		final String ADD_MONEY = "UPDATE users SET money=money+"+KOEF+"*(SELECT weaponPrice FROM weapons WHERE weaponId=?) WHERE userId=?";
		final String SELECT_SQL = "SELECT weapon1, weapon2, characterId FROM users, characters WHERE userId=? AND userCharacter=characterId";
		List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
		// This is madness!!!
		Long longWeapon1 = (Long) arr.get(0).get("weapon1");
		int intWeapon1 = longWeapon1.intValue();
		Long longWeapon2 = (Long) arr.get(0).get("weapon2");
		int intWeapon2 = longWeapon2.intValue();
		Long longCharacterId = (Long) arr.get(0).get("characterId");
		int intCharacter = longCharacterId.intValue();
		// NO! THIS! IS! !!!!JAVA!!!!
		int j = 0;
		int i = jdbcTemplate.update ( DELETE_SQL,	new Object[] { intCharacter, weaponId, intWeapon1, intWeapon2} );
		if (i > 0) {
			j = jdbcTemplate.update ( ADD_MONEY, new Object[] {weaponId,  userId} );
			if (j > 0) {
				log.info("ProfileDaoImpl.sellWeapon: ID of weapon " + weaponId);
				return true;
			} else return false;
		} else return false;
	}
	
	private boolean sellAid (final int userId, final int aidId) {

		final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=2 AND "
				+ "itemId=? AND trunkId<>? LIMIT 1";
		final String ADD_MONEY = "UPDATE users SET money=money+"+KOEF+"*(SELECT aidPrice FROM aids WHERE aidId=?) WHERE userId=?";
		final String SELECT_SQL = "SELECT aid, characterId FROM users, characters WHERE userId=? AND userCharacter=characterId";
		List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
		// This is madness!!!
		Long longAid = (Long) arr.get(0).get("aid");
		int intAid = longAid.intValue();
		Long longCharacterId = (Long) arr.get(0).get("characterId");
		int intCharacter = longCharacterId.intValue();
		// NO! THIS! IS! !!!!JAVA!!!!
		int j = 0;
		int i = jdbcTemplate.update ( DELETE_SQL, new Object[] {intCharacter, aidId, intAid} );
		if (i>0) {
			j = jdbcTemplate.update ( ADD_MONEY, new Object[] {aidId, userId} );
			log.info("add money query");
			if (j > 0) {
				log.info("ProfileDaoImpl.sellAid: ID of aid " + aidId);
				return true;
			} else return false;
		} else	return false;
	}
	
	private boolean sellArmor (final int userId, final int armorId) {
		final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=3 AND "
				+ "itemId=? AND trunkId<>? LIMIT 1";
		final String ADD_MONEY = "UPDATE users SET money=money+"+KOEF+"*(SELECT armorPrice FROM armors WHERE armorId=?) WHERE userId=?";
		final String SELECT_SQL = "SELECT armor, characterId FROM users, characters WHERE userId=? AND usercharacter=characterId";
		List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
		// This is madness!!!
		Long longArmor = (Long) arr.get(0).get("armor");
		int intArmor = longArmor.intValue();
		Long longCharacterId = (Long) arr.get(0).get("characterId");
		int intCharacter = longCharacterId.intValue();
		// NO! THIS! IS! !!!!JAVA!!!!
		int j = 0;
		int i = jdbcTemplate.update ( DELETE_SQL, new Object[] {intCharacter, armorId, intArmor} );
		if (i>0) {
			j = jdbcTemplate.update ( ADD_MONEY, new Object[] {armorId, userId} );
			if (j > 0) {
				log.info("ProfileDaoImpl.sellArmor: ID of armor " + armorId);
				return true;
			} else return false;
		} else	return false;
	}
	
	/**
	 * Sell user's weapons
	 * 
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	public boolean sellWeapons(int userId, List<Integer> weapons) {
		int count = 0;
		log.info("ProfileDaoImpl: sellWeapons - enter"); 
		for (Integer i : weapons) {
			if (sellWeapon(userId, i)) {
				count++;
			}
		}
		if (count == weapons.size()) {
			log.info("ProfileDaoImpl.sellWeapons: Were selled " + count + " weapons");
			log.info("ProfileDaoImpl: sellWeapons - leave"); 
			return true;
		}
		else {
			log.info("ProfileDaoImpl: sellWeapons - leave"); 
			return false;
		}
	}
	
	/**
	 * Sell user's aids
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	public boolean sellAids(int userId, List<Integer> aids) {
		log.info("sellAidsDao: enter");
		int count = 0;
		for (Integer i : aids) {
			log.info("Try to sell aid for user " + userId + " aid " + i);
			if (sellAid(userId, i)) {
				log.info(""); 
				count++;
			}
		}
		if (count == aids.size()) {
			log.info("ProfileDaoImpl.sellAids: Were selled " + count + " aids");
			return true;
		}
		else return false;
	}
	
	/**
	 * Sell user's armors
	 * @param userId - id of user
	 * @param armors - List of armors ids
	 * @return true if operation was successfully
	 */
	public boolean sellArmors(int userId, List<Integer> armors) {
		int count = 0;
		for (Integer i : armors) {
			if (sellArmor(userId, i)) count++;
		}
		if (count == armors.size()) {
			log.info("ProfileDaoImpl.sellWeapons: Were selled " + count + " armors");
			return true;
		}
		else return false;
	}
	
	/**
	 * Buy weapons for user
	 * @param userId - id of user
	 * @param weapons - List of weapons
	 * @return true if operation was successfully
	 */
	public boolean buyWeapons(int userId, List<Integer> weapons) {
		int count = 0;
		for (Integer i : weapons) {
			if (buyWeapon(userId, i)) count++;
		}
		if (count == weapons.size()) {
			log.info("ProfileDaoImpl.buyWeapons: Were added " + count + " weapons");
			return true;
		}
		else return false;
	}
	
	/**
	 * Buy aids for user
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	public boolean buyAids(int userId, List<Integer> aids) {
		int count = 0;
		for (Integer i : aids) {
			if (buyAid(userId, i)) count++;
		}
		if (count == aids.size()) {
			log.info("ProfileDaoImpl.buyAids: Were added " + count + " aids");
			return true;
		}
		else return false;
	}
	
	/**
	 * Buy armors for user
	 * @param userId - id of user
	 * @param armors - List armors ids
	 * @return true if operation was successfully
	 */
	public boolean buyArmors(int userId, List<Integer> armors){
		int count = 0;
		for (Integer i : armors) {
			if(buyArmor(userId, i)) count++;
		}
		if (count == armors.size()) {
			log.info("ProfileDaoImpl.buyArmors: Were added " + count + " armors");
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
		String sql = "SELECT trunkId FROM weapons, charactersTrunks WHERE characterId=? AND itemType=1 AND weaponId=ItemId ORDER BY itemId";
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
		sql.append("SELECT weaponId, weaponName, weaponHitPoints, weaponPicture, weaponType, weaponPrice, weaponDescription ");
		sql.append("FROM weapons, charactersTrunks WHERE characterId=? AND itemType=1 AND weaponId=ItemId ORDER BY itemId");
		List<Weapon> weapons = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Weapon>() {
					public Weapon mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						String description = resultSet.getString("weaponDescription");
						if(description==null) description = "no description";
						return new Weapon(resultSet.getInt("weaponId"),
								resultSet.getString("weaponName"), resultSet
										.getInt("weaponHitPoints"), resultSet
										.getString("weaponPicture"), resultSet
										.getBoolean("weaponType"), resultSet
										.getInt("weaponPrice"), description);
					}
				});
		return weapons;
	}

	private List<Integer> getAidKeys(int characterId) {
		String sql = "SELECT trunkId FROM aids, charactersTrunks WHERE characterId=? AND itemType=2 AND aidId=ItemId ORDER BY itemId";
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
		sql.append("SELECT aidId, aidName, aidType, aidPicture, aidEffect, aidPrice, aidDescription ");
		sql.append("FROM aids, charactersTrunks WHERE characterId=? AND itemType=2 AND aidId=ItemId ORDER BY itemId");
		List<Aid> aids = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Aid>() {
					public Aid mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						String description = resultSet.getString("aidDescription");
						if(description==null) description = "no description";
						return new Aid(resultSet.getInt("aidId"), resultSet
								.getString("aidName"), resultSet
								.getString("aidPicture"), resultSet
								.getInt("aidPrice"), resultSet
								.getString("aidType"), resultSet
								.getInt("aidEffect"), description);
					}
				});
		return aids;
	}

	private List<Integer> getArmorKeys(int characterId) {
		String sql = "SELECT trunkId FROM armors, charactersTrunks WHERE characterId=? AND itemType=3 AND armorId=ItemId ORDER BY itemId";
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
		sql.append("SELECT armorId, armorName, armorPicture, armorProtection, armorPrice, armorDescription ");
		sql.append("FROM armors, charactersTrunks WHERE characterId=? AND itemType=3 AND armorId=ItemId ORDER BY itemId");
		List<Armor> armors = jdbcTemplate.query(sql.toString(),
				new Object[] { characterId }, new RowMapper<Armor>() {
					public Armor mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						String description = resultSet.getString("armorDescription");
						if(description==null) description = "no description";
						return new Armor(resultSet.getInt("armorId"), resultSet
								.getString("armorName"), resultSet
								.getString("armorPicture"), resultSet
								.getInt("armorPrice"), resultSet
								.getInt("armorProtection"), description);
					}
				});
		return armors;
	}

	/**
	 * Returns necessary user Duplicates code. see UserDaoImpl
	 */
	@Override
	public User getUserById(final int userId) {
		String query = "SELECT email, password, nickName, money, avatar, userCharacter, regDate, role FROM users WHERE userId=?";
		List<User> list = jdbcTemplate.query(query, new Object[] { userId },
				new RowMapper<User>() {
					public User mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new User(userId, resultSet.getString("email"),
								resultSet.getString("password"), resultSet
										.getString("nickName"), resultSet
										.getInt("money"), resultSet
										.getString("avatar"), resultSet
										.getInt("userCharacter"), resultSet.getTimestamp("regDate"), 
										resultSet.getString("role"));
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
		final String SELECT_SQL = "SELECT characterId, sex, experience, strength, agility, intellect, " + 
				"characterProfession, fightsTotal, fightsWon, weapon1, weapon2, aid, armor, " +
				"professionId, professionName, professionAvatar FROM characters, professions " +
				"WHERE characterId=? AND characterProfession=professionId";
		UCharacter uch = this.jdbcTemplate.queryForObject( SELECT_SQL,	new Object[] { characterId }, 
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
			boolean sex, byte prof) {
		this.jdbcTemplate
				.update("UPDATE users, characters SET nickName = ?, avatar = ?, sex=?, characterProfession=? WHERE userId = ? and characterId=userCharacter",
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
		final String SQL = "SELECT sex, experience, strength, agility, intellect, "	+ 
				"characterProfession, fightsTotal, fightsWon, weapon1, weapon2, aid, armor, " +
				"professionId, professionName, professionAvatar FROM characters, professions " +
				"WHERE characterId=? AND professionAvatar=professionId";
		UCharacter ch = jdbcTemplate.queryForObject(SQL,
				new Object[] { user.getCharacterId() },
				new RowMapper<UCharacter>() {
					public UCharacter mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new UCharacter(user.getCharacterId(), resultSet
								.getBoolean("sex"), resultSet.getInt("experience"),
								resultSet.getInt("strength"), resultSet.getInt("agility"), 
								resultSet.getInt("intellect"), 
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
	public boolean updateProfileProfession(int userId, String profession) {
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

	/**
	 * Undress first weapon
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressWeapon1(int userId) {
		final String UPDATE_SQL = "UPDATE characters, users SET weapon1=0 WHERE userId=? AND characterId=userCharacter";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {userId});
		if (i>0) {
			log.info("ProfileDaoImpl.undressWeapon1 : weapon1 for user("+userId+") was undressed");
			return true;
		} else
			return false;
	}

	/**
	 * Undress second weapon
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressWeapon2(int userId) {
		final String UPDATE_SQL = "UPDATE characters, users SET weapon2=0 WHERE userId=? AND characterId=userCharacter";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {userId});
		if (i>0) {
			log.info("ProfileDaoImpl.undressWeapon2 : weapon2 for user("+userId+") was undressed");
			return true;
		} else
			return false;
	}

	/**
	 * Undress aid
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressAid(int userId) {
		final String UPDATE_SQL = "UPDATE characters, users SET aid=0 WHERE userId=? AND characterId=userCharacter";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {userId});
		if (i>0) {
			log.info("ProfileDaoImpl.undressAid : aid for user("+userId+") was undressed");
			return true;
		} else
			return false;
	}

	/**
	 * Undress armor
	 * @return true if operation is successfully
	 */
	@Override
	public boolean undressArmor(int userId) {
		final String UPDATE_SQL = "UPDATE characters, users SET armor=0 WHERE userId=? AND characterId=userCharacter";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {userId});
		if (i>0) {
			log.info("ProfileDaoImpl.undressArmor : armor for user("+userId+") was undressed");
			return true;
		} else
			return false;
	}

	/**
	 * Dress first weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	@Override
	public boolean dressWeapon1(int userId, int weaponId) {
		final String SELECT_SQL = "SELECT trunkId FROM charactersTrunks AS ct, users AS u, characters AS c WHERE " +
				"u.userId=? AND ct.itemType=1 AND ct.itemId=? AND u.userCharacter=c.characterId AND c.characterId=ct.characterId " +
				"AND ct.trunkId<>c.weapon2 LIMIT 1";
		final String UPDATE_SQL = "UPDATE characters, users SET weapon1=? WHERE userId=? AND characterId=userCharacter";
		int trunkId = jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId, weaponId});
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {trunkId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.dressWeapon1: first weapon("+weaponId+") for user("+userId+") was dressed");
			return true;
		} else
			return false;
	}

	/**
	 * Dress second weapon
	 * @param userId - id of user
	 * @param weaponId - weapon id
	 * @return true if operation is successfully
	 */
	@Override
	public boolean dressWeapon2(int userId, int weaponId) {
		final String SELECT_SQL = "SELECT trunkId FROM charactersTrunks AS ct, users AS u, characters AS c WHERE " +
				"u.userId=? AND ct.itemType=1 AND ct.itemId=? AND u.userCharacter=c.characterId AND c.characterId=ct.characterId " +
				"AND ct.trunkId<>c.weapon1 LIMIT 1";
		final String UPDATE_SQL = "UPDATE characters, users SET weapon2=? WHERE userId=? AND characterId=userCharacter";
		int trunkId = jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId, weaponId});
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {trunkId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.dressWeapon2: second weapon("+weaponId+") for user("+userId+") was dressed");
			return true;
		} else
			return false;
	}

	/**
	 * Dress aid
	 * @param userId - id of user
	 * @param aidId - aid id
	 * @return true if operation is successfully
	 */
	@Override
	public boolean dressAid(int userId, int aidId) {
		final String SELECT_SQL = "SELECT trunkId FROM charactersTrunks, users WHERE " +
				"userId=? AND itemType=2 AND itemId=? AND userCharacter=characterId LIMIT 1";
		final String UPDATE_SQL = "UPDATE characters, users SET aid=? WHERE userId=? AND characterId=userCharacter";
		int trunkId = jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId, aidId});
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {trunkId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.dressAid: aid("+aidId+") for user("+userId+") was dressed");
			return true;
		} else
			return false;
	}
	
	/**
	 * Dress armor
	 * @param userId - id of user
	 * @param armorId - armor id
	 * @return true if operation is successfully
	 */
	@Override
	public boolean dressArmor(int userId, int armorId) {
		log.info("Enter into dressArmor DAO");
		final String SELECT_SQL = "SELECT trunkId FROM charactersTrunks, users WHERE " +
				"userId=? AND itemType=3 AND itemId=? AND userCharacter=characterId LIMIT 1";
		
		final String UPDATE_SQL = "UPDATE characters, users SET armor=? WHERE userId=? AND characterId=userCharacter";
		int trunkId = jdbcTemplate.queryForInt(SELECT_SQL, new Object[] {userId, armorId});

		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {trunkId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.dressArmor: armor("+armorId+") for user("+userId+") was dressed");
			return true;
		} else
			return false;
	}

	/**
	 * Check weapon2 slot
	 * @param userId - id of user
	 * @return true if weapon2 slot is empty
	 */
	@Override
	public boolean isEmptyWeapon2(int userId) {
		final String SELECT_SQL = "SELECT weapon2 FROM users, characters WHERE userId=? AND userCharacter=characterId";
		int i = jdbcTemplate.queryForInt(SELECT_SQL, Integer.valueOf(userId));
		if(i!=0) {
			log.info("ProfileDaoImpl.isEmptyWeapon2 : not empty");
			return false;
		} else {
			log.info("ProfileDaoImpl.isEmptyWeapon2 : empty");
			return true;
		}
	}
	
	private boolean addWeapon(final int userId, final int weaponId) {
		final String INSERT_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 1 " +
				"FROM users WHERE userId=?";
		int i = jdbcTemplate.update(INSERT_SQL, new Object[] {weaponId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.addWeapon: ID of weapon (" + weaponId + ") for user(" + userId + ")");
			return true;
		} else 
			return false;
	}

	/**
	 * Add weapons for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param weapons - List of weapons ids
	 * @return true if operation was successfully
	 */
	@Override
	public boolean addWeapons(int userId, List<Integer> weapons) {
		int j = 0;
		for(Integer i : weapons) {
			if(addWeapon(userId, i)) {
				j++;
			}
		}
		if (j==weapons.size()) {
			log.info("ProfileDaoImpl.addWeapons : "+j+" weapons were added");
			return true;
		} else
			return false;
	}

	private boolean addArmor(final int userId, final int armorId) {
		final String INSERT_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 3 " +
				"FROM users WHERE userId=?";
		int i = jdbcTemplate.update(INSERT_SQL, new Object[] {armorId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.addArmor: ID of armor (" + armorId + ") for user(" + userId + ")");
			return true;
		} else 
			return false;
	}
	
	
	/**
	 * Add armors for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param armors - List of armors ids
	 * @return true if operation was successfully
	 */
	@Override
	public boolean addArmors(int userId, List<Integer> armors) {
		int j = 0;
		for(Integer i : armors) {
			if(addArmor(userId, i)) {
				j++;
			}
		}
		if (j==armors.size()) {
			log.info("ProfileDaoImpl.addArmors : "+j+" armors were added");
			return true;
		} else
			return false;
	}
	
	
	private boolean addAid(final int userId, final int aidId) {
		final String INSERT_SQL = "INSERT INTO charactersTrunks (characterId, itemId, itemType) SELECT userCharacter, ?, 2 " +
				"FROM users WHERE userId=?";
		int i = jdbcTemplate.update(INSERT_SQL, new Object[] {aidId, userId});
		if (i>0) {
			log.info("ProfileDaoImpl.addArmor: ID of aid (" + aidId + ") for user(" + userId + ")");
			return true;
		} else 
			return false;
	}

	/**
	 * Add aids for user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param aids - List of aids ids
	 * @return true if operation was successfully
	 */
	@Override
	public boolean addAids(int userId, List<Integer> aids) {
		int j = 0;
		for(Integer i : aids) {
			if(addAid(userId, i)) {
				j++;
			}
		}
		if (j==aids.size()) {
			log.info("ProfileDaoImpl.addAids : "+j+" aids were added");
			return true;
		} else
			return false;
	}
	
	
	private boolean removeWeapon(final int userId, final int weaponId) {
			final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=1 AND "
					+ "itemId=? AND trunkId<>? AND trunkId<>? LIMIT 1";
			final String SELECT_SQL = "SELECT weapon1, weapon2, characterId FROM users, characters WHERE userId=? AND userCharacter=characterId";
			List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
			// This is madness!!!
			Long longWeapon1 = (Long) arr.get(0).get("weapon1");
			int intWeapon1 = longWeapon1.intValue();
			Long longWeapon2 = (Long) arr.get(0).get("weapon2");
			int intWeapon2 = longWeapon2.intValue();
			Long longCharacterId = (Long) arr.get(0).get("characterId");
			int intCharacter = longCharacterId.intValue();
			// NO! THIS! IS! !!!!JAVA!!!!
			int i = jdbcTemplate.update (DELETE_SQL, new Object[] { intCharacter, weaponId, intWeapon1, intWeapon2});
			if (i > 0) {
				log.info("ProfileDaoImpl.removeWeapon: ID of weapon " + weaponId);
				return true;
			} else 
				return false;
	}
	
	/**
	 * Remove weapons from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param weapons - id of weapon
	 * @return true if operation was successfully
	 */
	@Override
	public boolean removeWeapons(int userId, List<Integer> weapons) {
		int j = 0;
		for (Integer i : weapons) {
			if(removeWeapon(userId, i)) {
				j++;
			}
		}
		if (j==weapons.size()) {
			return true;	
		} else 
			return false;
	}

	private boolean removeAid(final int userId, final int aidId) {
		final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=2 AND "
				+ "itemId=? AND trunkId<>? LIMIT 1";
		final String SELECT_SQL = "SELECT aid, characterId FROM users, characters WHERE userId=? AND userCharacter=characterId";
		List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
		// This is madness!!!
		Long longAid = (Long) arr.get(0).get("aid");
		int intAid = longAid.intValue();
		Long longCharacterId = (Long) arr.get(0).get("characterId");
		int intCharacter = longCharacterId.intValue();
		// NO! THIS! IS! !!!!JAVA!!!!
		int j = 0;
		int i = jdbcTemplate.update ( DELETE_SQL, new Object[] {intCharacter, aidId, intAid} );
		if (i>0) {
			log.info("ProfileDaoImpl.sellAid: ID of aid " + aidId);
			return true;
		} else	
			return false;
	}
	
	/**
	 * Remove aids from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param aids - id of aid
	 * @return true if operation was successfully
	 */
	@Override
	public boolean removeAids(int userId, List<Integer> aids) {
		int j = 0;
		for (Integer i : aids) {
			if(removeAid(userId, i)) {
				j++;
			}
		}
		if (j==aids.size()) {
			return true;	
		} else 
			return false;
	}

	private boolean removeArmor(final int userId, final int armorId) {
		final String DELETE_SQL = "DELETE FROM charactersTrunks WHERE characterId=? AND itemType=3 AND "
				+ "itemId=? AND trunkId<>? LIMIT 1";
		final String SELECT_SQL = "SELECT armor, characterId FROM users, characters WHERE userId=? AND usercharacter=characterId";
		List<Map<String, Object>> arr = jdbcTemplate.queryForList(SELECT_SQL, new Object[] {userId});
		// This is madness!!!
		Long longArmor = (Long) arr.get(0).get("armor");
		int intArmor = longArmor.intValue();
		Long longCharacterId = (Long) arr.get(0).get("characterId");
		int intCharacter = longCharacterId.intValue();
		// NO! THIS! IS! !!!!JAVA!!!!
		int j = 0;
		int i = jdbcTemplate.update ( DELETE_SQL, new Object[] {intCharacter, armorId, intArmor} );
		if (i>0) {
			log.info("ProfileDaoImpl.sellArmor: ID of armor " + armorId);
			return true;
		} else
			return false;
	}
	
	
	/**
	 * Remove armors from user (Doesn't change money amount. Only for admin)
	 * @param userId - id of user
	 * @param armors - id of armor
	 * @return true if operation was successfully
	 */
	@Override
	public boolean removeArmors(int userId, List<Integer> armors) {
		int j = 0;
		for (Integer i : armors) {
			if(removeArmor(userId, i)) {
				j++;
			}
		}
		if (j==armors.size()) {
			return true;	
		} else 
			return false;
	}

	/**
	 * Add some experience amount to userCharacter
	 * @param characterId - id of character
	 * @param experience - experience amount to add
	 * @return true if operation was successfully
	 */
	@Override
	public boolean addExperience(final int characterId, final int experience) {
		final String UPDATE_SQL = "UPDATE characters SET experience=experience+? WHERE " +
				"characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {experience, characterId});
		if (i>0) {
			log.info("ProfileDaoImpl.addExperience : "+experience+" experience where added to character("+characterId+")");
			return true;
		} else
			return false;
	}
	
	/**
	 * Update experience amount for character
	 * @param characterId - id of character
	 * @param experience - new experience amount
	 * @return true if operation was successfully
	 */
	@Override
	public boolean updateExperience(int characterId, int experience) {
		final String UPDATE_SQL = "UPDATE characters SET experience=? WHERE characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object[] {experience, characterId});
		if (i>0) {
			log.info("ProfileDaoImpl.updateExperience : "+experience+" experience where updated for character("+characterId+")");
			return true;
		} else
			return false;
	}
	
	/**
	 * Update character's stats
	 * @param strength - strength of character
	 * @param agility - agility of character
	 * @param intellect - intellect of character
	 * @return
	 */
	public boolean updateStats(int characterId, int strength, int agility, int intellect) {
		final String UPDATE_SQL = "UPDATE characters SET strength=?, agility=?, intellect=? WHERE characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object [] {strength, agility, intellect, characterId});
		if (i>0) {
			log.info("ProfileDaoImpl.updateStats : strength("+strength+"), agility("+agility+"), intellect("+intellect+") " +
					"updated for character("+characterId+")");
			return true;
		} else
			return false;
	}
	
	/**
	 * Update won fights amount
	 * @param characterId - character Id
	 * @param wonFights - amount of won fights
	 * @return true if operation was successfully
	 */
	public boolean updateWonFights(int characterId, int fightsWon) {
		final String UPDATE_SQL = "UPDATE characters SET fightsWon=? WHERE characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object [] {fightsWon, characterId});
		if (i>0) {
			log.info("ProfileDaoImpl.updateWonFights : character("+characterId+") won fights were updated");
			return true;
		} else
			return false;
	}
	
	/**
	 * Update lost fights amount
	 * @param characterId - character Id
	 * @param fightsTotal - amount of all fights
	 * @return true if operation was successfully
	 */
	public boolean updateTotalFights(int characterId, int fightsTotal) {
		final String UPDATE_SQL = "UPDATE characters SET fightsTotal=? WHERE characterId=?";
		int i = jdbcTemplate.update(UPDATE_SQL, new Object [] {fightsTotal, characterId});
		if (i>0) {
			log.info("ProfileDaoImpl.updateTotalFights : character("+characterId+") total fights were updated");
			return true;
		} else
			return false;
	}
	
	/**
	 * Uses aid in battle
	 * @param characterId - character id
	 * @return true if operation was successfully
	 */
	public boolean useAid(int characterId) {
		final String SELECT_SQL = "SELECT aid FROM characters WHERE characterId=?";
		final String UPDATE_SQL = "UPDATE characters SET aid=0 WHERE characterId=?";
		final String DELETE_SQL = "DELETE from charactersTrunks WHERE characterId=? AND trunkId=? AND itemType=2";
		
		int i = jdbcTemplate.queryForInt(SELECT_SQL, new Object [] {characterId});
		jdbcTemplate.update(UPDATE_SQL, new Object[] {characterId});
		int j = jdbcTemplate.update(DELETE_SQL, new Object[] {characterId, i});
		if (j>0) {
			log.info("ProfileDaoImpl.useAid : aid was successfully used for character("+characterId+")");
			return true;
		}else
			return false;
	}
}
