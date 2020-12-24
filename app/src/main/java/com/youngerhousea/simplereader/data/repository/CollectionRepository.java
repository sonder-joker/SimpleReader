package com.youngerhousea.simplereader.data.repository;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.data.dao.RssDao;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;
import com.youngerhousea.simplereader.di.AppExecutors;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

public class CollectionRepository {
    private static final String TAG = CollectionRepository.class.getName();

    private final RssDao subScribeRssDao;
    private final AppExecutors appExecutors;

    @Inject
    public CollectionRepository(RssDao subScribeRssDao, AppExecutors appExecutors) {
        this.subScribeRssDao = subScribeRssDao;
        this.appExecutors = appExecutors;
    }

    public LiveData<List<GroupWithRssUrls>> getSubscribeRssWithGroupList() {
        return subScribeRssDao.getAllSubscribeRssWithGroup();
    }

    public @NotNull LiveData<List<String>> getAllGroup() {
        return subScribeRssDao.getAllGroup();
    }

    public void insertSubscribeRss(Integer groupId, String url) {
        appExecutors.getDiskIO().execute(() -> subScribeRssDao
                .insertRssUrl(new GroupIdAndRssUrl(groupId, url)));
    }

    public void insertGroup(String groupName) {
        appExecutors.getDiskIO().execute(() -> subScribeRssDao
                .insertGroup(new Group(groupName)));
    }

    public void searchKeyWord(String keyword) {

    }

    public void deleteGroup(Group group) {
        subScribeRssDao.deleteGroup(group);
    }

    public void deleteRssUrl(RssUrl rssUrl) {
        subScribeRssDao.deleteRssUrl(rssUrl);
    }
}
