package com.youngerhousea.simplereader.base;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.youngerhousea.simplereader.R;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseDialogFragment<T extends ViewDataBinding, V extends BaseViewModel> extends DialogFragment {

    protected T dataBinding;

    protected V viewModel;

    protected View view;

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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        @SuppressWarnings("unchecked")
        Class<V> VType = (Class<V>) ((ParameterizedType) Objects.requireNonNull(getClass()
                .getGenericSuperclass())).getActualTypeArguments()[1];
        viewModel = new ViewModelProvider(requireActivity()).get(VType);
        dataBinding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()), getLayoutId(), null, false);
        view = dataBinding.getRoot();
        dataBinding.setVariable(getBindingViewModel(), viewModel);
        dataBinding.setLifecycleOwner(this);
        navController = Navigation.findNavController(requireActivity(), R.id.fragment_nav_host);


        return super.onCreateDialog(savedInstanceState);
    }
}
