package com.eventbus;

import com.eventbus.service.FirstService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		FirstService service = context.getBean(FirstService.class);
		service.postSecondEvent();
		service.postFirstEvent();
		service.postSecondEvent();
	}
}
