package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.data.model.SubscribeRss;
import com.youngerhousea.simplereader.repository.NewsRepository;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class NewsViewModel extends BaseViewModel {
    private final NewsRepository newsRepository;
    private MutableLiveData<List<SubscribeRss>> _subscribeRssList = new MutableLiveData<>();

    public LiveData<List<SubscribeRss>> getSubscribeRssList() {
        return _subscribeRssList;
    }

    @ViewModelInject
    public NewsViewModel(@Assisted SavedStateHandle savedStateHandle, NewsRepository newsRepository) {

        this.newsRepository = newsRepository;
//        TODO:
        setSubscribeRssList(newsRepository);
    }

    private void setSubscribeRssList(NewsRepository newsRepository) {
        newsRepository.getSubScribeRssDao()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<SubscribeRss>>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(List<SubscribeRss> subscribeRsses) {
                        _subscribeRssList.setValue(subscribeRsses);
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