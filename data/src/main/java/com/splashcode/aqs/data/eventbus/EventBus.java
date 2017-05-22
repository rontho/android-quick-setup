package com.splashcode.aqs.data.eventbus;

import com.splashcode.aqs.domain.event.answer.Answer;

/**
 * Interface to communicated with an EventBus
 */
public interface EventBus {
    void register(final EventBusListener listener);
    void unregister(final EventBusListener listener);
}
