package com.youngerhousea.simplereader.di;

import com.youngerhousea.simplereader.adapter.ChannelConverterFactory;
import com.youngerhousea.simplereader.adapter.LiveDataCallAdapterFactory;
import com.youngerhousea.simplereader.data.net.api.FetchRss;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    private static final int DEFAULT_TIMEOUT = 5;
    private static final OkHttpClient.Builder builder = new OkHttpClient.Builder();
    private static final String baseUrl = "https://rsshub.app";

    @Provides
    @Singleton
    OkHttpClient getClient() {
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(ChannelConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    FetchRss getFetchRss(Retrofit retrofit) {
        return retrofit.create(FetchRss.class);
    }
}
