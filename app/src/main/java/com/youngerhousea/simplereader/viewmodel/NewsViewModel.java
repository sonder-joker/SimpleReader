package com.youngerhousea.simplereader.viewmodel;


import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.repository.NewsRepository;
import com.youngerhousea.simplereader.repository.base.Resource;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends BaseViewModel {
    private static final String TAG = "NewsViewModel";

    private NewsRepository newsRepository;

    public LiveData<List<String>> rssUrl;

    public LiveData<List<Resource<RssSource>>> data;


    @ViewModelInject

    public NewsViewModel(@Assisted SavedStateHandle savedStateHandle, NewsRepository newsRepository) {
        this.newsRepository = newsRepository;

        rssUrl = newsRepository.getRssUrl();

        data = Transformations.switchMap(rssUrl, input -> {
            final MediatorLiveData<List<Resource<RssSource>>> returnData = new MediatorLiveData<>();
            for (int i = 0; i < input.size(); i++) {
                String inputString = input.get(i);
                final LiveData<Resource<RssSource>> article = newsRepository.getArticle(inputString);
                int finalI = i;

                returnData.addSource(article, channelResource -> {
                    List<Resource<RssSource>> priorList = returnData.getValue();
                    if (priorList == null) {
                        priorList = new ArrayList<>();
                    }
                    try {
                        priorList.set(finalI, channelResource);
                    } catch (IndexOutOfBoundsException e) {
                        priorList.add(finalI, channelResource);
                    }

                    returnData.setValue(priorList);
                });
            }
            return returnData;
        });
    }


}