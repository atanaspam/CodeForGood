package jpm.codeforgood.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Names {
	private List<Beacon> beacons;

	public Names() {
		super();
		this.beacons = new ArrayList<Beacon>();
	}

	public Names(List<Beacon> beacons) {
		super();
		this.beacons = beacons;
	}

	public List<Beacon> getBeacons() {
		return beacons;
	}

	public void setBeacons(List<Beacon> beacons) {
		this.beacons = beacons;
	}

}
