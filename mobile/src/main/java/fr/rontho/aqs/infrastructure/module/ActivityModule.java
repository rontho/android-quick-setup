package fr.rontho.aqs.infrastructure.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import fr.rontho.aqs.BuildConfig;
import fr.rontho.aqs.infrastructure.com.bus.EventBusAdapter;
import fr.rontho.aqs.infrastructure.com.bus.otto.OttoEventBusAdapter;
import fr.rontho.aqs.infrastructure.log.Logger;
import fr.rontho.aqs.infrastructure.log.LoggerDebug;
import fr.rontho.aqs.infrastructure.log.LoggerRelease;
import fr.rontho.aqs.infrastructure.provider.backend.BackEndDataProviderFactory;
import fr.rontho.aqs.infrastructure.provider.frontend.DataProviderProxy;
import fr.rontho.aqs.infrastructure.provider.frontend.UserInfoProviderProxy;
import fr.rontho.aqs.infrastructure.provider.frontend.UserInfoProxy;
import fr.rontho.aqs.ui.main.MainActivity;

/**
 * Created by troncaglia on 15/12/2014.
 */
@Module (library = true,
         injects = MainActivity.class,
         complete = false)
public class ActivityModule {

    @Provides @Named("UserInfo")
    public UserInfoProxy provideUserInfoProviderProxy(final EventBusAdapter eventBusAdapter, final BackEndDataProviderFactory eventBusResponseProviderFactory){
        return new UserInfoProviderProxy(eventBusAdapter, eventBusResponseProviderFactory);
    }

    @Provides
    public EventBusAdapter provideEventBusAdapter(){
        return new OttoEventBusAdapter();
    }

    @Provides BackEndDataProviderFactory provideBackEndDataProviderFactory(){
        return new BackEndDataProviderFactory();
    }

    @Provides
    public Logger provideLogger(){
        if(BuildConfig.DEBUG)  {
            return new LoggerDebug();
        } else {
            return new LoggerRelease();
        }
    }
}
