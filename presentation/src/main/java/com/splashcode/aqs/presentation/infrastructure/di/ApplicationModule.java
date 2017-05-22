package com.splashcode.aqs.presentation.infrastructure.di;

import android.app.Application;
import android.content.Context;
import android.location.LocationManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.splashcode.aqs.R;
import com.splashcode.aqs.data.database.DaoFactory;
import com.splashcode.aqs.data.database.accessor.UserDataReader;
import com.splashcode.aqs.data.database.accessor.UserDataWriter;
import com.splashcode.aqs.data.database.ormlite.DatabaseHelper;
import com.splashcode.aqs.data.database.ormlite.OrmLiteDaoFactory;
import com.splashcode.aqs.data.eventbus.GuavaEventBus;
import com.splashcode.aqs.data.eventbus.EventBus;
import com.splashcode.aqs.data.http.HttpRequestMaker;
import com.splashcode.aqs.data.http.retrofit.RetrofitHttpRequestMaker;
import com.splashcode.aqs.data.http.retrofit.RetrofitRestApi;
import com.splashcode.aqs.data.log.CustomLogger;
import com.splashcode.aqs.data.repository.UserCloudRepository;
import com.splashcode.aqs.data.repository.UserDatabaseRepository;
import com.splashcode.aqs.data.repository.translator.AddressDataTranslator;
import com.splashcode.aqs.data.repository.translator.CompanyDataTranslator;
import com.splashcode.aqs.data.repository.translator.UserDataTranslator;
import com.splashcode.aqs.domain.event.answer.AnswerFactory;
import com.splashcode.aqs.domain.repository.UserRepository;
import com.splashcode.aqs.domain.usecase.SingleThreadExecutor;
import com.splashcode.aqs.domain.usecase.ThreadExecutor;
import com.splashcode.aqs.presentation.infrastructure.annotation.ForApplication;
import com.splashcode.aqs.presentation.AndroidQuickSetupApplication;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static android.content.Context.LOCATION_SERVICE;

/**
 * A module for Android-specific dependencies which require a {@link Context} or
 * {@link android.app.Application} to create.
 */
@Module
public class ApplicationModule {
    private static final int HTTP_TIMEOUT = 30;
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

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor() {
        return new SingleThreadExecutor();
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    EventBus provideEventBus() {
        return new GuavaEventBus();
    }

    @Provides
    public DatabaseHelper provideDatabaseHelper(final Context context){
        return new DatabaseHelper(context);
    }

    @Provides
    public DaoFactory provideDaoFactory(final DatabaseHelper databaseHelper) {
        return new OrmLiteDaoFactory(databaseHelper);
    }

    @Provides
    public UserDataReader provideUserDataReader(final DaoFactory daoFactory) {
        return new UserDataReader(daoFactory);
    }

    @Provides
    public UserDataWriter provideUserDataWriter(final DaoFactory daoFactory) {
        return new UserDataWriter(daoFactory);
    }

    @Provides @Named("LocalUserRepository")
    public UserRepository provideLocalUserRepository(final UserDataReader userDataReader, final UserDataWriter userDataWriter, final UserDataTranslator userDataTranslator){
        return new UserDatabaseRepository(userDataReader, userDataWriter, userDataTranslator);
    }

    @Provides @Named("CloudUserRepository")
    public UserRepository provideCloudUserRepository(final CustomLogger logger, final HttpRequestMaker httpRequestMaker, final UserDataTranslator userDataTranslator){
        return new UserCloudRepository(logger, httpRequestMaker, userDataTranslator);
    }

    @Provides UserDataTranslator proUserDataTranslator(){
        return new UserDataTranslator(new AddressDataTranslator(), new CompanyDataTranslator());
    }

    @Provides
    public HttpRequestMaker provideHttpRequestMaker(final RetrofitRestApi restApi) {
        return new RetrofitHttpRequestMaker(restApi);
    }

    @Provides @Singleton
    AnswerFactory provideAnswerFactory() {
        return new AnswerFactory();
    }

    @Provides RetrofitRestApi provideRetrofitRestApi(final Context context){
        final Retrofit restAdapter = getRestApiAdapter(context);
        return restAdapter.create(RetrofitRestApi.class);
    }

    private Retrofit getRestApiAdapter(final Context context) {
        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new HttpLoggingInterceptor());

        okHttpClient.readTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS);
        okHttpClient.connectTimeout(HTTP_TIMEOUT, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient.build())
                .build();
    }

}
