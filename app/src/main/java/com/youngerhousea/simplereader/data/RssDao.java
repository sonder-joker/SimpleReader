package com.youngerhousea.simplereader.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.model.RssUrlAndRssSource;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface RssDao {

    @Transaction
    @Query("SELECT * FROM groupList")
    LiveData<List<GroupWithRssUrls>> getAllSubscribeRssWithGroup();

    @Transaction
    @Query("SELECT * FROM groupList")
    List<GroupWithRssUrls> getAllSubscribeRssWithGroupData();

    @Query("SELECT DISTINCT groupName FROM groupList")
    LiveData<List<String>> getAllGroup();

    @Insert(entity = RssUrl.class)
    Completable insertRssUrl(GroupIdAndRssUrl groupIdAndRssUrl);

    @Insert(entity = Group.class)
    Completable insertGroup(Group groupName);

//    @Insert(entity = RssSource.class)
//    Completable insertRssSource();

    @Transaction
    @Query("SELECT * FROM rssUrlList WHERE rssUrlList.url = :url")
    LiveData<RssUrlAndRssSource> getRssSource(String url);

    @Insert(entity = RssSource.class)
    void insertRssSource(RssSource rssSource);

    @Query("SELECT rssUrlId FROM rssUrlList WHERE rssUrlList.url = :url")
    Integer getRssUrlId(String url);

    @Query("SELECT * FROM rssSourceList WHERE rssUrlId = :rssUrlId")
    RssSource getRssSource(Integer rssUrlId);

    default void insertRssSource(String url, Channel channel) {
        Integer id = getRssUrlId(url);
        insertRssSource(new RssSource(id, channel));
    }
}

