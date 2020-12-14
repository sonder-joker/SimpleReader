package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.repository.RssAddRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RssAddViewModel extends BaseViewModel {
    private final RssAddRepository repository;
    public MutableLiveData<List<String>> groups;
    public MutableLiveData<String> urlToAdd = new MutableLiveData<>();
    public MutableLiveData<Integer> groupId = new MutableLiveData<>();

    @ViewModelInject
    public RssAddViewModel(@Assisted SavedStateHandle savedStateHandle, @NotNull RssAddRepository repository) {
        this.repository = repository;
        groups = repository.getAllGroup();
    }

    public void insertSubscribeRss() {
        repository.insertSubscribeRss(groupId.getValue(), urlToAdd.getValue());
        urlToAdd.setValue("");
    }


}