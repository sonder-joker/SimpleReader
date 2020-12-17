package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssAddBinding;
import com.youngerhousea.simplereader.utils.Utils;
import com.youngerhousea.simplereader.viewmodel.RssAddViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssAddFragment extends BaseFragment<FragmentRssAddBinding, RssAddViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.rssAddViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rss_add;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setButtonListener();
    }

    private void setButtonListener() {
        dataBinding.button.setOnClickListener(v -> {
            Integer groupId = viewModel.groupId.getValue();
            String url = viewModel.urlToAdd.getValue();

            if (Utils.isNullOrEmpty(url) || Utils.isNullOrEmpty(groupId))
                Snackbar.make(view, R.string.cannot_add_empty, Snackbar.LENGTH_SHORT).show();
            else
                viewModel.insertSubscribeRss();
        });
    }

}