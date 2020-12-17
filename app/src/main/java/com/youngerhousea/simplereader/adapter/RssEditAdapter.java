package com.youngerhousea.simplereader.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;
import com.youngerhousea.simplereader.databinding.FragmentRssEditItemBinding;
import com.youngerhousea.simplereader.databinding.FragmentRssEditSubItemBinding;

import java.util.List;

public class RssEditAdapter extends DataBindingExpandableListAdapter<FragmentRssEditItemBinding, FragmentRssEditSubItemBinding> {
    private final List<GroupWithSubscribeRss> groupWithSubscribeRssList;

    public RssEditAdapter(List<GroupWithSubscribeRss> groupWithSubscribeRssList) {
        this.groupWithSubscribeRssList = groupWithSubscribeRssList;
    }

    @Override
    public int getGroupLayoutId() {
        return R.layout.fragment_rss_edit_item;
    }

    @Override
    public int getChildLayoutId() {
        return R.layout.fragment_rss_edit_sub_item;
    }

    @Override
    public int getGroupCount() {
        return groupWithSubscribeRssList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupWithSubscribeRssList.get(groupPosition).getUrls().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupWithSubscribeRssList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupWithSubscribeRssList.get(groupPosition).getUrls().get(childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = super.getGroupView(groupPosition, isExpanded, convertView, parent);
        groupDataBinding.setGroup(groupWithSubscribeRssList.get(groupPosition).getGroup());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = super.getChildView(groupPosition, childPosition, isLastChild, convertView, parent);
        childDataBinding.setUrl(groupWithSubscribeRssList.get(groupPosition).getUrls().get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
