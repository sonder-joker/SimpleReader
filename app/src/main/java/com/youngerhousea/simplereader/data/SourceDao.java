package com.youngerhousea.simplereader.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.model.entity.RssSource;

import java.util.List;

@Dao
public abstract class SourceDao {

    @Transaction
    @Query("SELECT url FROM rssUrlList")
    public abstract LiveData<List<String>> getRssUrl();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract void insertRssSource(RssSource rssSource);

    @Query("SELECT * FROM rssSourceList WHERE rssUrlId = (SELECT rssUrlId FROM rssUrlList WHERE rssUrlList.url = :url LIMIT 1)")
    public abstract LiveData<RssSource> getRssSource(String url);

    @Query("SELECT rssUrlId FROM rssUrlList WHERE rssUrlList.url = :url")
    protected abstract Integer getRssId(String url);

    public void insertRssSource(String url, Channel item) {
        Integer id = getRssId(url);
        insertRssSource(new RssSource(id, item));
    }
}
