package uk.ac.glasgow.jpmcfg2014.server.domain;

public class Conversation {
	
	private int id;
	
	public Conversation() {
		this(0);
	}

	public Conversation(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
