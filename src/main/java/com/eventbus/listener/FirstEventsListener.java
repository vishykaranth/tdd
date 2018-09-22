package com.eventbus.listener;

import com.eventbus.event.SecondEvent;
import com.google.common.eventbus.Subscribe;

public class FirstEventsListener {

    @Subscribe
    public void doneThisEvent(SecondEvent event) {
        System.out.println("done this: " + event);
    }
}
