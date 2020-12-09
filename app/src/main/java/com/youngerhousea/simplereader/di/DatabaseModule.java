package com.youngerhousea.simplereader.di;


import android.content.Context;

import androidx.room.Room;

import com.youngerhousea.simplereader.data.AppDatabase;
import com.youngerhousea.simplereader.data.SubscribeRssDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                "app.db"
        ).build();
    }

    @Provides
    @Singleton
    SubscribeRssDao provideSubscribeDatabase(AppDatabase appDatabase){
        return appDatabase.getSubscribeRssList();
    }
}
