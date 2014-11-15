package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String deviceID;
	private String name;
	private String email;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.deviceID = "";
		this.name = name;
		this.email = "";
	}

	public User(String name, String email) {
		super();
		this.deviceID = "";
		this.name = name;
		this.email = email;
	}

	public User(String deviceID, String name, String email) {
		super();
		this.deviceID = deviceID;
		this.name = name;
		this.email = email;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

}
