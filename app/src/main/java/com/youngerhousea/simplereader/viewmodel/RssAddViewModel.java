package com.youngerhousea.simplereader.viewmodel;

import android.util.Log;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.repository.RssAddRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddViewModel extends BaseViewModel {
    private final RssAddRepository repository;
    private static final String TAG = "RssAddViewModel";
    public MutableLiveData<List<String>> groups;
    public MutableLiveData<String> urlToAdd = new MutableLiveData<>();
    public MutableLiveData<Integer> groupId = new MutableLiveData<>();


    @ViewModelInject
    public RssAddViewModel(@Assisted SavedStateHandle savedStateHandle, @NotNull RssAddRepository repository) {
        this.repository = repository;
        setGroups();
    }

    private void setGroups() {
        repository.getAllGroup()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        group -> groups.setValue(group),
                        throwable -> Log.w(TAG, "RssAddViewModel: Get all group error", throwable),
                        () -> Log.d(TAG, "RssAddViewModel: Get all group complete")
                ).dispose();
    }

    public void insertSubscribeRss(int groupId, String url) {
        Flowable.just(new GroupIdAndUrl(groupId, url))
                .subscribeOn(Schedulers.io())
                .subscribe(
                        repository::insertSubscribeRss,
                        throwable -> Log.w(TAG, "insertSubscribeRss: Insert into Database error", throwable),
                        () -> Log.d(TAG, "insertSubscribeRss: Insert into Database Complete"))
                .dispose();
    }
}