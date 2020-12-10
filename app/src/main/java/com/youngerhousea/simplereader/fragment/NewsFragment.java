package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.library.baseAdapters.BR;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentNewsBinding;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding, NewsViewModel> {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> madapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public int getBindingVariable() {
        return BR.newsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        recyclerView = viewDataBinding.newsRecycleView;

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        madapter = new NewsRecycleViewAdapter();
        recyclerView.setAdapter(madapter);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(viewDataBinding.collapsingToolbarLayout , viewDataBinding.toolbar, navController, appBarConfiguration);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        ;
        super.onCreateOptionsMenu(menu, inflater);

    }

}