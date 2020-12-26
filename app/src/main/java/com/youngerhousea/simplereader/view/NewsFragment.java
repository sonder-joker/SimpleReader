
package com.youngerhousea.simplereader.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter;
import com.youngerhousea.simplereader.adapter.RecyclerItemClickListener;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<com.youngerhousea.simplereader.databinding.FragmentNewsBinding, NewsViewModel> {


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
        setHasOptionsMenu(true);
        setRecycleView();
    }

    private void setRecycleView() {
        NewsRecycleViewAdapter adapter = new NewsRecycleViewAdapter();
        viewModel.articleData.observe(getViewLifecycleOwner(), adapter::setItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dataBinding.newsRecycleView.setLayoutManager(layoutManager);
        dataBinding.newsRecycleView.setAdapter(adapter);
        dataBinding.newsRecycleView.addOnItemTouchListener(new RecyclerItemClickListener(this.getContext(), dataBinding.newsRecycleView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NavDirections action = NewsFragmentDirections.actionFragmentNewsToFragmentArticle();
                viewModel.setCurrentPosition(position);
                navController.navigate(action);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_news, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}