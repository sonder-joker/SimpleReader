package com.youngerhousea.simplereader.di;

import com.youngerhousea.simplereader.rx.AppSchedulerProvider;
import com.youngerhousea.simplereader.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class SchedulerModule {
    @Provides
    @Singleton
    SchedulerProvider getSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
