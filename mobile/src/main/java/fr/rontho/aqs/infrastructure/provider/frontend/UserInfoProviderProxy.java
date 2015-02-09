package fr.rontho.aqs.infrastructure.provider.frontend;

import fr.rontho.aqs.infrastructure.com.bus.EventBusAdapter;
import fr.rontho.aqs.infrastructure.com.bus.EventBusListener;
import fr.rontho.aqs.infrastructure.provider.backend.BackEndDataProviderFactory;
import fr.rontho.aqs.infrastructure.provider.backend.BackEndDataProvider;

/**
 * Created by troncaglia on 15/12/2014.
 */
public class UserInfoProviderProxy implements UserInfoProxy {

    private final EventBusAdapter eventBusAdapter;
    private final BackEndDataProviderFactory backEndDataProviderFactory;

    public UserInfoProviderProxy(final EventBusAdapter eventBusAdapter, final BackEndDataProviderFactory backEndDataProviderFactory) {
        this.eventBusAdapter = eventBusAdapter;
        this.backEndDataProviderFactory = backEndDataProviderFactory;
    }

    @Override
    public void register(final EventBusListener listener) {
        eventBusAdapter.register(listener);
    }

    @Override
    public void unregister(EventBusListener listener) {
        eventBusAdapter.unregister(listener);
    }

    @Override
    public void getUserInfo() {
        final BackEndDataProvider backEndDataProvider = backEndDataProviderFactory.getUserInfoProviderBackEnd(eventBusAdapter);
        backEndDataProvider.getData();
    }

    public int fakeMethodOnlyForTest(final int value){
        return value + 1;
    }
}
