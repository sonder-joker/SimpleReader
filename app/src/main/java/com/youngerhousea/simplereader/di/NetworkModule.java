package com.youngerhousea.simplereader.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    private static final int DEFAULT_TIMEOUT = 5;
    private static final OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    @Provides
    @Singleton
    OkHttpClient getClient() {
        return builder.build();
    }
}
