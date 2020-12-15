package com.youngerhousea.simplereader.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.NewsViewHolder> {

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
