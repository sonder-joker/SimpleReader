package com.youngerhousea.simplereader.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.prof.rssparser.Article;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.databinding.ItemFragmentNewsBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> {

    private final AsyncListDiffer<Article> differ = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    public NewsRecycleViewAdapter() {
    }

    public void setItemList(List<Article> itemList) {
        differ.submitList(itemList);
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
        Article item = differ.getCurrentList().get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        private final ItemFragmentNewsBinding binding;

        public NewsViewHolder(@NonNull ItemFragmentNewsBinding dataBinding) {
            super(dataBinding.getRoot());
            this.binding = dataBinding;
        }

        public void bind(Article article) {
            binding.setResource(article);
        }
    }


    public static final DiffUtil.ItemCallback<Article> DIFF_CALLBACK = new DiffUtil.ItemCallback<Article>() {
        @Override
        public boolean areItemsTheSame(@NotNull Article oldItem, @NotNull Article newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NotNull Article oldItem, @NotNull Article newItem) {
            return oldItem.equals(newItem);
        }
    };
}
