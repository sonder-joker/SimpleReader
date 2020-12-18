package com.youngerhousea.simplereader.di;

import com.youngerhousea.simplereader.api.FetchRss;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    private static final int DEFAULT_TIMEOUT = 5;
    private static final OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    private static final String baseUrl = "";

    @Provides
    @Singleton
    OkHttpClient getClient() {
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    FetchRss getFetchRss(Retrofit retrofit) {
        return retrofit.create(FetchRss.class);
    }
}
