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
import com.youngerhousea.simplereader.repository.base.Resource;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface RssDao {

    @Transaction
    @Query("SELECT * FROM groupList")
    LiveData<List<GroupWithRssUrls>> getAllSubscribeRssWithGroup();

    @Query("SELECT DISTINCT groupName FROM groupList")
    LiveData<List<String>> getAllGroup();

    @Insert(entity = RssUrl.class)
    Completable insertRssUrl(GroupIdAndRssUrl groupIdAndRssUrl);

    @Insert(entity = Group.class)
    Completable insertGroup(Group groupName);

}

