package com.youngerhousea.simplereader.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<T extends ViewDataBinding, R> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<R> data;
    protected T dataBinding;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingViewModel();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        dataBinding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), parent, false);
        return new BaseViewHolder<R>(dataBinding);
    }

    public static class BaseViewHolder<R> extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
        }
    }
}
