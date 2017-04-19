package com.splashcode.aqs.presentation.infrastructure.di;

import android.app.Activity;

import com.splashcode.aqs.BuildConfig;
import com.splashcode.aqs.data.event.bus.GuavaMyEventBus;
import com.splashcode.aqs.data.event.bus.MyEventBus;
import com.splashcode.aqs.presentation.infrastructure.annotation.PerActivity;
import com.splashcode.aqs.presentation.infrastructure.log.Logger;
import com.splashcode.aqs.presentation.infrastructure.log.LoggerDebug;
import com.splashcode.aqs.presentation.infrastructure.log.LoggerRelease;
import com.splashcode.aqs.data.provider.backend.BackEndDataProviderFactory;
import com.splashcode.aqs.presentation.infrastructure.frontend.UserInfoProviderProxy;
import com.splashcode.aqs.presentation.infrastructure.frontend.UserInfoProxy;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

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

    @Provides @Named("UserInfo")
    UserInfoProxy provideUserInfoProviderProxy(final MyEventBus myEventBus, final BackEndDataProviderFactory eventBusResponseProviderFactory){
        return new UserInfoProviderProxy(myEventBus, eventBusResponseProviderFactory);
    }

    @Provides
    MyEventBus provideEventBusAdapter(){
        return new GuavaMyEventBus();
    }

    @Provides BackEndDataProviderFactory provideBackEndDataProviderFactory(){
        return new BackEndDataProviderFactory();
    }

    @Provides
    public Logger provideLogger(){
        return BuildConfig.DEBUG ? new LoggerDebug() : new LoggerRelease();
    }

//    private Retrofit getBeezyAroundRestAdapter(final Context context) {
//        final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
//        okHttpClient.addInterceptor(new HttpLoggingInterceptor());
//
//        okHttpClient.readTimeout(30, TimeUnit.SECONDS);
//        okHttpClient.connectTimeout(30, TimeUnit.SECONDS);
//
//        return new Retrofit.Builder()
//                .baseUrl(context.getString(R.string.base_url))
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient.build())
//                .build();
//    }
}
