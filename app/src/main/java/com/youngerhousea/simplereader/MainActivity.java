package com.youngerhousea.simplereader;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.youngerhousea.simplereader.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private AppBarConfiguration bottomBarConfiguration;
    private AppBarConfiguration drawerConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setLifecycleOwner(this);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_nav_host);
        NavController navController = navHostFragment.getNavController();

        bottomBarConfiguration = new AppBarConfiguration.Builder(R.id.fragment_news, R.id.fragment_me).build();
        NavigationUI.setupWithNavController(binding.bottomNav, navController);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerConfiguration =
                new AppBarConfiguration.Builder()
                        .setOpenableLayout(drawerLayout)
                        .build();
        NavigationUI.setupWithNavController(binding.drawerNav, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            final int id = destination.getId();
            if(id == R.id.fragment_news || id == R.id.fragment_me) {
                binding.bottomNav.setVisibility(View.VISIBLE);
            } else
                binding.bottomNav.setVisibility(View.GONE);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment_nav_host);
        return NavigationUI.navigateUp(navController, drawerConfiguration) || NavigationUI.navigateUp(navController, bottomBarConfiguration)
                || super.onSupportNavigateUp();
    }

}