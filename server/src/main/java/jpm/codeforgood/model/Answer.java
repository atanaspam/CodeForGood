package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Answer {
	private String status;
	private String message;

	public Answer() {
		super();
		this.status = "ok";
		this.message = "sucessful";
	}

	public Answer(String message) {
		super();
		this.status = "error";
		this.message = message;
	}

	public Answer(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public String getStatus() {
		return status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
