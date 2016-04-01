package com.iceteck.eventhandler;

import org.springframework.context.ApplicationEvent;

/**
 * Custom event to be implemented by a bean
 * @author Larry_Lite
 *
 */
public class CustomEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;

	public CustomEvent(Object source) {
		super(source);
	}
	
	public String toString(){
		return "my Custom Event";
	}
}
