package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class RssAddRepository {
    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public RssAddRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;

    }

    public Flowable<List<String>> getGroup() {
        return subScribeRssDao.loadAllGroup();
    }
}
