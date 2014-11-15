package jpm.codeforgood.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jpm.codeforgood.model.Beacon;

import org.springframework.jdbc.core.RowMapper;

public class BeaconRowMapper implements RowMapper<Beacon> {
	public Beacon mapRow(ResultSet rs, int rowNum) throws SQLException {
		Beacon beacon = new Beacon(rs.getString("id"), rs.getString("name"));
		return beacon;
	}

}
