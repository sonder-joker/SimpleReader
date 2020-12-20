package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.repository.CollectionRepository;

import java.util.List;

public class RssEditViewModel extends BaseViewModel {
    private final CollectionRepository collectionRepository;
    public LiveData<List<GroupWithRssUrls>> subscribeRssWithGroups;

    @ViewModelInject
    public RssEditViewModel(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
        this.subscribeRssWithGroups = collectionRepository.getSubscribeRssWithGroupList();
    }

}
