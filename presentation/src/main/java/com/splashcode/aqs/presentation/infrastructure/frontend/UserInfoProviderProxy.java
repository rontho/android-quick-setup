package com.splashcode.aqs.presentation.infrastructure.frontend;

import com.splashcode.aqs.data.event.bus.EventBusListener;
import com.splashcode.aqs.data.event.bus.MyEventBus;
import com.splashcode.aqs.data.provider.backend.BackEndDataProviderFactory;
import com.splashcode.aqs.data.provider.backend.BackEndDataProvider;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class UserInfoProviderProxy implements UserInfoProxy {

    private final MyEventBus myEventBus;
    private final BackEndDataProviderFactory backEndDataProviderFactory;

    public UserInfoProviderProxy(final MyEventBus myEventBus, final BackEndDataProviderFactory backEndDataProviderFactory) {
        this.myEventBus = myEventBus;
        this.backEndDataProviderFactory = backEndDataProviderFactory;
    }

    @Override
    public void register(final EventBusListener listener) {
        myEventBus.register(listener);
    }

    @Override
    public void unregister(EventBusListener listener) {
        myEventBus.unregister(listener);
    }

    @Override
    public void getUserInfo() {
        final BackEndDataProvider backEndDataProvider = backEndDataProviderFactory.getUserInfoProviderBackEnd(myEventBus);
        backEndDataProvider.getData();
    }

    public int fakeMethodOnlyForTest(final int value){
        return value + 1;
    }
}
