package com.youngerhousea.simplereader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.databinding.ItemFragmentNewsBinding;
import com.youngerhousea.simplereader.fragment.NewsFragmentDirections;
import com.youngerhousea.simplereader.repository.base.Resource;
import com.youngerhousea.simplereader.repository.base.Status;

import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> {
    private List<Resource<RssSource>> itemList;

    public NewsRecycleViewAdapter(List<Resource<RssSource>> strings) {
        this.itemList = strings;
    }

    public void setItemList(List<Resource<RssSource>> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemFragmentNewsBinding item = DataBindingUtil.inflate(layoutInflater, getGroupLayoutId(), parent, false);
        return new NewsViewHolder(item);
    }

    @LayoutRes
    private int getGroupLayoutId() {
        return R.layout.item_fragment_news;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Resource<RssSource> resource = itemList.get(position);

        holder.binding.setResource(resource);

        holder.binding.executePendingBindings();
        holder.binding.chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = NewsFragmentDirections.actionFragmentNewsToFragmentArticle();
                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private final ItemFragmentNewsBinding binding;

        public NewsViewHolder(@NonNull ItemFragmentNewsBinding dataBinding) {
            super(dataBinding.getRoot());
            this.binding = dataBinding;
        }
    }
}
