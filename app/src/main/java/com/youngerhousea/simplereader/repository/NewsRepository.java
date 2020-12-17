package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.api.ApiResponse;
import com.youngerhousea.simplereader.api.FetchRss;
import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

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

    public LiveData<String> getRss() {
        return new NetworkBoundResource<List<GroupWithSubscribeRss>, String>() {

            @Override
            protected boolean shouldFetchData(List<GroupWithSubscribeRss> data) {
                return data == null;
            }

            @Override
            protected LiveData<List<GroupWithSubscribeRss>> loadFromDb() {
                return subScribeRssDao.getAllSubscribeRssWithGroup();
            }

            @Override
            protected LiveData<ApiResponse<String>> createCall() {
                return fetchRss.getRss()
                        .observeOn(Schedulers.io())
                        .subscribeOn(AndroidSchedulers.mainThread())
                        .subscribe(s -> {

                        }, throwable -> {

                        }, () -> {

                        });
            }
        }.asLiveData();
    }

}
