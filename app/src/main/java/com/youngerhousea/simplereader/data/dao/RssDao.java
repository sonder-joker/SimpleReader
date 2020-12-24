 package com.youngerhousea.simplereader.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;

import java.util.List;

 @Dao
public interface RssDao {

    @Transaction
    @Query("SELECT * FROM groupList")
    LiveData<List<GroupWithRssUrls>> getAllSubscribeRssWithGroup();

    @Query("SELECT DISTINCT groupName FROM groupList")
    LiveData<List<String>> getAllGroup();

    @Insert(entity = RssUrl.class)
    void insertRssUrl(GroupIdAndRssUrl groupIdAndRssUrl);

    @Insert(entity = Group.class)
    void insertGroup(Group groupName);

    @Delete(entity = Group.class)
    void deleteGroup(Group group);

    @Delete(entity = RssUrl.class)
    void deleteRssUrl(RssUrl rssUrl);
}

