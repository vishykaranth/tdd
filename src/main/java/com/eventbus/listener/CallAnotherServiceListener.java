package com.eventbus.listener;

import com.eventbus.service.SecondService;
import com.google.common.eventbus.Subscribe;
import com.eventbus.Event;

public class CallAnotherServiceListener {

    private final SecondService secondService;

    public CallAnotherServiceListener(SecondService secondService) {
        this.secondService = secondService;
    }

    @Subscribe
    public void allEvents(Event event) {
        secondService.doSomething();
    }
}
