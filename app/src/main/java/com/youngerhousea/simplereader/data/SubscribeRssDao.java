package com.youngerhousea.simplereader.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Transaction;

import com.youngerhousea.simplereader.data.model.SubscribeRss;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface SubscribeRssDao {

    @Transaction
    @Query("SELECT * FROM subscribeRssList")
    Flowable<List<SubscribeRssWithGroup>> getAllSubscribeRssWithGroup();

    @Query("SELECT DISTINCT group_name FROM groupList")
    Flowable<List<String>> getAllGroup();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubscribeRss(SubscribeRss subscribeRss);


}
