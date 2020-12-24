package com.youngerhousea.simplereader.data.repository;

import androidx.lifecycle.LiveData;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.dao.SourceDao;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.net.api.FetchRss;
import com.youngerhousea.simplereader.base.ApiResponse;
import com.youngerhousea.simplereader.base.NetworkBoundResource;
import com.youngerhousea.simplereader.base.Resource;
import com.youngerhousea.simplereader.di.AppExecutors;

import java.util.List;

import javax.inject.Inject;

public class NewsRepository {
    private final AppExecutors appExecutors;
    private SourceDao sourceDao;
    private final FetchRss fetchRss;

    @Inject
    public NewsRepository(SourceDao sourceDao, FetchRss fetchRss, AppExecutors appExecutors) {
        this.sourceDao = sourceDao;
        this.fetchRss = fetchRss;
        this.appExecutors = appExecutors;
    }

    public LiveData<List<String>> getRssUrl() {
        return sourceDao.getRssUrl();
    }

    public LiveData<Resource<RssSource>> getArticle(String url) {
        return new NetworkBoundResource<RssSource, Channel>(appExecutors) {
            @Override
            protected void saveCallResult(Channel item) {
                sourceDao.insertRssSource(url, item);
            }

            @Override
            protected boolean shouldFetchData(RssSource data) {
                return data == null;
            }

            @Override
            protected LiveData<RssSource> loadFromDb() {
                return sourceDao.getRssSource(url);
            }

            @Override
            protected LiveData<ApiResponse<Channel>> createCall() {
                return fetchRss.getChannel(url);
            }
        }.asLiveData();
    }


}