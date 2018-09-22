package com.eventbus.listener;


import com.eventbus.event.FirstEvent;
import org.testng.annotations.Test;

@Test
public class DoneThatEventListenerTest {

    public void testListener() {
        //given
        SecondEventListener listener = new SecondEventListener();

        // when
        listener.doneThatEvent(new FirstEvent());

        // then
        // do some testing here of whatever SecondEventListener should do
    }
}
