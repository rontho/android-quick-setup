package fr.rontho.aqs.infrastructure.provider.backend;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.rontho.aqs.infrastructure.com.bus.EventBusAdapter;
import fr.rontho.aqs.infrastructure.com.userinfo.UserInfoAnswer;
import fr.rontho.aqs.infrastructure.com.userinfo.UserInfoQuestion;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class UserInfoProviderBackEndData implements BackEndDataProvider {

    private final EventBusAdapter eventBusAdapter;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public UserInfoProviderBackEndData(final EventBusAdapter eventBusAdapter) {
        this.eventBusAdapter = eventBusAdapter;
    }

    @Override
    public void run() {
        //TODO : execute backend process like database access or http requests...
        eventBusAdapter.respond(new UserInfoAnswer());
    }

    @Override
    public void getData () {
        executorService.execute(this);
    }
}
