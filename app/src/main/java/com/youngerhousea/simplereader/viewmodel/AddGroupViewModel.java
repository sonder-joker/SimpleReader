package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.repository.RssAddRepository;

public class AddGroupViewModel extends BaseViewModel {
    private RssAddRepository repository;
    public MutableLiveData<String> groupToAdd = new MutableLiveData<>("");

    @ViewModelInject
    public AddGroupViewModel(RssAddRepository repository) {
        this.repository = repository;
    }


    public void insertGroup() {
        repository.insertGroup(groupToAdd.getValue());
        groupToAdd.setValue("");
    }
}
