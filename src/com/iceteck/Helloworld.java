package com.iceteck;

/**
 * 
 * @author Larry_Lite
 * Beans object. instantiated via xml configuration in the Beans.xml with a singleton scope
 */
		
public class Helloworld {

	private String message;

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
	   
	   public void init() {
		   System.out.println("HelloWorld Bean initialized");		
	   }
	   
	   private void destroy() {
		// TODO Auto-generated method stub
		   System.out.println("HelloWorld Bean  destroyed");
	   }
}
