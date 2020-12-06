package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.youngerhousea.simplereader.rx.SchedulerProvider;

public class MeViewModel extends BaseViewModel {
    @ViewModelInject
    public MeViewModel(@Assisted SavedStateHandle savedStateHandle) {
    }
}