package com.iceteck.eventhandler;

import org.springframework.context.ApplicationListener;

/**
 * Class that responds to the custom event 
 * @author Larry_Lite
 *
 */
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

	@Override
	public void onApplicationEvent(CustomEvent cevent) {
		// TODO Auto-generated method stub
		System.out.println("Custom Event: "+cevent);
	}

}
