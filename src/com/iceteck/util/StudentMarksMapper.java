package com.iceteck.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iceteck.StudentMarks;

public class StudentMarksMapper implements RowMapper<StudentMarks> {

	@Override
	public StudentMarks mapRow(ResultSet rs, int arg1) throws SQLException {
		StudentMarks studentMarks = new StudentMarks();

	      studentMarks.setId(rs.getInt("id"));
	      studentMarks.setName(rs.getString("name"));
	      studentMarks.setAge(rs.getInt("age"));
	      studentMarks.setSid(rs.getInt("sid"));
	      studentMarks.setMarks(rs.getInt("marks"));
	      studentMarks.setYear(rs.getInt("year"));

	      return studentMarks;
	}

}
