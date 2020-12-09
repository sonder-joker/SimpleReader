package com.youngerhousea.simplereader.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.SubscribeRss;

@Database(entities = {SubscribeRss.class, Group.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SubscribeRssDao getSubscribeRssList();
}
