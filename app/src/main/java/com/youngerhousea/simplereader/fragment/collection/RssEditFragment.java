package com.youngerhousea.simplereader.fragment.collection;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.RssEditAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssEditBinding;
import com.youngerhousea.simplereader.viewmodel.RssEditViewModel;

import java.util.ArrayList;

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
        final RssEditAdapter adapter = new RssEditAdapter(new ArrayList<>(), navController);
        dataBinding.fragmentRssEditExpendableListView.setAdapter(adapter);
        viewModel.subscribeRssWithGroups.observe(getViewLifecycleOwner(),
                adapter::setGroupWithRssUrlsList);
    }
}
