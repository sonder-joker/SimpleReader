package com.youngerhousea.simplereader.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavController;

import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.DataBindingExpandableListAdapter;
import com.youngerhousea.simplereader.data.model.GroupWithRssUrls;
import com.youngerhousea.simplereader.databinding.ItemFragmentRssEditBinding;
import com.youngerhousea.simplereader.databinding.ItemFragmentRssEditSubBinding;
import com.youngerhousea.simplereader.view.collection.RssEditFragmentDirections;

import java.util.List;

public class RssEditAdapter extends DataBindingExpandableListAdapter<ItemFragmentRssEditBinding, ItemFragmentRssEditSubBinding> {
    private List<GroupWithRssUrls> groupWithRssUrlsList;

    public RssEditAdapter(List<GroupWithRssUrls> groupWithRssUrlsList, NavController navController) {
        this.groupWithRssUrlsList = groupWithRssUrlsList;
    }

    public void setGroupWithRssUrlsList(List<GroupWithRssUrls> groupWithRssUrlsList) {
        this.groupWithRssUrlsList = groupWithRssUrlsList;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupLayoutId() {
        return R.layout.item_fragment_rss_edit;
    }

    @Override
    public int getChildLayoutId() {
        return R.layout.item_fragment_rss_edit_sub;
    }

    @Override
    public int getGroupCount() {
        return groupWithRssUrlsList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupWithRssUrlsList.get(groupPosition).getUrls().size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupWithRssUrlsList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupWithRssUrlsList.get(groupPosition).getUrls().get(childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = super.getGroupView(groupPosition, isExpanded, convertView, parent);
        groupDataBinding.setGroup(groupWithRssUrlsList.get(groupPosition).getGroup());

//        groupDataBinding.chip.setOnLongClickListener(v -> {
//            RssEditFragmentDirections.ActionFragmentRssEditToDeleteDialogFragment action = RssEditFragmentDirections.actionFragmentRssEditToDeleteDialogFragment();
//            action.setGroup(groupWithRssUrlsList.get(groupPosition).getGroup());
//            return true;
//        });
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = super.getChildView(groupPosition, childPosition, isLastChild, convertView, parent);
        childDataBinding.setUrl(groupWithRssUrlsList.get(groupPosition).getUrls().get(childPosition));

        childDataBinding.chip.setOnLongClickListener(v -> {
            RssEditFragmentDirections.ActionFragmentRssEditToDialogRssDelete action = RssEditFragmentDirections.actionFragmentRssEditToDialogRssDelete();
            action.setRssUrl(groupWithRssUrlsList.get(groupPosition).getUrls().get(childPosition));
            return true;
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
