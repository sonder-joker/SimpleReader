package com.youngerhousea.simplereader.adapter;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.youngerhousea.simplereader.BR;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;

    public MyViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Object obj) {
//        binding.setVariable(BR.obj, obj);
        binding.executePendingBindings();
    }
}
