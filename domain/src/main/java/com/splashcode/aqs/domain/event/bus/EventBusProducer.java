package com.splashcode.aqs.domain.event.bus;

import com.splashcode.aqs.domain.event.answer.Answer;

/**
 * Produce events that can be sent into the eventBus.
 */
public interface EventBusProducer {
    void post(final Answer answer);
}
