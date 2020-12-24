
package com.youngerhousea.simplereader.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prof.rssparser.Article;
import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.NewsRecycleViewAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.base.Resource;
import com.youngerhousea.simplereader.base.Status;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.databinding.FragmentNewsBinding;
import com.youngerhousea.simplereader.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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

        setHasOptionsMenu(true);
        setRecycleView();

    }

    private void setRecycleView() {

        viewModel.data.observe(getViewLifecycleOwner(), (List<Resource<RssSource>> resources) -> {
            final boolean[] status = {true};
            resources.forEach(new Consumer<Resource<RssSource>>() {
                @Override
                public void accept(Resource<RssSource> rssSourceResource) {
                    if (rssSourceResource.getStatus() != Status.SUCCESS) {
                        status[0] = false;
                    }
                }
            });

            List<Article> data = resources.stream().flatMap( (Resource<RssSource> rssSourceResource) -> {
                return rssSourceResource.getData().getChannel().getArticles().stream();
            }).collect(Collectors.toList());
            adapter.setItemList(resources);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        dataBinding.newsRecycleView.setLayoutManager(layoutManager);
        dataBinding.newsRecycleView.setAdapter(adapter);
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