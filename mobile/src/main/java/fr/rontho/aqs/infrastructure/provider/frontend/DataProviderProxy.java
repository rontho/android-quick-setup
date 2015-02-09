package fr.rontho.aqs.infrastructure.provider.frontend;

import fr.rontho.aqs.infrastructure.com.bus.EventBusListener;

/**
 * Created by troncaglia on 09/02/2015.
 */
public interface DataProviderProxy {
    public void register(final EventBusListener listener);
    public void unregister(final EventBusListener listener);
}
