package com.eventbus.listener;

import com.eventbus.event.FirstEvent;
import com.google.common.eventbus.Subscribe;

public class SecondEventListener {

    @Subscribe
    public void doneThatEvent(FirstEvent event) {
        System.out.println("done that: " + event);
    }
}
