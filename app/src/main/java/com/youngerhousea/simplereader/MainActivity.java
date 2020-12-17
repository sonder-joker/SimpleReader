package com.youngerhousea.simplereader;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.youngerhousea.simplereader.base.BaseActivity;
import com.youngerhousea.simplereader.databinding.ActivityMainBinding;
import com.youngerhousea.simplereader.viewmodel.MainViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private AppBarConfiguration drawerConfiguration;

    @Override
    public int getBindingViewModel() {
        return BR.mainViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        drawerConfiguration =
                new AppBarConfiguration.Builder()
                        .setOpenableLayout(dataBinding.drawerLayout)
                        .build();

        NavigationUI.setupWithNavController(dataBinding.drawerNav, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, drawerConfiguration) || super.onSupportNavigateUp();
    }

}