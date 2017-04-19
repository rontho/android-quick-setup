package com.splashcode.aqs.presentation.infrastructure.frontend;

/**
 * Created by troncaglia on 09/02/2015.
 */
public interface DataProviderProxy {
    void register(final EventBusListener listener);
    void unregister(final EventBusListener listener);
}
