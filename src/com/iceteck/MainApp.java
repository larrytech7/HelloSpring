package com.iceteck;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iceteck.eventhandler.CustomEventPublisher;
import com.iceteck.interfaces.StudentDAO;
import com.iceteck.util.MartJDBCTemplate;
import com.iceteck.util.StudentJDBCTemplate;

public class MainApp {

	public static void main(String[] args) {
	      AbstractApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
	      context.start();
	      
	      StudentDAO studentJDBCTemplate = 
	    	      (StudentDAO)context.getBean("studentJDBCTemplate");
	      MartJDBCTemplate lJdbcTemplate = (MartJDBCTemplate) context.getBean("martJDBCTemplate");
	      lJdbcTemplate.create("Mouton", SimpleDateFormat.getDateInstance().format(new Date()));
	      lJdbcTemplate.create("Routon", SimpleDateFormat.getDateInstance().format(new Date()));
	      lJdbcTemplate.create("Fouton", SimpleDateFormat.getDateInstance().format(new Date()));
	      
	    	      System.out.println("------Records Creation--------" );
	    	      studentJDBCTemplate.create("Zara", 11, 99, 2002);
	    	      studentJDBCTemplate.create("Nuha", 2, 98, 2004);
	    	      studentJDBCTemplate.create("Ayan", 15, 90, 2005);

	    	      System.out.println("------Listing Multiple Records--------" );
	    	      List<Student> students = studentJDBCTemplate.listStudents();
	    	      for (Student record : students) {
	    	         System.out.print("ID : " + record.getId() );
	    	         System.out.print(", Name : " + record.getName() );
	    	         System.out.println(", Age : " + record.getAge());
	    	      }

	    	      System.out.println("----Listing Record with ID = 2 -----" );
	    	      Student student = studentJDBCTemplate.getStudent(2);
	    	      System.out.print("ID : " + student.getId());
	    	      System.out.print(", Name : " + student.getName() );
	    	      System.out.println(", Age : " + student.getAge());
	    	      
	     /* Student student = (Student) context.getBean("student");

	      student.getName();
	      student.getAge();*/
	      
	      student.printThrowException();
	      //CustomEventPublisher cep = (CustomEventPublisher) context.getBean("customEventPublisher");
	     // cep.publish();
	     /* Helloworld obj = (Helloworld) context.getBean("helloWorld");
	      obj.setMessage("I am root");
	      obj.getMessage();*/
	      
	      context.stop();
	    //  HelloWorldInit initobj = (HelloWorldInit) context.getBean("initbean");
	    //  initobj.getCurrency();
	      
	   //   context.registerShutdownHook();
	      context.close();
	   }
}
