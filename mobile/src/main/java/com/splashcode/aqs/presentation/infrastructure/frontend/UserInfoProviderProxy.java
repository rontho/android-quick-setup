package com.splashcode.aqs.presentation.infrastructure.frontend;

import com.splashcode.aqs.data.provider.backend.BackEndDataProviderFactory;
import com.splashcode.aqs.data.event.bus.EventBus;
import com.splashcode.aqs.data.provider.backend.BackEndDataProvider;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class UserInfoProviderProxy implements UserInfoProxy {

    private final EventBus eventBus;
    private final BackEndDataProviderFactory backEndDataProviderFactory;

    public UserInfoProviderProxy(final EventBus eventBus, final BackEndDataProviderFactory backEndDataProviderFactory) {
        this.eventBus = eventBus;
        this.backEndDataProviderFactory = backEndDataProviderFactory;
    }

    @Override
    public void register(final EventBusListener listener) {
        eventBus.register(listener);
    }

    @Override
    public void unregister(EventBusListener listener) {
        eventBus.unregister(listener);
    }

    @Override
    public void getUserInfo() {
        final BackEndDataProvider backEndDataProvider = backEndDataProviderFactory.getUserInfoProviderBackEnd(eventBus);
        backEndDataProvider.getData();
    }

    public int fakeMethodOnlyForTest(final int value){
        return value + 1;
    }
}
