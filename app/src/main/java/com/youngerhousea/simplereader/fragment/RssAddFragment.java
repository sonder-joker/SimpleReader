package com.youngerhousea.simplereader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.snackbar.Snackbar;
import com.youngerhousea.simplereader.BR;
import com.youngerhousea.simplereader.R;
import com.youngerhousea.simplereader.base.BaseFragment;
import com.youngerhousea.simplereader.databinding.FragmentRssAddBinding;
import com.youngerhousea.simplereader.viewmodel.RssAddViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RssAddFragment extends BaseFragment<FragmentRssAddBinding, RssAddViewModel> {

    @Override
    public int getBindingVariable() {
        return BR.rssAddViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rss_add;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        viewModel.snackBarIsExist.observe(getViewLifecycleOwner(),
                event -> {
                    final String data = event.getContentIfNotHandled();
                    if (data != null)
                        Snackbar.make(viewDataBinding.getRoot(),
                                data, 1).show();
                });

        viewDataBinding.button.setOnClickListener(v -> {
            if (viewModel.groupId.getValue() == -1)
                viewModel.showSnackBar();
            else
                viewModel.insertSubscribeRss();
        });

        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.menu.menu_layout_rss_add).build();
        viewDataBinding.toolbar.inflateMenu(R.menu.menu_layout_rss_add);

        viewDataBinding.toolbar.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.action_add_group) {
                NavDirections action =
                        RssAddFragmentDirections.actionRssAddFragmentToAddGroupDialogFragment();
                Navigation.findNavController(view).navigate(action);
                return true;
            } else if (itemId == R.id.action_export) {
                //TODO:
                return true;
            } else if (itemId == R.id.action_import)
                return false;

            return false;
        });
        NavigationUI.setupWithNavController(viewDataBinding.toolbar, navController, appBarConfiguration);
    }


}