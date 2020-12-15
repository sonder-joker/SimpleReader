package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class NewsRepository {

    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public NewsRepository(SubscribeRssDao subScribeRssDao) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public @NotNull LiveData<List<GroupWithSubscribeRss>> getAllSubscribeRssWithGroup() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

}
