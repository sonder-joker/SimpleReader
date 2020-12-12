package com.youngerhousea.simplereader.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.youngerhousea.simplereader.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {
    protected T viewDataBinding;

    protected V viewModel;

    protected NavController navController;
    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);

        @SuppressWarnings("unchecked")
        Class<V> VType = (Class<V>) ((ParameterizedType) Objects.requireNonNull(getClass()
                .getGenericSuperclass())).getActualTypeArguments()[1];
        viewModel = new ViewModelProvider(requireActivity()).get(VType);
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);

        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.setLifecycleOwner(this);
        navController = Navigation.findNavController(view);
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }
}
