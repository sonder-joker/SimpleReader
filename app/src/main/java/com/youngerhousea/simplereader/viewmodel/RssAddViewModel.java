package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.repository.CollectionRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RssAddViewModel extends BaseViewModel {
    private final CollectionRepository repository;
    public LiveData<List<String>> groups;
    public MutableLiveData<String> urlToAdd = new MutableLiveData<>();
    public MutableLiveData<Integer> groupId = new MutableLiveData<>();

    @ViewModelInject
    public RssAddViewModel(@Assisted SavedStateHandle savedStateHandle, @NotNull CollectionRepository repository) {
        this.repository = repository;
        groups = repository.getAllGroup();
    }

    public void insertSubscribeRss() {
        repository.insertSubscribeRss(groupId.getValue() + 1, urlToAdd.getValue());
        urlToAdd.setValue("");
    }


}