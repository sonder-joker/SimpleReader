package com.youngerhousea.simplereader.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.youngerhousea.simplereader.R;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {
    protected View view;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        @SuppressWarnings("unchecked")
        Class<V> VType = (Class<V>) ((ParameterizedType) Objects.requireNonNull(getClass()
                .getGenericSuperclass())).getActualTypeArguments()[1];
        viewModel = new ViewModelProvider(requireActivity()).get(VType);
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        view = dataBinding.getRoot();
        dataBinding.setVariable(getBindingViewModel(), viewModel);
        dataBinding.setLifecycleOwner(this);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_nav_host);

        return view;
    }


    public T getDataBinding() {
        return dataBinding;
    }
}
