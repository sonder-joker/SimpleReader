package com.youngerhousea.simplereader.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.youngerhousea.simplereader.R;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    protected T dataBinding;

    protected V viewModel;

    protected NavController navController;


    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingViewModel();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        dataBinding.setVariable(getBindingViewModel(), viewModel);
        dataBinding.setLifecycleOwner(this);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_nav_host);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }

}