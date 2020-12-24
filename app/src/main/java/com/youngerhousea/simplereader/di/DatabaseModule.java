package com.youngerhousea.simplereader.di;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.youngerhousea.simplereader.data.dao.AppDatabase;
import com.youngerhousea.simplereader.data.dao.RssDao;
import com.youngerhousea.simplereader.data.dao.SourceDao;

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
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
//                        db.execSQL("INSERT INTO groupList (groupName) VALUES ("
//                                + context.getString(R.string.global_default_group_name)
//                                + ")");
                    }
                }).build();
    }

    @Provides
    @Singleton
    RssDao provideSubscribeDatabase(AppDatabase appDatabase) {
        return appDatabase.getSubscribeRssDao();
    }

    @Provides
    @Singleton
    SourceDao provideSourceDao(AppDatabase appDatabase) {
        return appDatabase.getSourceDao();
    }

}
