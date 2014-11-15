package jpm.codeforgood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jpm.codeforgood.model.User;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(rs.getString("deviceID"), rs.getString("name"),
				rs.getString("email"));
		return user;
	}

}
