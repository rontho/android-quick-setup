package com.splashcode.aqs.presentation.infrastructure.di;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

import com.splashcode.aqs.data.database.accessor.UserDataReader;
import com.splashcode.aqs.data.database.accessor.UserDataWriter;
import com.splashcode.aqs.data.eventbus.EventBus;
import com.splashcode.aqs.data.http.HttpRequestMaker;
import com.splashcode.aqs.data.log.CustomLogger;
import com.splashcode.aqs.data.repository.UserCloudRepository;
import com.splashcode.aqs.data.repository.UserDatabaseRepository;
import com.splashcode.aqs.data.repository.translator.UserDataTranslator;
import com.splashcode.aqs.domain.event.answer.AnswerFactory;
import com.splashcode.aqs.domain.event.bus.EventBusProducer;
import com.splashcode.aqs.domain.repository.UserRepository;
import com.splashcode.aqs.domain.usecase.ThreadExecutor;
import com.splashcode.aqs.presentation.AndroidQuickSetupApplication;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component (modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(AndroidQuickSetupApplication application);
    //Exposed to sub-graphs.
    Context context();
    EventBus eventBus();
    ThreadExecutor singleThreadExecutor();
    AnswerFactory answerFactory();
    EventBusProducer eventBusProducer();
    @Named ("LocalUserRepository") UserRepository localUserRepository();
    @Named ("CloudUserRepository") UserRepository cloudUserRepository();
}