package com.splashcode.aqs.data.eventbus;

import android.os.Handler;
import android.os.Looper;

import com.splashcode.aqs.domain.event.answer.Answer;
import com.splashcode.aqs.domain.event.bus.EventBusProducer;

/**
 * Guava implementation of the EventBus adapter
 */
public class GuavaEventBus implements EventBus, EventBusProducer {

    private final com.google.common.eventbus.EventBus eventBus = new com.google.common.eventbus.EventBus();
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void register(final EventBusListener listener) {
        eventBus.register(listener);
    }

    @Override
    public void post(final Answer answer) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            eventBus.post(answer);
        } else {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    eventBus.post(answer);
                }
            });
        }
    }


    @Override
    public void unregister(final EventBusListener listener) {
        eventBus.unregister(listener);
    }
}
