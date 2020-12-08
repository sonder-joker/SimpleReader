package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;
import com.youngerhousea.simplereader.repository.RssAddRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddViewModel extends BaseViewModel {
    private final RssAddRepository repository;
    public final MutableLiveData<List<SubscribeRssWithGroup>> data = new MutableLiveData<>();
    public MutableLiveData<List<String>> groups;
    public MutableLiveData<String> urlToAdd;
    public MutableLiveData<Integer> groupId;

    @ViewModelInject
    public RssAddViewModel(@Assisted SavedStateHandle savedStateHandle, RssAddRepository repository) {
//        TODO:
        this.repository = repository;
        repository.getAllGroup()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Subscription s) {

                    }

                    @Override
                    public void onNext(List<String> groupsFromDao) {
                        groups.setValue(groupsFromDao);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void addToGroup(String url, int groupId) {
        repository.insertSubscribeRss(url, groupId);
    }
}