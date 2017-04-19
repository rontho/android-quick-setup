package com.splashcode.aqs.data.provider;

import com.splashcode.aqs.data.event.bus.MyEventBus;
import com.splashcode.aqs.data.event.userinfo.UserInfoAnswer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class UserInfoProviderBackEndData implements BackEndDataProvider {

    private final MyEventBus myEventBus;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserInfoProviderBackEndData(final MyEventBus myEventBus) {
        this.myEventBus = myEventBus;
    }

    @Override
    public void run() {
        //TODO : execute backend process like database access or http requests...
        myEventBus.post(new UserInfoAnswer());
    }

    @Override
    public void getData () {
        executorService.execute(this);
    }
}
