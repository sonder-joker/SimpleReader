package com.youngerhousea.simplereader.di;

import com.youngerhousea.simplereader.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class PoolModule {
    private AppExecutors appExecutors = new AppExecutors();
    @Singleton
    @Provides
    public AppExecutors getAppExecutors() {
        return appExecutors;
    }
}
