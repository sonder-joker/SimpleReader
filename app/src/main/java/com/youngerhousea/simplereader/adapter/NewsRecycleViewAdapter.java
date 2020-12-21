package com.youngerhousea.simplereader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.databinding.ItemFragmentNewsBinding;

import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> {
    private final List<String> itemList;

    public NewsRecycleViewAdapter(List<String> strings) {
        this.itemList = strings;
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
        String url = itemList.get(position);
        holder.binding.setUrl(url);
        holder.binding.executePendingBindings();
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
