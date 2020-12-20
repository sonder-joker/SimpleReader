package com.youngerhousea.simplereader.fragment.collection;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssSearchBinding;
import com.youngerhousea.simplereader.viewmodel.RssSearchViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssSearchFragment extends BaseFragment<FragmentRssSearchBinding, RssSearchViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.rssSearchViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rss_search;
    }
}
