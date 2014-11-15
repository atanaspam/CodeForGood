package jpm.codeforgood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jpm.codeforgood.model.Beacon;
import jpm.codeforgood.model.ChatMessage;
import jpm.codeforgood.model.Message;
import jpm.codeforgood.model.User;

import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

public class ChatMessageRowMapper implements RowMapper<ChatMessage> {

	public ChatMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		Beacon beacon = new Beacon(rs.getString("beaconID"));

		Message msg = new Message(rs.getInt("msgID"), rs.getString("text"),
				new DateTime(rs.getDate("time")));

		User user = new User(rs.getString("deviceID"), rs.getString("name"),
				rs.getString("email"));

		return new ChatMessage(msg, user, beacon);
	}

}
