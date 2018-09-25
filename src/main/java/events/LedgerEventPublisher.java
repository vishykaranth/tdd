package events;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import java.math.BigDecimal;

public class LedgerEventPublisher implements ApplicationEventPublisherAware {
	private ApplicationEventPublisher eventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.eventPublisher = applicationEventPublisher;
	}
	
	public void publishLedgerEvent()
	{
		LedgerEvent ledgerEvent = new LedgerEvent(this, "A123", BigDecimal.valueOf(100), "VODAFONE",
				"ACCOUNT_ASSET", "PURCHASE_OF_SECURITY", BigDecimal.valueOf(100));
		System.out.println("Publishing Ledger Event : " + ledgerEvent);
		this.eventPublisher.publishEvent(ledgerEvent);
	}
}
