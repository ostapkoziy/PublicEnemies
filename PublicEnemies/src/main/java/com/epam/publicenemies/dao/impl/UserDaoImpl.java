package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.epam.publicenemies.dao.IUserDao;
import com.epam.publicenemies.domain.User;


/**
 * Updated by Chetyrkin S.V.
 * */
public class UserDaoImpl implements IUserDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Registers new user with email, password and nick name
	 * and gets his Id
	 * @param user - User object
	 * @return id of inserted user
	 * */
	public int registerUser(User user) {
		String query = "INSERT INTO users (email, password, nickName) VALUES (?,?,?)";
		jdbcTemplate.update(query,
				new Object[] { user.getEmail(), user.getPassword(), user.getEmail() });
		// must change registration form because nick name must be unique
		query = "SELECT userId FROM users WHERE email=?";
		return (Integer) jdbcTemplate.queryForObject(query,
				new Object[] { user.getEmail()}, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("userId"));
					}
				});
	}

	/**
	 * Register new user with email, password and nick name
	 * @param email - email of new user
	 * @param password - password of new user
	 * @param nickname - nick name of new user
	 * @return id of inserted user
	 */
	public int registerUser (String email, String password, String nickName) {
		String query = "INSERT INTO users (email, password, nickName) VALUES (?,?,?)";
		jdbcTemplate.update(query,
				new Object[] { email, password, email});
		// must change registration form because nick name must be unique
		query = "SELECT userId FROM users WHERE email=?";
		return jdbcTemplate.queryForInt(query,
				new Object[] {email}, new RowMapper<Integer>() {
					public Integer mapRow(ResultSet resultSet, int rowNum)
							throws SQLException {
						return new Integer(resultSet.getInt("userId"));
					}
				});
	}
	
	/**
	* Check for existing registered email
	* @param email - checked email
	* @return boolean exist or not
	* */
	public boolean checkExistedUserEmail (String email){
		String query = "SELECT userId FROM users WHERE email = ?";
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
	* Find user by its unique id
	* @param id - id of user you are looking for
	* @return User object
	* */
	public User findUserById(final int userId) {
		String query = "SELECT email, password, nickName FROM users WHERE userId=?";
		List<User> list = jdbcTemplate.query(query, new Object[]{userId}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(userId, resultSet.getString("email"), 
						resultSet.getString("password"), resultSet.getString("nickName"), 
						resultSet.getString("avatar"));
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	* Find user by its unique email and not unique password
	* @param email - user email
	* @param password - user password
	* @return User object
	* */
	@Deprecated
	public User findUserByEmailAndPassword(final String email, final String password){
		String query = "SELECT userId, nickName, avatar FROM users WHERE email=? AND password=?";
		List <User> list = jdbcTemplate.query(query, new Object[]{email, password}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getInt("userId"), email, 
						password, resultSet.getString("nickName"), resultSet.getString("avatar"));
			}
		});
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	/**
	* Find user by his/her unique email
	* @param email - email of user you are looking for
	* @return User object
	* */
	public User findUserByEmail(final String email) {
		String query = "SELECT userId, password, nickName, avatar FROM users WHERE email=?";
		List <User> list = jdbcTemplate.query(query, new Object[]{email}, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getInt("userId"), email, 
						resultSet.getString("password"), resultSet.getString("nickName"), 
						resultSet.getString("avatar"));
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
		String query = "UPDATE users SET email=?, password=?, WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] { user.getEmail(), user.getPassword(),
						user.getId() });
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
		String query = "UPDATE users SET avatar=? WHERE userId = ?";
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
		String query = "UPDATE users SET nickName=? WHERE userId = ?";
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
		String query = "UPDATE users SET email=?, password=?, nickName=?, avatar=?, WHERE userId = ?";
		int i = jdbcTemplate.update(query,
				new Object[] {user.getEmail(), user.getPassword(), user.getNickName(), user.getAvatar(), user.getId()});
		if (i==0) return false;
		else return true;
	}
	
	/**
	* Delete user
	* @param userId - id of user
	* */
	public boolean deleteUser(User user) {
		String query = "DELETE FROM users WHERE id = ?";
		int i = jdbcTemplate.update(query, new Object[] { user.getId() });
		if (i==0) return false;
		else return true;
	}
	
	/**
	* Delete user
	* @param userId - id of user
	* */
	public boolean deleteUser(int userId){
		String query = "DELETE FROM users WHERE id = ?";
		int i = jdbcTemplate.update(query, new Object[] { userId });
		if (i==0) return false;
		else return true;
	}

	/**
	* Fetch all users from database
	* @return List<User> - list of all users on database
	* */
	public List<User> findAllUsers() {
		String query = "SELECT userId,email,password, avatar FROM users";
		return jdbcTemplate.query(query, new RowMapper<User>() {
			public User mapRow(ResultSet resultSet, int rowNum)
					throws SQLException {
				return new User(resultSet.getInt("userId"), resultSet
						.getString("email"), resultSet.getString("password"), resultSet.getString("avatar"));
			}
		});
	}

}