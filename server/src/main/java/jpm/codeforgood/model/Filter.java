package jpm.codeforgood.model;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Filter {
	private long since;
	private int from;
	private int to;

	public Filter() {
		super();
		this.since = new DateTime().minusSeconds(60).getMillis();
	}

	public Filter(long since, int from, int to) {
		super();
		this.since = since;
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public long getSince() {
		return since;
	}

	public int getTo() {
		return to;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setSince(long since) {
		this.since = since;
	}

	public void setTo(int to) {
		this.to = to;
	}

}
