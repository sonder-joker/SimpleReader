package com.youngerhousea.simplereader.fragment;

import androidx.databinding.library.baseAdapters.BR;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentMeBinding;
import com.youngerhousea.simplereader.viewmodel.MeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MeFragment extends BaseFragment<FragmentMeBinding, MeViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.meViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

}