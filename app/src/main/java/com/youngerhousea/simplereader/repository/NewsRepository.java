package com.youngerhousea.simplereader.repository;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.SubscribeRss;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Flowable;
import okhttp3.OkHttpClient;

public class NewsRepository {
    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public NewsRepository(SubscribeRssDao subScribeRssDao, OkHttpClient client) {
        this.subScribeRssDao = subScribeRssDao;
    }

}
