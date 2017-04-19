package com.splashcode.aqs.presentation.infrastructure.di;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.google.common.eventbus.EventBus;
import com.splashcode.aqs.data.event.bus.GuavaMyEventBus;
import com.splashcode.aqs.data.event.bus.MyEventBus;
import com.splashcode.aqs.presentation.infrastructure.annotation.ForApplication;
import com.splashcode.aqs.presentation.AndroidQuickSetupApplication;

import static android.content.Context.LOCATION_SERVICE;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class ApplicationModule {
    private final AndroidQuickSetupApplication application;

    public ApplicationModule(AndroidQuickSetupApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    MyEventBus provideEventBus() {
        return new GuavaMyEventBus();
    }
}
