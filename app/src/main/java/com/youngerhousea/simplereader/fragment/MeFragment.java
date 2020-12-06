package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentMeBinding;
import com.youngerhousea.simplereader.viewmodel.MeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MeFragment extends BaseFragment<FragmentMeBinding, MeViewModel> {

    @Override
    public int getBindingVariable() {
        return BR.meViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return viewDataBinding.getRoot();
    }
}