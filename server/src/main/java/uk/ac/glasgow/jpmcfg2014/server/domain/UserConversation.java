package uk.ac.glasgow.jpmcfg2014.server.domain;

public class UserConversation {
	
	private int conversationId;
	private int user1Id;
	private int user2Id;
	
	public UserConversation(int conversationId, int user1Id, int user2Id) {
		super();
		this.conversationId = conversationId;
		this.user1Id = user1Id;
		this.user2Id = user2Id;
	}
	
	public UserConversation() {
		this(0, 0, 0);
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

	public int getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(int user1Id) {
		this.user1Id = user1Id;
	}

	public int getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(int user2Id) {
		this.user2Id = user2Id;
	}
	
	

}
