package com.youngerhousea.simplereader.repository;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.SubscribeRss;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;

public class RssAddRepository {
    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public RssAddRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public Flowable<List<SubscribeRssWithGroup>> getSubscribeRssWithGroupList() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public Flowable<List<String>> getAllGroup() {
        return subScribeRssDao.getAllGroup();
    }

    public void insertSubscribeRss(String url, int groupId) {
        subScribeRssDao.insertSubscribeRss(new SubscribeRss(groupId, url));
    }
}
