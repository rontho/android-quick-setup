package com.splashcode.aqs.data.event.bus;

/**
 * Interface to communicated with an EventBus
 */
public interface EventBus {
    void register(final EventBusListener listener);
    void post(final Answer answer);
    void unregister(final EventBusListener listener);
}
