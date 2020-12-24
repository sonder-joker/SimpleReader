package com.youngerhousea.simplereader.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

@Database(entities = {RssUrl.class, Group.class, RssSource.class}, version = 3)
@TypeConverters(ChannelConverters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RssDao getSubscribeRssDao();

    public abstract SourceDao getSourceDao();
}
