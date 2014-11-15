package jpm.codeforgood.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataAnswer extends Answer {
	private String data;

	public DataAnswer(String status, String message, String data) {
		super(status, message);
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
