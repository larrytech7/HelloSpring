package com.iceteck.util;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iceteck.Student;
import com.iceteck.interfaces.StudentDAO;

public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	   
	@Override
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	//create a new student record
	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		 try {
	         String SQL1 = "insert into Student (name, age) values (?, ?)";
	         jdbcTemplateObject.update( SQL1, name, age);

	         // Get the latest student id to be used in Marks table
	         String SQL2 = "select max(id) from Student";
	        // int sid = jdbcTemplateObject.queryForInt( SQL2 );
	         Integer sid = jdbcTemplateObject.queryForObject(SQL2, Integer.class);

	         String SQL3 = "insert into Marks(sid, marks, year) " + 
	                       "values (?, ?, ?)";
	         jdbcTemplateObject.update( SQL3, sid, marks, year);

	         System.out.println("Created Name = " + name + ", Age = " + age);
	         // to simulate the exception.
	       //  throw new RuntimeException("simulate Error condition") ;
	      } catch (DataAccessException e) {
	         System.out.println("Error in creating record, rolling back");
	         throw e;
	      }
	}

	//get a given student record
	@Override
	public Student getStudent(Integer id) {
		String SQL = "select * from student where id = ?";
	      Student student = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{id}, new StudentMapper());
	      return student;
	}

	//get records for all students
	@Override
	public List<Student> listStudents() {
		String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL, 
	                                new StudentMapper());
	      return students;
	}
	
	//delete a particular student record
	@Override
	public void delete(Integer id) {
		String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	}

	//Update a particular student record
	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, age, id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	}

}