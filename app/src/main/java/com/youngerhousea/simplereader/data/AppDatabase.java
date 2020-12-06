package com.youngerhousea.simplereader.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.youngerhousea.simplereader.data.model.SubscribeRss;

@Database(entities = SubscribeRss.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SubscribeRssDao getSubscribeRssList();
}
