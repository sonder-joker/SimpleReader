package com.youngerhousea.simplereader.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NewViewHolder extends RecyclerView.ViewHolder {


        public NewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
