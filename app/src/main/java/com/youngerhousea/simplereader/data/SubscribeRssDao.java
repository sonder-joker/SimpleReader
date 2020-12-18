package com.youngerhousea.simplereader.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.youngerhousea.simplereader.api.xml.TheRss;
import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.data.model.SubscribeRss;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface SubscribeRssDao {

    @Transaction
    @Query("SELECT * FROM groupList")
    LiveData<List<GroupWithSubscribeRss>> getAllSubscribeRssWithGroup();


    @Transaction
    @Query("SELECT * FROM groupList")
    List<GroupWithSubscribeRss> getAllSubscribeRssWithGroupData();

    @Query("SELECT DISTINCT groupName FROM groupList")
    LiveData<List<String>> getAllGroup();

    @Insert(entity = SubscribeRss.class)
    Completable insertSubscribeRss(GroupIdAndUrl groupIdAndUrl);

    @Insert(entity = Group.class)
    Completable insertGroup(Group groupName);

    @Insert(entity = TheRss.class)
    Completable insertRss(TheRss... theRsses);


}

