package com.youngerhousea.simplereader.di;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
    private static final String name = "app.db";

    private final RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@ApplicationContext Context context) {

        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                name
        ).fallbackToDestructiveMigration().addCallback(callback).build();
    }

    @Provides
    @Singleton
    SubscribeRssDao provideSubscribeDatabase(AppDatabase appDatabase) {
        return appDatabase.getSubscribeRssList();
    }

}
