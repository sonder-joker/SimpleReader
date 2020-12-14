package com.youngerhousea.simplereader.fragment;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
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

}
