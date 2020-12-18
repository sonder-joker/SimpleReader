package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.api.ApiResponse;
import com.youngerhousea.simplereader.api.FetchRss;
import com.youngerhousea.simplereader.api.xml.TheRss;
import com.youngerhousea.simplereader.base.Resource;
import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import java.util.List;

import javax.inject.Inject;

public class NewsRepository {

    private final String TAG = this.getClass().getName();

    private final SubscribeRssDao subScribeRssDao;

    private final FetchRss fetchRss;

    @Inject
    public NewsRepository(SubscribeRssDao subScribeRssDao, FetchRss fetchRss) {
        this.subScribeRssDao = subScribeRssDao;
        this.fetchRss = fetchRss;
    }


    public LiveData<List<GroupWithSubscribeRss>> getAllSubscribeRssWithGroup() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public LiveData<Resource<TheRss>> getRss() {
        return new NetworkBoundResource<TheRss, List<GroupWithSubscribeRss>>() {

            @Override
            protected void saveCallResult(List<GroupWithSubscribeRss> item) {

            }

            @Override
            protected boolean shouldFetchData(TheRss data) {
                return data == null;
            }

            @Override
            protected LiveData<TheRss> loadFromDb() {
                return subScribeRssDao.getAllSubscribeRssWithGroup().observe();
            }

            @Override
            protected LiveData<ApiResponse<List<GroupWithSubscribeRss>>> createCall() {
                return null;
            }
        }.asLiveData();

    }


}