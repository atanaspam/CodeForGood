package uk.ac.glasgow.jpmcfg2014.server.domain;

import org.joda.time.DateTime;

public class Message {
	
	private int id;
	private String text;
	private DateTime timestamp;
	private int authorId;
	private int conversationId;

	public Message() {
		this(0, "", DateTime.now());
	}

	public Message(int id, String text, DateTime timestamp) {
		super();
		this.id = id;
		this.text = text;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(DateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getConversationId() {
		return conversationId;
	}

	public void setConversationId(int conversationId) {
		this.conversationId = conversationId;
	}

}
