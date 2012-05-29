package com.epam.publicenemies.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement; 
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;
import com.epam.publicenemies.domain.Weapon;


/**
 * Manages requests for 'user' table
 * 
 * Updated by Chetyrkin S.V.
 * Updated by I. Kostyrko on 30.04.2012: 
 * 		select queries changed; 
 * 		register method;
 * 
 * TODO: add moneyUpdate method; to declare all queries as final fields etc.
 * */
public class UserDaoImpl implements IUserDao {

	private Logger log = Logger.getLogger(UserDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	private final class UserMapper implements RowMapper<User> {
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	return new User(rs.getInt("userId"), 
					rs.getString("email"), 
					rs.getString("password"), 
					rs.getString("nickName"),
					rs.getInt("money"),
					rs.getString("avatar"),
					rs.getInt("userCharacter"),
					rs.getTimestamp("regDate"));
	    } 
	}
	
	/**
	 * Get user registration date
	 * @param userId - id of user
	 * @return - registration date
	 */
	public Timestamp getUserRegDate (int userId) {
		final String SELECT_SQL = "SELECT regDate FROM users WHERE userId=?";
		Timestamp time = (Timestamp) jdbcTemplate.queryForObject(SELECT_SQL, new Object[] {userId},
		new RowMapper<Timestamp>() {
			public Timestamp mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				return resultSet.getTimestamp("regdate");
			}
		
		});
		return time;
	}
	
	/**
	 * Get amount of of registered users
	 * @return amount of of registered users
	 */
	public int getUsersAmount () {
		final String AMOUNT_SQL = "SELECT COUNT(*) FROM users";
		int i = jdbcTemplate.queryForInt(AMOUNT_SQL);
		return i;
	}
	
	/**
	 * Get last 5 registered users
	 * @return List of 5 users
	 */
	public List<User> getNewUsers () {
		final String USERS_SQL = "SELECT userId, email, password, nickName, money, avatar, userCharacter, regDate" +
				" FROM users ORDER BY regDate LIMIT 5";
		List<User> list = jdbcTemplate.query(USERS_SQL, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				return new User ( resultSet.getInt("userId"), resultSet.getString("email"),
						resultSet.getString("password"), resultSet.getString("nickName"),
						resultSet.getInt("money"), resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"), resultSet.getTimestamp("regDate") );
			}
		});
		return list;
	}
	
	/**
	 * Registers new user with email, password and nick name and returns id
	 * 
	 * @param user - User object
	 * @return id of inserted user
	 * */
	public int registerUser(User user) {
		return this.registerUser(user.getEmail(), user.getPassword(), user.getNickName()); 
	}

	/**
	 * Register new user with email, password, nickName
	 *  
	 * Updated by I. Kostyrko on 30.04.12: one query instead of two (see previous method)
	 *   
	 * @param email - email (unique)
	 * @param password - password 
	 * @param nickname - nickname (unique)
	 * @return id of inserted entry or -1 if parameters are bad 
	 */
	public int registerUser(final String email, final String password,
			final String nickName) {
		// check parameters
		if (email == null || password == null || nickName == null) {
			return -1;
		}
		// will contain id of inserted entry
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_USER_SQL = "INSERT INTO users (email, password, nickName, userCharacter) VALUES (?,?,?,?)";
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, email);
						ps.setString(2, password);
						ps.setString(3, nickName);
						// create new character entry
						ps.setInt(4, createCharacterEntry()); 
						return ps;
					}
				}, keyHolder);
		log.info("UserDaoImpl.regiserUser: ID is " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();		
	}
	
	
	/**
	 * Register new user
	 * @param email - user email
	 * @param password - user password
	 * @param nickName - user nickName
	 * @param money - money of user
	 * @param avatar - user avatar
	 * @param userChar - id of user's character
	 * @return id of registered user
	 */
	public int registerUser(final String email, final String password, final String nickName,
			final int money, final String avatar) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_USER_SQL = "INSERT INTO users (email, password, nickName, userCharacter, " +
				"money, avatar) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) 
							throws SQLException { PreparedStatement ps = connection.prepareStatement
							(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS);
						ps.setString(1, email);
						ps.setString(2, password);
						ps.setString(3, nickName);
						ps.setInt(4, createCharacterEntry());
						ps.setInt(5, money);
						ps.setString(6, avatar);
						return ps;
					}
				}, keyHolder);
		int i = keyHolder.getKey().intValue();
		log.info("UserDaoImpl.regiserUser: ID is " + i);
		return i;
	}
	
	/**
	* Check for existing registered email
	* @param email - checked email
	* @return boolean exist or not
	* */
	public boolean checkExistedUserEmail (String email){
		final String query = "SELECT userId FROM users WHERE email = ?";
		
		int i = jdbcTemplate.queryForInt(query,
				new Object[] {email}, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("userId"));
					}
				});
		if (i==0) return false;
		else return true;
	}
	
	/**
	*  
	* Find user by its unique id
	* 
	* Updated on 30.04.12 (K.I.): 
	* 	updated SELECT query 
	*  
	* To fix: return statement (there is the list(!) 
	* 		  but we need only one object always);
	* 		  add other parameters for fetching 							
	* 
	* @param id - id of user you are looking for
	* @return User object
	* */
	public User findUserById(final int userId) {
		final String query = "SELECT email, password, nickName, money, avatar, userCharacter, regDate FROM users WHERE userId=?";
		List<User> list = jdbcTemplate.query(query, new Object[]{userId}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(userId, 
						resultSet.getString("email"), 
						resultSet.getString("password"), 
						resultSet.getString("nickName"),
						resultSet.getInt("money"),
						resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"),
						resultSet.getTimestamp("regDate")
						);
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	* Find user by email (unique)
	* Use checkExistedUserEmail() instead of this
	* 
	* @param email - user email
	* @param password - user password
	* @return User object
	* */
	public User findUserByEmailAndPassword(final String email, final String password){
		final String query = "SELECT userId, nickName, money, avatar, userCharacter, regDate FROM users WHERE email=? AND password=?";
		List <User> list = jdbcTemplate.query(query, new Object[]{email, password}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getInt("userId"), email, password, 
						resultSet.getString("nickName"),
						resultSet.getInt("money"),
						resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"),
						resultSet.getTimestamp("regDate"));
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	/**
	* Find user by email
	* @param email - email of user that you are looking for
	* @return User object
	* */
	public User findUserByEmail(final String email) {
		final String query = "SELECT userId, password, nickName, money, avatar, userCharacter, regDate FROM users WHERE email=?";
		List <User> list = jdbcTemplate.query(query, new Object[]{email}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getInt("userId"),	email, 
						resultSet.getString("password"), 
						resultSet.getString("nickName"),
						resultSet.getInt("money"),
						resultSet.getString("avatar"),
						resultSet.getInt("userCharacter"),
						resultSet.getTimestamp("regDate"));
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	* Update user email and password
	* @param user - User object
	* @return true if operation successfully 
	* */
	public boolean updateUserEmailAndPassword(User user) {
		final String query = "UPDATE users SET email=?, password=?, WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] { user.getEmail(), user.getPassword(),
						user.getUserId() });
		if (i==0) return false;
		else return true;
	}

	/**
	* Update user avatar
	* @param userId - id of user
	* @param avatar - path to avatar image on server
	* @return true if operation successfully  
	* */
	public boolean updateUserAvatar(int userId, String avatar){
		final String query = "UPDATE users SET avatar=? WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] {avatar, userId});
		if (i==0) return false;
		else return true;
	}
	
	/**
	* Update user nick name
	* @param userId - id of user
	* @param nickName - nick name of user
	* @return true if operation successfully  
	* */
	public boolean updateUserNickName(int userId, String nickName){
		final String query = "UPDATE users SET nickName=? WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] {nickName, userId});
		if (i==0) return false;
		else return true;
	}
	
	/**
	* Change all user personal information (user are fetched by id)
	* @param user - User object
	* @return true if operation successfully  
	* */
	public boolean updateUserInfo (User user){
		final String query = "UPDATE IGNORE users SET email=?, password=?, nickName=?, avatar=?, WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] {user.getEmail(), user.getPassword(), user.getNickName(), user.getAvatar(), user.getUserId()});
		if (i==0) return false;
		else return true;
	}
	
	/**
	 * Update user's fields
	 * @param userId - user id
	 * @param email - user's email
	 * @param nickname - user's nick name
	 * @param avatar - user's avatar
	 * @param money - user's amount of money
	 * @param userCharacter - id of users's character
	 * @return
	 */
	public boolean updateUserInfo(int userId, String email, String nickName, String avatar, int money, int userCharacter) {
		final String UPDATE_SQL = "UPDATE IGNORE users SET email=?, nickName=?, avatar=?, money=?, userCharacter=? WHERE userId=?";
		int i = jdbcTemplate.update( UPDATE_SQL, new Object[]{ email, nickName, avatar, money, userCharacter, userId } );
		if (i>0) {
			log.info("UserDaoImpl.updatUserInfo : user("+userId+") updated");
			return true;
		} else	return false;
	}
	
	/**
	* Delete user
	* @param userId - id of user
	* */
	public boolean deleteUser(User user) {
		final String DELERE_SQL = "DELETE u, c, ct FROM users AS u, characters AS c, charactersTrunks AS ct " +
				"WHERE u.userId=? AND u.userCharacter=c.characterId AND c.characterId=ct.characterId";
		int i = jdbcTemplate.update( DELERE_SQL, new Object[] { user.getUserId() });
		if (i!=0) {
			log.info("UserDaoImpl.deleteUser : user("+user.getUserId()+") was deleted");
			return true;
		} else 
			return false;
	}
	
	/**
	* Delete user
	* @param userId - id of user
	* */
	public boolean deleteUser(int userId){
		final String query = "DELETE u, c, ct FROM users AS u, characters AS c, charactersTrunks AS ct " +
				"WHERE u.userId=? AND u.userCharacter=c.characterId AND c.characterId=ct.characterId";
		int i = jdbcTemplate.update(query, new Object[] { userId });
		if (i!=0) {
			log.info("UserDaoImpl.deleteUser : user("+userId+") was deleted");
			return true;
		} else
			return false;
	}

	/**
	* Fetch all users from database
	* @return List<User> - list of all users on database
	* */
	public List<User> findAllUsers() {
		final String SELECT_SQL = "SELECT * FROM users";
		return jdbcTemplate.query(SELECT_SQL, new UserMapper());
	}
	
	/**
	 * Created character entry. Uses before user creation
	 * @return identifier
	 */
	private int createCharacterEntry() {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		final String INSERT_CHARACTER_SQL = "INSERT INTO characters (sex) VALUES (?)";
		jdbcTemplate.update(
				new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
						PreparedStatement ps = connection.prepareStatement(INSERT_CHARACTER_SQL, Statement.RETURN_GENERATED_KEYS);
						ps.setBoolean(1, true);						 
						return ps;
					}
				}, keyHolder);
		log.info("UserDaoImpl.createCharacterEntry: ID is " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();	
	}

	/**
	 * Update money amount
	 * @param userId - id of user
	 * @param money - amount of money
	 * @return true if operation was successful
	 */
	public boolean updateMoney(int userId, int money) {
		final String UPDATE_MONEY = "UPDATE users SET money=? WHERE userId=?";
		int i = 0;
		i = jdbcTemplate.update(UPDATE_MONEY, new Object[] { money, userId});
		if (i>0) {
			log.info("UserDaoImpl.updateMoney: userId is " + userId + " new money amount is " + money);
			return true;
		} else return false;
	}
	
	/**
	 * Get list of all users sorted by nick name
	 * @return list of all users
	 */
	public List<User> getUsersSortedByNick() {
		final String SELECT_SQL = "SELECT * FROM users ORDER BY nickName";
		return jdbcTemplate.query(SELECT_SQL, new UserMapper());
	}
	
	/**
	 * Get list of all users sorted by registration date
	 * @return list of all users
	 */
	public List<User> getUsersSortedByRegDate() {
		final String SELECT_SQL = "SELECT * FROM users ORDER BY regDate";
		return jdbcTemplate.query(SELECT_SQL, new UserMapper());
	}

	/**
	 * Get list of Maps. Map has two values: nickname with key 'nickName'
	 * and experience with key 'experience' 
	 * @return list of maps
	 */
	@Override
	public List<Map<String, Object>> getUsersSortedByExperience() {
		final String SELECT_SQL = "SELECT nickName, experience FROM users, characters WHERE userCharacter=characterId ORDER BY experience";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(SELECT_SQL);
		log.info("UserDaoImpl.getUsersSortedByExperience : "+list.size()+" users were fetched");
		return list;
	}

	/**
	 * Get list of all users sorted by money amount
	 * @return list of all users
	 */
	@Override
	public List<Map<String, Object>> getUsersSortedByMoney() {
		final String SELECT_SQL = "SELECT nickName, money FROM users ORDER BY money";
		List <Map<String, Object>> list = jdbcTemplate.queryForList(SELECT_SQL);
		log.info("UserDaoImpl.getUsersSortedByMoney : "+list.size()+" users were fetched");
		return list;
	}
	
}