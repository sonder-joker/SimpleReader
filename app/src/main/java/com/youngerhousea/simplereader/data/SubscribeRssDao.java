package com.youngerhousea.simplereader.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.youngerhousea.simplereader.data.model.SubscribeRss;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface SubscribeRssDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGroup(String group);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubscribeRss(SubscribeRss subscribeRss);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllSubscribeRss(SubscribeRss... subscribeRss);

    @Query("SELECT * FROM subscribeRss")
    Flowable<List<SubscribeRss>> loadAllSubscribeRss();

    @Delete
    void deleteSubscribeRss(SubscribeRss subscribeRss);

    @Query("SELECT DISTINCT `group` FROM subscriberss")
    Flowable<List<String>> loadAllGroup();
}
