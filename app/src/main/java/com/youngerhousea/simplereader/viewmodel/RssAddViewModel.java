package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.repository.RssAddRepository;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RssAddViewModel extends BaseViewModel {
    private final MutableLiveData<List<String>> _group = new MutableLiveData<>();
    private final RssAddRepository repository;
    public LiveData<List<String>> getGroup() {
        return _group;
    }

    @ViewModelInject
    public RssAddViewModel(@Assisted SavedStateHandle savedStateHandle, RssAddRepository repository) {
//        TODO:
        this.repository = repository;
        initGroup();
    }

    private void initGroup() {
        repository.getGroup()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new FlowableSubscriber<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Subscription s) {

                    }

                    @Override
                    public void onNext(List<String> group) {
                        _group.setValue(group);
                    }

                    @Override
                    public void onError(Throwable t) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}