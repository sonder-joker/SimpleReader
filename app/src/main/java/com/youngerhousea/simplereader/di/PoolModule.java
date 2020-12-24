package com.youngerhousea.simplereader.di;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class PoolModule {
    private final AppExecutors appExecutors = new AppExecutors();

    @Singleton
    @Provides
    public AppExecutors getAppExecutors() {
        return appExecutors;
    }
}
