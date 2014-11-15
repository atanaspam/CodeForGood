package uk.ac.glasgow.jpmcfg2014.server.data.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import uk.ac.glasgow.jpmcfg2014.server.domain.User;

public class UserRowMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		return user;
	}
}
