package com.iceteck.util;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.iceteck.Mart;
import com.iceteck.interfaces.MartDAO;

public class MartJDBCTemplate implements MartDAO{

	private DataSource mDataSource;
	private JdbcTemplate mJdbcTemplate;
	
	@Override
	public void setmDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.mDataSource = ds;
		this.mJdbcTemplate = new JdbcTemplate(mDataSource);
	}

	@Override
	public void create(String name, String date) {
		// TODO Auto-generated method stub
		String SQL = "INSERT INTO category(cat_name, cat_date_added) VALUES (?, ?)";
		mJdbcTemplate.update(SQL, name, date);
		System.out.println("Created record with Name = "+name+" AND Date = "+date);
		return;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "DELETE FROM category WHERE id = ?";
		mJdbcTemplate.update(SQL, id);
		System.out.println("deleted record with id = "+id);
		
	}

	@Override
	public List<Mart> getMarts() {
		String sql = "SELECT * from category";
		List<Mart> martlist = mJdbcTemplate.query(sql, new MartMapper());
		return martlist;
	}

	@Override
	public Mart getMart(Integer id) {
		String sql = "SELECT FROM category WHERE id = ?";
		return mJdbcTemplate.queryForObject(sql, new Object[]{id}, Mart.class);
	}

	@Override
	public void update(String name, Integer id) {
		// TODO Auto-generated method stub
		String SQL = "UPDATE category SET name = ? WHERE id = ?";
		mJdbcTemplate.update(SQL, name, id);
		System.out.println("updated record with id = "+id);
	}

}
