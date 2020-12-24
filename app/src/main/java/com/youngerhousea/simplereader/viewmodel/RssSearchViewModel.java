package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.data.repository.CollectionRepository;

public class RssSearchViewModel extends BaseViewModel {

    private final CollectionRepository repository;

    public MutableLiveData<String> keyword = new MutableLiveData<>();

    @ViewModelInject
    public RssSearchViewModel(@Assisted SavedStateHandle savedStateHandle, CollectionRepository repository) {
        this.repository = repository;
    }

    public void search() {
        repository.searchKeyWord(keyword.getValue());
        keyword.setValue("");
    }
}
