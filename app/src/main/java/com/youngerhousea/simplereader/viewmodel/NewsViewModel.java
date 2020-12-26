package com.youngerhousea.simplereader.viewmodel;


import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import com.prof.rssparser.Article;
import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.base.Resource;
import com.youngerhousea.simplereader.base.Status;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsViewModel extends BaseViewModel {

    public LiveData<Boolean> visibility = new MutableLiveData<>(false);
    public MutableLiveData<Integer> currentPosition = new MediatorLiveData<>();
    private NewsRepository newsRepository;

    public LiveData<List<Resource<RssSource>>> rssData;
    public LiveData<List<Article>> articleData;

    @ViewModelInject
    public NewsViewModel(@Assisted SavedStateHandle savedStateHandle, NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
        LiveData<List<String>> rssUrl = newsRepository.getRssUrl();
        rssData = Transformations.switchMap(rssUrl, input -> {
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

        articleData = Transformations.map(rssData, input -> input.stream().flatMap(rssSourceResource -> {
            if (rssSourceResource.getStatus() != Status.SUCCESS) {
                return null;
            }
            return rssSourceResource.getData().getChannel().getArticles().stream();
        }).collect(Collectors.toList()));

    }


    public void setVisibilityTrue() {
        ((MutableLiveData<Boolean>) visibility).setValue(true);
    }

    public void setCurrentPosition(int position) {
        currentPosition.setValue(position);
    }
}