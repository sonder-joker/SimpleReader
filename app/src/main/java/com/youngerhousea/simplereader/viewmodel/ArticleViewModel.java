package com.youngerhousea.simplereader.viewmodel;

import androidx.hilt.Assisted;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.youngerhousea.simplereader.base.BaseViewModel;

public class ArticleViewModel extends BaseViewModel {

    @ViewModelInject
    public ArticleViewModel(@Assisted SavedStateHandle savedStateHandle) {

    }
}