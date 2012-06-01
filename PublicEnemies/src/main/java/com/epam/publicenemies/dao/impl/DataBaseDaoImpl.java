package com.epam.publicenemies.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epam.publicenemies.dao.IDataBaseDao;

/**
 * 
 * @author Chetyrkin_Sviatoslav 29.05.2012
 *
 */
@Repository
public class DataBaseDaoImpl implements IDataBaseDao {

	private Logger log = Logger.getLogger(DataBaseDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Get names of all available tables in database 
	 * @return list of names
	 */
	@Override
	public List<String> getAllTables() {
		final String SELEC_SQL = "SHOW TABLES";
		List<String> list = jdbcTemplate.query(SELEC_SQL, new RowMapper<String> () {
			public String mapRow (ResultSet resultSet, int rowNum) 
							throws SQLException {
				return new String(resultSet.getString(1));
			}
		});
		log.info("DataBaseDaoImpl.getAllTables : "+list.size()+" tables were fetched");
		return list;
	}

	/**
	 * Get data base name
	 * @return name of data base
	 */
	@Override
	public String getDataBaseName() {
		final String SELECT_SQL = "SELECT DATABASE()";
		String dataBase = jdbcTemplate.queryForObject(SELECT_SQL, String.class);
		log.info("DataBaseDaoImpl.getDataBaseName : data base name("+dataBase+") were fetched");
		return dataBase;
	}

	/**
	 * Get name of user connected to data base
	 * @return name of user
	 */
	@Override
	public String getUserConnected() {
		final String SELECT_SQL = "SELECT USER()";
		String user = jdbcTemplate.queryForObject(SELECT_SQL, String.class);
		log.info("DataBaseDaoImpl.getUserConnected : user("+user+") were fetched");
		return user;
	}

	/**
	 * Get version of MySQL server
	 * @return version of MySQL server
	 */
	@Override
	public String getMySQLVersion() {
		final String SELECT_SQL = "SELECT VERSION()";
		String version = jdbcTemplate.queryForObject(SELECT_SQL, String.class);
		log.info("DataBaseDaoImpl.getMySQLVersion : MySQL version("+version+") were fetched");
		return version;
	}

}
