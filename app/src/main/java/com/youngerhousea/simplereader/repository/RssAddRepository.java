package com.youngerhousea.simplereader.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddRepository {
    private static final String TAG = RssAddRepository.class.getName();

    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public RssAddRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public @NotNull LiveData<List<GroupWithSubscribeRss>> getSubscribeRssWithGroupList() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public @NotNull LiveData<List<String>> getAllGroup() {
        return subScribeRssDao.getAllGroup();
    }

    public Disposable insertSubscribeRss(Integer groupId, String url) {
        return subScribeRssDao
                .insertSubscribeRss(new GroupIdAndUrl(groupId, url))
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(() -> Log.d(TAG, "insertSubscribeRss: insert subscribe rss")
                        , throwable -> Log.e(TAG, "insertSubscribeRss: insert wrong", throwable));

    }

    public Disposable insertGroup(String groupName) {
        return subScribeRssDao
                .insertGroup(new Group(groupName))
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(() -> Log.d(TAG, "insertGroup: insert group success")
                        , throwable -> Log.e(TAG, "insertGroup: insert wrong", throwable));
    }

    public void searchKeyWord(String keyword) {

    }
}
