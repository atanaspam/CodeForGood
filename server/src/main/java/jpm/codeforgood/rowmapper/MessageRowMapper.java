package jpm.codeforgood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jpm.codeforgood.model.Message;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

public class MessageRowMapper implements RowMapper<Message> {
	public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
		Message msg = new Message(rs.getInt("id"), rs.getString("text"),
				new DateTime(rs.getDate("time")));
		return msg;
	}
}