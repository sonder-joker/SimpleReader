package com.youngerhousea.simplereader.repository;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Transformations;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.RssDao;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.data.model.RssUrlAndRssSource;
import com.youngerhousea.simplereader.net.api.FetchRss;
import com.youngerhousea.simplereader.repository.base.ApiResponse;
import com.youngerhousea.simplereader.repository.base.NetworkBoundResource;
import com.youngerhousea.simplereader.repository.base.Resource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

public class NewsRepository {

    private final String TAG = this.getClass().getName();

    private final RssDao rssDao;

    private final FetchRss fetchRss;

    @Inject
    public NewsRepository(RssDao rssDao, FetchRss fetchRss) {
        this.rssDao = rssDao;
        this.fetchRss = fetchRss;
    }


    public LiveData<List<String>> getAllRssUrl() {
        return Transformations.map(rssDao.getAllSubscribeRssWithGroup(),
                input -> input.stream()
                        .flatMap(groupWithRssUrls -> groupWithRssUrls.getUrls().stream())
                        .collect(Collectors.toList()));
    }


    public LiveData<Resource<Channel>> getRssSource(String url) {

        return new NetworkBoundResource<Channel, Channel>() {
            @Override
            protected void saveCallResult(Channel item) {
                rssDao.insertRssSource(url, item);
            }

            @Override
            protected boolean shouldFetchData(Channel data) {
                return data == null /*|| time > setting*/;
            }

            @Override
            protected LiveData<Channel> loadFromDb() {
                return Transformations.map(rssDao.getRssSource(url), RssUrlAndRssSource::getChannel);
            }

            @Override
            protected LiveData<ApiResponse<Channel>> createCall() {
                return fetchRss.getChannel(url);
            }
        }.asLiveData();
    }

}