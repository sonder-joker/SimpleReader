
package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding, NewsViewModel> {
    NewsRecycleViewAdapter adapter = new NewsRecycleViewAdapter(new ArrayList<>());

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
        NavController navController = Navigation.findNavController(view);
        AppBarConfiguration appBarConfiguration =
                new AppBarConfiguration.Builder(navController.getGraph()).build();


        dataBinding.fragmentToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_refresh: {
                    //Todo:refresh
                    return true;
                }
                case R.id.action_sort: {
                    //Todo:sort
                    return true;
                }
                case R.id.action_downland: {
                    //todo:downland
                    return true;
                }
                default:
                    return super.onContextItemSelected(item);
            }
        });
        NavigationUI.setupWithNavController(dataBinding.fragmentNewsCollapsingToolbarLayout,
                dataBinding.fragmentToolbar, navController, appBarConfiguration);

    }

    private void setRecycleView() {

        viewModel.data.observe(getViewLifecycleOwner(), resources -> {
            adapter.setItemList(resources);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dataBinding.newsRecycleView.setLayoutManager(layoutManager);
        dataBinding.newsRecycleView.setAdapter(adapter);
    }


}