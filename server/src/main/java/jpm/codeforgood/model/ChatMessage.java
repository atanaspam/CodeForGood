package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatMessage {
	private Message message;
	private User user;
	private Beacon beacon;

	public ChatMessage() {
		super();
		this.message = new Message();
		this.user = new User();
		this.beacon = new Beacon();
	}

	public ChatMessage(Message msg, User user, Beacon beacon) {
		super();
		this.message = msg;
		this.user = user;
		this.beacon = beacon;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public Message getMessage() {
		return message;
	}

	public User getUser() {
		return user;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public void setMessage(Message msg) {
		this.message = msg;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
