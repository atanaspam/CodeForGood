package jpm.codeforgood.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jpm.codeforgood.model.Answer;
import jpm.codeforgood.model.Beacon;
import jpm.codeforgood.model.ChatMessage;
import jpm.codeforgood.model.Connect;
import jpm.codeforgood.model.Messages;
import jpm.codeforgood.model.Names;
import jpm.codeforgood.rowmapper.ChatMessageRowMapper;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = { "/api", "/" })
// legacy support
public class ApiController {
	final static Logger logger = LoggerFactory.getLogger(ApiController.class);

	private static final String ADD_USER_MSG = "INSERT INTO UserMessages (deviceID, name, msgID)"
			+ "VALUES (?, ?, ?)";
	private static final String ADD_BEACON_MSG = "INSERT INTO BeaconMessages (msgID, beaconid)"
			+ "VALUES (?, ?)";
	private static final String INSERT_MSG = "INSERT INTO Message (text) VALUES (?)";
	private static final String GET_BEACON_NAME = "SELECT name "
			+ "FROM Beacon " + "WHERE lower(id) = lower(?)";
	private static final String GET_MESSAGES = "SELECT u.deviceID, u.name, email, um.msgid, text, time, beaconID "
			+ "FROM User u, Message m, UserMessages um, Beacon b, BeaconMessages bm "
			+ "WHERE u.deviceID = um.deviceID "
			+ "AND u.name = um.name "
			+ "AND b.id = bm.beaconid "
			+ "AND m.id = um.msgid "
			+ "AND m.id = bm.msgid "
			+ "AND time > ? "
			+ "AND beaconid = ? "
			+ "ORDER BY m.id ASC";
	private static final String GET_NEW_MESSAGES = "SELECT u.deviceID, u.name, email, um.msgid, text, time, beaconID "
			+ "FROM User u, Message m, UserMessages um, Beacon b, BeaconMessages bm "
			+ "WHERE u.deviceID = um.deviceID "
			+ "AND u.name = um.name "
			+ "AND b.id = bm.beaconid "
			+ "AND m.id = um.msgid "
			+ "AND m.id = bm.msgid "
			+ "AND m.id	> ? "
			+ "AND beaconid = ? "
			+ "ORDER BY m.id ASC";
	private static final String ADD_USER = "INSERT INTO User (deviceID, name, email)"
			+ "VALUES (?, ?, ?)";;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional
	@RequestMapping(value = "/names", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Beacon> checkBeacons(@RequestBody Names names) {
		List<Beacon> beacons = names.getBeacons();
		Map<String, Beacon> result = new HashMap<String, Beacon>();
		for (Beacon beacon : beacons) {
			String id = beacon.getId();
			String name;
			try {
				name = jdbcTemplate.queryForObject(GET_BEACON_NAME,
						new Object[] { id }, String.class);
				beacon.setName(name);
				result.put(id, beacon);
			} catch (IncorrectResultSizeDataAccessException e) {
				// oh well
			}
		}
		return result;
	}

	@Transactional
	@RequestMapping(value = "/connect", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<ChatMessage>> connect(@RequestBody Connect connect,
			HttpServletResponse response) {
		try {
			jdbcTemplate
					.update(ADD_USER, new Object[] {
							connect.getUser().getDeviceID(),
							connect.getUser().getName(),
							connect.getUser().getEmail() });
		} catch (DataAccessException e) {
			// ignore
		}
		List<ChatMessage> list = jdbcTemplate.query(
				GET_MESSAGES,
				new Object[] {
						DateTimeFormat.forPattern("YYYY-MM-dd HH:mm:ss").print(
								new DateTime().minusMinutes(1)),
						connect.getBeacon().getId() },
				new ChatMessageRowMapper());
		HashMap<String, List<ChatMessage>> result = new HashMap<String, List<ChatMessage>>();
		result.put("messages", list);
		return result;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public Answer error(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return new Answer("error", "woops, something went wrong");
	}

	@Transactional
	@RequestMapping(value = "/messages", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, List<ChatMessage>> messages(
			@RequestBody Messages messages, HttpServletResponse response) {

		if (messages.getFilter().getFrom() == 0) {
			return connect(
					new Connect(messages.getBeacon(), messages.getUser()),
					response);
		}

		List<ChatMessage> list = jdbcTemplate.query(GET_NEW_MESSAGES,
				new Object[] { messages.getFilter().getFrom(),
						messages.getBeacon().getId() },
				new ChatMessageRowMapper());
		Map<String, List<ChatMessage>> result = new HashMap<String, List<ChatMessage>>();
		result.put("messages", list);
		return result;

	}

	@Transactional
	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Answer sendMessage(@RequestBody final ChatMessage msg,
			HttpServletResponse response) {
		Answer answer = null;
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(
							INSERT_MSG, new String[] { "id" });
					ps.setString(1, msg.getMessage().getText());
					return ps;
				}
			}, keyHolder);
			int id = keyHolder.getKey().intValue();
			jdbcTemplate.update(ADD_USER_MSG, new Object[] {
					msg.getUser().getDeviceID(), msg.getUser().getName(), id });
			jdbcTemplate.update(ADD_BEACON_MSG, new Object[] { id,
					msg.getBeacon().getId() });
			answer = new Answer();
		} catch (DataAccessException e) {
			answer = new Answer(e.getMessage());
		}
		return answer;

	}

}
