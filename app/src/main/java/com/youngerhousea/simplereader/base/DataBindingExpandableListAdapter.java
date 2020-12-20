package com.youngerhousea.simplereader.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class DataBindingExpandableListAdapter<GroupDataBinding extends ViewDataBinding, ChildDataBinding extends ViewDataBinding> extends BaseExpandableListAdapter {
    protected GroupDataBinding groupDataBinding;

    protected ChildDataBinding childDataBinding;

    /**
     * @return layout group resource id
     */
    public abstract
    @LayoutRes
    int getGroupLayoutId();

    /**
     * @return layout child resource id
     */
    public abstract
    @LayoutRes
    int getChildLayoutId();

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            groupDataBinding = DataBindingUtil.inflate(layoutInflater, getGroupLayoutId(), parent, false);
            convertView = groupDataBinding.getRoot();
        } else {
            groupDataBinding = (GroupDataBinding) convertView.getTag();
        }
        convertView.setTag(groupDataBinding);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (convertView == null) {
            childDataBinding = DataBindingUtil.inflate(layoutInflater, getChildLayoutId(), parent, false);
            convertView = childDataBinding.getRoot();
        } else {
            childDataBinding = (ChildDataBinding) convertView.getTag();
        }
        convertView.setTag(childDataBinding);
        return convertView;
    }
}
