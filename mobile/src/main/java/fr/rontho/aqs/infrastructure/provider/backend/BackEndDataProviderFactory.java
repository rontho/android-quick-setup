package fr.rontho.aqs.infrastructure.provider.backend;

import fr.rontho.aqs.infrastructure.com.bus.EventBusAdapter;
import fr.rontho.aqs.infrastructure.provider.backend.UserInfoProviderBackEndData;

/**
 * Created by troncaglia on 09/02/2015.
 */
public class BackEndDataProviderFactory {
    public BackEndDataProvider getUserInfoProviderBackEnd(EventBusAdapter eventBusAdapter) {
        return new UserInfoProviderBackEndData(eventBusAdapter);
    }
}
