package com.youngerhousea.simplereader.view.collection;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.adapter.CollectionAdapter;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentCollectionBinding;
import com.youngerhousea.simplereader.viewmodel.CollectionViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CollectionFragment extends BaseFragment<FragmentCollectionBinding, CollectionViewModel> {
    @Override
    public int getBindingViewModel() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_collection;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTabLayout();
        setHasOptionsMenu(true);
    }

    private void setTabLayout() {
        CollectionAdapter adapter = new CollectionAdapter(this);
        dataBinding.fragmentCollectionViewpager.setAdapter(adapter);

        new TabLayoutMediator(dataBinding.fragmentCollectionTabLayout, dataBinding.fragmentCollectionViewpager,
                (TabLayout.Tab tab, int position) -> {
                    String value;
                    switch (position) {
                        case 0:
                            value = getString(R.string.fragment_collection_page_rss_add);
                            break;
                        case 1:
                            value = getString(R.string.fragment_collection_page_rss_search);
                            break;
                        default:
                            value = getString(R.string.fragment_collection_page_rss_edit);
                            break;
                    }
                    tab.setText(value);
                }).attach();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_collection, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_export) {
            return true;
        } else if (itemId == R.id.dialog_rss_add) {
            NavDirections action = CollectionFragmentDirections.actionFragmentCollectionToDialogFragmentAddGroup();
            navController.navigate(action);
        }
        return super.onOptionsItemSelected(item);
    }
}
