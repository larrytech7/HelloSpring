package com.iceteck.interfaces;

import java.util.List;

import javax.sql.DataSource;

import com.iceteck.Mart;

public interface MartDAO {
		
	public void setmDataSource(DataSource ds);
	
	public void create(String name, String date);
	
	public void delete(Integer id);
	
	public List<Mart> getMarts();
	
	public Mart getMart(Integer id);
	
	public void update(String name, Integer id);

}
