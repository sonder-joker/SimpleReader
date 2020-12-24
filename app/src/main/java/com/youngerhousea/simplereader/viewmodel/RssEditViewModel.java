package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;
import com.youngerhousea.simplereader.data.repository.CollectionRepository;

import java.util.List;

public class RssEditViewModel extends BaseViewModel {
    private final CollectionRepository collectionRepository;
    public LiveData<List<GroupWithRssUrls>> subscribeRssWithGroups;

    @ViewModelInject
    public RssEditViewModel(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
        this.subscribeRssWithGroups = collectionRepository.getSubscribeRssWithGroupList();
    }

    public void deleteGroup(Group group) {
        collectionRepository.deleteGroup(group);
    }

    public void deleteRssUrl(RssUrl rssUrl) {
        collectionRepository.deleteRssUrl(rssUrl);
    }
}
