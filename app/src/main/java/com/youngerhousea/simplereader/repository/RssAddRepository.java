package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddRepository {
    private final SubscribeRssDao subScribeRssDao;
    private static final String TAG = "RssAddRepository";

    @Inject
    public RssAddRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public Flowable<List<SubscribeRssWithGroup>> getSubscribeRssWithGroupList() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public @NotNull Flowable<List<String>> getAllGroup() {
        return subScribeRssDao.getAllGroup();
    }

    public void insertSubscribeRss(GroupIdAndUrl groupIdAndUrl) {
        insertSubscribeRss(groupIdAndUrl);
    }
}
