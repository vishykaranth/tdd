package com.eventbus;

import com.eventbus.service.SecondService;
import com.eventbus.event.SecondEvent;
import org.kubek2k.springockito.annotations.ReplaceWithMock;
import org.kubek2k.springockito.annotations.SpringockitoContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;

@ContextConfiguration(
        loader = SpringockitoContextLoader.class,
        locations = {"classpath:events.xml"})
public class CallSecondServiceItTest extends AbstractTestNGSpringContextTests {

    @ReplaceWithMock
    @Autowired
    private SecondService secondService;

	@Autowired
	EventBusWrapper eventBus;

	@Test
	public void shouldCallAnotherService() {
		// given
		// when
        eventBus.post(new SecondEvent());

		// then
        verify(secondService).doSomething();
	}
}
