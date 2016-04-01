package com.iceteck;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iceteck.eventhandler.CustomEventPublisher;

public class MainApp {

	public static void main(String[] args) {
	      AbstractApplicationContext context = 
	             new ClassPathXmlApplicationContext("Beans.xml");
	      context.start();
	      
	      Student student = (Student) context.getBean("student");

	      student.getName();
	      student.getAge();
	      
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
