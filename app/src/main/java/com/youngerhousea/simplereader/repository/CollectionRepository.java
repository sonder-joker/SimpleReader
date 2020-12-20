package com.youngerhousea.simplereader.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.data.RssDao;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CollectionRepository {
    private static final String TAG = CollectionRepository.class.getName();

    private final RssDao subScribeRssDao;

    @Inject
    public CollectionRepository(RssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public LiveData<List<GroupWithRssUrls>> getSubscribeRssWithGroupList() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public @NotNull LiveData<List<String>> getAllGroup() {
        return subScribeRssDao.getAllGroup();
    }

    public Disposable insertSubscribeRss(Integer groupId, String url) {
        return subScribeRssDao
                .insertRssUrl(new GroupIdAndRssUrl(groupId, url))
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
