package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Messages {

	private User user;
	private Beacon beacon;
	private Filter filter;

	public Messages() {
		super();
		this.user = new User();
		this.beacon = new Beacon();
		this.filter = new Filter();
	}

	public Messages(User user, Beacon beacon, Filter filter) {
		super();
		this.user = user;
		this.beacon = beacon;
		this.filter = filter;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public Filter getFilter() {
		return filter;
	}

	public User getUser() {
		return user;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
