package com.youngerhousea.simplereader.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;

import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddRepository {
    private final SubscribeRssDao subScribeRssDao;
    private static final String TAG = "RssAddRepository";

    @Inject
    public RssAddRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
//        Flowable.just("Default")
//                .observeOn(Schedulers.io())
//                .subscribe(
//                        subScribeRssDao::insertGroup,
//                        throwable -> Log.w(TAG, "RssAddRepository: can't init group", throwable),
//                        () -> Log.d(TAG, "RssAddRepository: init group")
//                )
//                .dispose();
    }

    public MutableLiveData<List<SubscribeRssWithGroup>> getSubscribeRssWithGroupList() {
        final MutableLiveData<List<SubscribeRssWithGroup>> subscribeRssWithGroupList = new MutableLiveData<>();
        subScribeRssDao.getAllSubscribeRssWithGroup()
                .observeOn(Schedulers.io())
                .subscribe(
                        subscribeRssWithGroupList::setValue,
                        throwable -> Log.w(TAG, "getSubscribeRssWithGroupList: can't get all subscribeRss With Group List", throwable),
                        () -> Log.d(TAG, "getSubscribeRssWithGroupList: get all subscribeRss With Group List"))
                .dispose();

        return subscribeRssWithGroupList;
    }

    public @NotNull MutableLiveData<List<String>> getAllGroup() {
        final MutableLiveData<List<String>> groups = new MutableLiveData<>();
        subScribeRssDao.getAllGroup()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        value -> {
                            if (value != null)
                                groups.setValue(value);
                            else
                                groups.setValue(new ArrayList<>());
                        },
                        throwable -> Log.w(TAG, "getAllGroup: can't get all group", throwable),
                        () -> Log.d(TAG, "getAllGroup: get all group")
                ).dispose();
        return groups;
    }

    public void insertSubscribeRss(int groupId, String url) {
        Flowable.just(new GroupIdAndUrl(groupId, url))
                .subscribeOn(Schedulers.io())
                .subscribe(
                        subScribeRssDao::insertSubscribeRss,
                        throwable -> Log.w(TAG, "insertSubscribeRss: Insert into Database error", throwable),
                        () -> Log.d(TAG, "insertSubscribeRss: Insert into Database Complete"))
                .dispose();
    }

    public void insertGroup(String value) {
        if(value == null) {
            return;
        }
        Flowable.just(value)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        subScribeRssDao::insertGroup,
                        throwable -> Log.w(TAG, "insertGroup: Insert into Database error", throwable),
                        () -> Log.d(TAG, "insertGroup: Insert into Database Complete"))
                .dispose();
    }
}
