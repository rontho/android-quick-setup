package com.splashcode.aqs.presentation.infrastructure.di;

import android.app.Activity;
import android.content.Context;

import com.splashcode.aqs.BuildConfig;
import com.splashcode.aqs.R;
import com.splashcode.aqs.data.eventbus.EventBus;
import com.splashcode.aqs.data.http.HttpRequestMaker;
import com.splashcode.aqs.data.repository.UserCloudRepository;
import com.splashcode.aqs.data.repository.UserDatabaseRepository;
import com.splashcode.aqs.data.repository.translator.UserDataTranslator;
import com.splashcode.aqs.domain.event.answer.AnswerFactory;
import com.splashcode.aqs.domain.event.bus.EventBusProducer;
import com.splashcode.aqs.domain.repository.UserRepository;
import com.splashcode.aqs.domain.usecase.UseCaseFactory;
import com.splashcode.aqs.domain.usecase.UseCaseRunner;
import com.splashcode.aqs.presentation.infrastructure.annotation.PerActivity;
import com.splashcode.aqs.data.log.CustomLogger;
import com.splashcode.aqs.data.log.CustomLoggerDebug;
import com.splashcode.aqs.data.log.CustomLoggerRelease;
import com.splashcode.aqs.presentation.presenter.MainActivityPresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by troncaglia on 15/12/2014.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    public CustomLogger provideLogger(){
        return BuildConfig.DEBUG ? new CustomLoggerDebug() : new CustomLoggerRelease();
    }

    @Provides
    public MainActivityPresenter provideMainActivityPresenter(final CustomLogger customLogger, final EventBus eventBus, final UseCaseRunner useCaseRunner, final UseCaseFactory useCaseFactory){
        return new MainActivityPresenter(customLogger, eventBus, useCaseRunner, useCaseFactory);
    }

    @Provides UseCaseFactory provideUseCaseFactory(final AnswerFactory answerFactory, final EventBusProducer eventBusProducer, @Named("LocalUserRepository") final UserRepository databaseDataRepository, @Named("CloudUserRepository") final UserRepository cloudUserRepository){
        return new UseCaseFactory(answerFactory, eventBusProducer, databaseDataRepository, cloudUserRepository);
    }
}
