package uk.ac.glasgow.jpmcfg2014.server.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import uk.ac.glasgow.jpmcfg2014.server.data.rowmapper.UserRowMapper;
import uk.ac.glasgow.jpmcfg2014.server.domain.User;

public class UserService implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private JdbcTemplate jdbcTemplateObject;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public User create(String name) {
		final String name_final = name;
		logger.info("Created Record Name = " + name);

		User user = new User();
		user.setName(name);

		final String query = "insert into User (name) values (?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, new String[] { "name" });
				ps.setString(1, name_final);
				return ps;
			}
		}, keyHolder);
		
		user.setId(keyHolder.getKey().intValue());
		return user;
	}

	public User get(Integer id) {
		String query = "select * from User where id = ?";
		User user = jdbcTemplateObject.queryForObject(query,
				new Object[] { id }, new UserRowMapper());
		return user;
	}

	public List<User> listUsers() {
		String query = "select * from User";
		List<User> users = jdbcTemplateObject.query(query, new UserRowMapper());
		return users;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	public void update(Integer id, String name) {
		// TODO Auto-generated method stub
	}
}
