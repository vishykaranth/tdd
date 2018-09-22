package com.eventbus.service;

import com.eventbus.EventBusWrapper;
import com.eventbus.event.FirstEvent;
import com.eventbus.event.SecondEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstService {

	private final EventBusWrapper eventBus;

	@Autowired
	public FirstService(EventBusWrapper eventBus) {
		this.eventBus = eventBus;
	}

	public void postSecondEvent() {
		System.out.println("Posting Second Event");
		eventBus.post(new SecondEvent());
	}

	public void postFirstEvent() {
		System.out.println("Posting First Event");
		eventBus.post(new FirstEvent());
	}
}
