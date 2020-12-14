package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;
import com.youngerhousea.simplereader.repository.RssAddRepository;

public class RssSearchViewModel extends BaseViewModel {

    private final RssAddRepository repository;

    public MutableLiveData<String> keyword = new MutableLiveData<>();

    @ViewModelInject
    public RssSearchViewModel(@Assisted SavedStateHandle savedStateHandle, RssAddRepository repository) {
        this.repository = repository;
    }

    public void search() {
        repository.searchKeyWord(keyword.getValue());
        keyword.setValue("");
    }
}
