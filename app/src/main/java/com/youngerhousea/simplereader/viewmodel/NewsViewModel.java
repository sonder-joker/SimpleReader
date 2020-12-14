package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.model.SubscribeRssWithGroup;
import com.youngerhousea.simplereader.repository.NewsRepository;

import java.util.List;

public class NewsViewModel extends BaseViewModel {
    private final NewsRepository newsRepository;
    public LiveData<List<SubscribeRssWithGroup>> subscribeRssList;


    @ViewModelInject
    public NewsViewModel(@Assisted SavedStateHandle savedStateHandle, NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        subscribeRssList = this.newsRepository.getAllSubscribeRssWithGroup();
    }

}