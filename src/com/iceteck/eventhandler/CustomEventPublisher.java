package com.iceteck.eventhandler;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/*
 * Used to publish events
 */
public class CustomEventPublisher implements ApplicationEventPublisherAware{

	ApplicationEventPublisher apublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.apublisher = publisher;
	}
	
	public void publish(){
		CustomEvent ce = new CustomEvent(this);
		apublisher.publishEvent(ce);
	}

}
