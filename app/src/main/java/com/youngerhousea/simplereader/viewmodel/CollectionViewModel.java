package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.repository.CollectionRepository;

public class CollectionViewModel extends BaseViewModel {
    private final CollectionRepository repository;
    public MutableLiveData<String> groupToAdd = new MutableLiveData<>("");

    @ViewModelInject
    public CollectionViewModel(CollectionRepository repository) {
        this.repository = repository;
    }

    public void insertGroup() {
        repository.insertGroup(groupToAdd.getValue());
        groupToAdd.setValue("");
    }
}
