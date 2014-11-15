package uk.ac.glasgow.jpmcfg2014.server.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import uk.ac.glasgow.jpmcfg2014.server.domain.Conversation;
import uk.ac.glasgow.jpmcfg2014.server.domain.User;
import uk.ac.glasgow.jpmcfg2014.server.domain.UserConversation;

public class ConversationService implements ConversationDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private JdbcTemplate jdbcTemplateObject;
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Conversation get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
	}

	public Conversation conversationWithUsers(User user1, User user2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Conversation create(UserConversation userConv) {
		Conversation conv = new Conversation();

		// insert into Conversation table
		final String query = "insert into Conversation () values ()";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyHolder);
		
		conv.setId(keyHolder.getKey().intValue());
		
		
		// Make relationship
		final String queryForRelationship = "insert into UserConversation (incoversationid, user1Id, user2Id) values (?, ?, ?)";
		keyHolder = new GeneratedKeyHolder();

		final int convid = conv.getId();
		final int usr1id = userConv.getUser1Id();
		final int usr2id = userConv.getUser2Id();
		logger.debug("about to create (incoversationid, user1Id, user2Id)", convid, usr1id, usr2id);
		
		jdbcTemplateObject.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(queryForRelationship, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, convid);
				ps.setInt(2, usr1id);
				ps.setInt(3, usr2id);
				return ps;
			}
		}, keyHolder);
		
		return conv;
	}

}
