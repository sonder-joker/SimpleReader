package com.youngerhousea.simplereader.repository;

import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.SubscribeRss;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;

public class NewsRepository {

    private final SubscribeRssDao subScribeRssDao;

    @Inject
    public NewsRepository(SubscribeRssDao subScribeRssDao, OkHttpClient client) {
        this.subScribeRssDao = subScribeRssDao;
    }

    public @NotNull MutableLiveData<List<SubscribeRssWithGroup>> getAllSubscribeRssWithGroup() {
        final MutableLiveData<List<SubscribeRssWithGroup>> data = new MutableLiveData<>();
        subScribeRssDao.getAllSubscribeRssWithGroup()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(subscribeRssWithGroups -> {
                    if (subscribeRssWithGroups != null) {
                        data.setValue(subscribeRssWithGroups);
                    } else {
                        data.setValue(new ArrayList<>());
                    }
                })
                .dispose();
        return data;
    }

}
