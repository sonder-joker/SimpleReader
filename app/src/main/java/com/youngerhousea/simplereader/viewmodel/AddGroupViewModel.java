package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.repository.CollectionRepository;

public class AddGroupViewModel extends BaseViewModel {
    private CollectionRepository repository;
    public MutableLiveData<String> groupToAdd = new MutableLiveData<>("");

    @ViewModelInject
    public AddGroupViewModel(CollectionRepository repository) {
        this.repository = repository;
    }


    public void insertGroup() {
        compositeDisposable.add(repository.insertGroup(groupToAdd.getValue()));
        groupToAdd.setValue("");
    }
}
