package jpm.codeforgood.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

	private int id;
	private String text;
	private long timestamp;

	public Message() {
		super();
		this.id = 0;
		this.text = "";
		this.timestamp = new DateTime().getMillis();
		;
	}

	public Message(int id, String text, DateTime dt) {
		super();
		this.id = id;
		this.text = text;
		this.timestamp = dt.getMillis();
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
