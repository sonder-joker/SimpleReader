package com.youngerhousea.simplereader;


import android.os.Bundle;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.youngerhousea.simplereader.base.BaseActivity;
import com.youngerhousea.simplereader.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(dataBinding.fragmentToolbar);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(dataBinding.drawerLayout)
                .build();

        NavigationUI.setupWithNavController(dataBinding.fragmentNewsCollapsingToolbarLayout, dataBinding.fragmentToolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(dataBinding.drawerNav, navController);

    }
}