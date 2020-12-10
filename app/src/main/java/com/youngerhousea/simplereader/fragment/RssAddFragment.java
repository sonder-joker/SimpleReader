package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssAddBinding;
import com.youngerhousea.simplereader.utils.Event;
import com.youngerhousea.simplereader.viewmodel.RssAddViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssAddFragment extends BaseFragment<FragmentRssAddBinding, RssAddViewModel> {

    @Override
    public int getBindingVariable() {
        return BR.rssAddViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rss_add;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewModel.snackBarIsExist.observe(getViewLifecycleOwner(),
                event -> {
                    final String data = event.getContentIfNotHandled();
                    if (data != null)
                        Snackbar.make(viewDataBinding.getRoot(),
                                data, 1).show();
                });
        viewDataBinding.button.setOnClickListener(v -> {

            if (viewModel.groupId.getValue() == -1)
                viewModel.showSnackBar();
            else
                viewModel.insertSubscribeRss();
        });
        return viewDataBinding.getRoot();
    }

}