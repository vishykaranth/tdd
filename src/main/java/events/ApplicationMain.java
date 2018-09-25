package events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
	   	// Initiate Spring application context.
		ApplicationContext springAppCtx = new ClassPathXmlApplicationContext("ledgerevents.xml");

		// Get deposit event publisher bean to publish event.
		LedgerEventPublisher ledgerEventPublisher = (LedgerEventPublisher)springAppCtx.getBean("ledgerEventPublisher");
		ledgerEventPublisher.publishLedgerEvent();
	}

}
