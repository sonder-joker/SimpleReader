package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;

import com.youngerhousea.simplereader.base.BaseViewModel;

public class MeViewModel extends BaseViewModel {
    @ViewModelInject
    public MeViewModel(@Assisted SavedStateHandle savedStateHandle) {
    }
}