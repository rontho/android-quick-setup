package com.splashcode.aqs.data.provider.backend;

import com.splashcode.aqs.data.event.bus.EventBus;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class BackEndDataProviderFactory {
    public BackEndDataProvider getUserInfoProviderBackEnd(EventBus eventBus) {
        return new UserInfoProviderBackEndData(eventBus);
    }
}
