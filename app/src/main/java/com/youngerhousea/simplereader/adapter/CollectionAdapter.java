package com.youngerhousea.simplereader.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.youngerhousea.simplereader.fragment.collection.RssAddFragment;
import com.youngerhousea.simplereader.fragment.collection.RssEditFragment;
import com.youngerhousea.simplereader.fragment.collection.RssSearchFragment;

public class CollectionAdapter extends FragmentStateAdapter {
    public CollectionAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RssAddFragment();
            case 1:
                return new RssSearchFragment();
            default:
                return new RssEditFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
