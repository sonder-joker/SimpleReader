package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;

public class CollectionViewModel extends BaseViewModel {
    @ViewModelInject
    public CollectionViewModel(@Assisted SavedStateHandle savedStateHandle) {
    }
}
