package com.youngerhousea.simplereader.di;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.data.AppDatabase;
import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.Group;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {
    private static final String name = "app.db";

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                name
        ).fallbackToDestructiveMigration()
                .addCallback(new RoomDatabase.Callback() {
                    @Inject
                    SubscribeRssDao subscribeRssDao;

                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        subscribeRssDao.insertGroup(new Group(context.getString(R.string.global_default_group_name)));
                    }
                }).build();
    }

    @Provides
    @Singleton
    SubscribeRssDao provideSubscribeDatabase(AppDatabase appDatabase) {
        return appDatabase.getSubscribeRssDao();
    }

}
