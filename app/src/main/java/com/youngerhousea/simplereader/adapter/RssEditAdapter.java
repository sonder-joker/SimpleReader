package com.youngerhousea.simplereader.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;

import java.util.List;

public class RssEditAdapter extends RecyclerView.Adapter<RssEditAdapter.ViewHolder> {
    private List<GroupWithSubscribeRss> groupWithSubscribeRsses;

    public RssEditAdapter(List<GroupWithSubscribeRss> groupWithSubscribeRsses) {
        this.groupWithSubscribeRsses = groupWithSubscribeRsses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_rss_edit_group_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chip chip = holder.constraintLayout.findViewById(R.id.chip);
        chip.setText(groupWithSubscribeRsses.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return groupWithSubscribeRsses.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = (ConstraintLayout) itemView;
        }
    }
}
