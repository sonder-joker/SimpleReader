package com.youngerhousea.simplereader.fragment.collection;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

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
                            value = "ADD";
                            break;
                        case 1:
                            value = "SEARCH";
                            break;
                        default:
                            value = "EDIT";
                            break;
                    }
                    tab.setText(value);
                }).attach();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_layout_collection, menu);
    }


}
