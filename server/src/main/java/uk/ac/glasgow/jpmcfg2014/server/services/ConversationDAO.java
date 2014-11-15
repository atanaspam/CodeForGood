package uk.ac.glasgow.jpmcfg2014.server.services;

import javax.sql.DataSource;

import uk.ac.glasgow.jpmcfg2014.server.domain.Conversation;
import uk.ac.glasgow.jpmcfg2014.server.domain.UserConversation;

public interface ConversationDAO {

	public void setDataSource(DataSource ds);

	public Conversation create(UserConversation userConv);

	public Conversation get(Integer id);

	public void delete(Integer id);

	
}
