package com.iceteck.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iceteck.Mart;

public class MartMapper implements RowMapper<Mart> {

	@Override
	public Mart mapRow(ResultSet rs, int rowNum) throws SQLException {
		// initialize object with necessary data
		Mart mart = new Mart();
		mart.setId(rs.getInt("cat_id"));
		mart.setName(rs.getString("cat_name"));
		mart.setDateadded(rs.getString("cat_date_added"));
		return mart;
	}

}
