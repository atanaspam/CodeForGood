package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Beacon {

	private String id;
	private String name;

	public Beacon() {
		super();
	}

	public Beacon(String id) {
		super();
		this.id = id;
	}

	public Beacon(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
