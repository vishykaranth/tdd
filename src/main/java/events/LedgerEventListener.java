package events;

import org.springframework.context.ApplicationListener;

// This listener will listen LedgerEvent type application event.
public class LedgerEventListener implements ApplicationListener<LedgerEvent> {

	@Override
	public void onApplicationEvent(LedgerEvent event) {
		System.out.println("Received Ledger Event :: " + event);
	}

}
