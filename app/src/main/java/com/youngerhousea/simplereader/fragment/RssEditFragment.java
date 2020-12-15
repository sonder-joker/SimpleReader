package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.RssEditAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssEditBinding;
import com.youngerhousea.simplereader.viewmodel.RssEditViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssEditFragment extends BaseFragment<FragmentRssEditBinding, RssEditViewModel> {
    @Override
    public int getBindingViewModel() {
        return BR.rssEditViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rss_edit;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataBinding.fragmentRssEditRvGroupUrl.setHasFixedSize(true);
        dataBinding.fragmentRssEditRvGroupUrl.setLayoutManager(new LinearLayoutManager(getContext()));
        dataBinding.fragmentRssEditRvGroupUrl.setLayoutManager(new LinearLayoutManager(getContext()));
        dataBinding.fragmentRssEditRvGroupUrl.setAdapter(new RssEditAdapter(viewModel.subscribeRssWithGroups.getValue()));
    }
}
