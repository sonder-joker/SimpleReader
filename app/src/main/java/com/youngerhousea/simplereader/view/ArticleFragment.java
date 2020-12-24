package com.youngerhousea.simplereader.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentArticleBinding;
import com.youngerhousea.simplereader.viewmodel.ArticleViewModel;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ArticleFragment extends BaseFragment<FragmentArticleBinding, NewsViewModel> {

    @Override
    public int getBindingViewModel() {
        return BR.newsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_article;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}