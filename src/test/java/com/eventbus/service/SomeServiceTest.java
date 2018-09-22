package com.eventbus.service;

import com.eventbus.EventBusWrapper;
import com.eventbus.event.FirstEvent;
import com.eventbus.event.SecondEvent;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class SomeServiceTest {

	private EventBusWrapper eventBus;

	@BeforeMethod
	public void createMocks() {
		eventBus = mock(EventBusWrapper.class);
	}

	@Test
	public void shouldPostFirstAndSecondEventJustOnce() {
		// given
		FirstService service = new FirstService(eventBus);

		// when
		service.postFirstEvent();
		service.postSecondEvent();

		// then
		verify(eventBus).post(isA(SecondEvent.class));
		verify(eventBus).post(isA(FirstEvent.class));
		verifyNoMoreInteractions(eventBus);
	}

    @Test
    public void shouldPostFirstAndSecondEventJustTwice() {
        // given
        FirstService service = new FirstService(eventBus);

        // when
        service.postFirstEvent();
        service.postSecondEvent();
//        service.postFirstEvent();
//        service.postSecondEvent();

        // then
        verify(eventBus).post(isA(SecondEvent.class));
        verify(eventBus).post(isA(FirstEvent.class));
        verifyNoMoreInteractions(eventBus);

    }

	@Test
	public void shouldSendDoneThatEvent() {
		// given
		FirstService service = new FirstService(eventBus);

		// when
		service.postFirstEvent();

		// then
		verify(eventBus).post(isA(FirstEvent.class));
		verifyNoMoreInteractions(eventBus);
	}
}
