package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;
import com.youngerhousea.simplereader.repository.RssAddRepository;

import java.util.List;

public class RssEditViewModel extends BaseViewModel {
    private final RssAddRepository rssAddRepository;
    public LiveData<List<GroupWithSubscribeRss>> subscribeRssWithGroups;

    @ViewModelInject
    public RssEditViewModel(RssAddRepository rssAddRepository) {
        this.rssAddRepository = rssAddRepository;
        this.subscribeRssWithGroups = rssAddRepository.getSubscribeRssWithGroupList();
    }

}
