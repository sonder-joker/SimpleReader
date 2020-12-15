package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
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
    private RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public int getBindingViewModel() {
        return BR.newsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
//        dataBinding.fragmentNewsToolbar.inflateMenu(R.menu.menu_news);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        dataBinding.fragmentNewsToolbar.setTitle(R.string.fragment_news_title);
//        dataBinding.fragmentNewsToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.action_sort) {
//                    Log.e("TAG", "onMenuItemClick: e" );
//                    return true;
//                } else if (id == R.id.action_downland) {
//                    return true;
//                } else if (id == R.id.action_refresh) {
//                    return true;
//                }
//                return false;
//            }
//        });

        layoutManager = new LinearLayoutManager(getContext());
        dataBinding.newsRecycleView.setLayoutManager(layoutManager);

        adapter = new NewsRecycleViewAdapter();
        dataBinding.newsRecycleView.setAdapter(adapter);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(dataBinding.fragmentNewsCollapsingToolbarLayout, dataBinding.fragmentNewsToolbar, navController, appBarConfiguration);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_news, menu);
    }


}