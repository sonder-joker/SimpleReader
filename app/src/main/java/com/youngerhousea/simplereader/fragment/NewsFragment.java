
package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.Observer;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentNewsBinding;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import static com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter.*;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding, NewsViewModel> {
    AppBarConfiguration appBarConfiguration;
    RecyclerView.Adapter<NewsViewHolder> adapter;

    @Override
    public int getBindingViewModel() {
        return BR.newsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setToolbar();
        setRecycleView();
    }

    private void setToolbar() {
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupWithNavController(dataBinding.fragmentNewsCollapsingToolbarLayout, dataBinding.fragmentToolbar, navController, appBarConfiguration);
    }

    private void setRecycleView() {
        viewModel.subscribeRssList.observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> urlList) {
                adapter = new NewsRecycleViewAdapter(urlList);
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dataBinding.newsRecycleView.setLayoutManager(layoutManager);

        dataBinding.newsRecycleView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item);
    }
}