package com.splashcode.aqs.data.provider.backend;

import com.splashcode.aqs.data.event.bus.EventBus;
import com.splashcode.aqs.data.event.userinfo.UserInfoAnswer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class UserInfoProviderBackEndData implements BackEndDataProvider {

    private final EventBus eventBus;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserInfoProviderBackEndData(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void run() {
        //TODO : execute backend process like database access or http requests...
        eventBus.post(new UserInfoAnswer());
    }

    @Override
    public void getData () {
        executorService.execute(this);
    }
}
