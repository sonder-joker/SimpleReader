package com.youngerhousea.simplereader.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.youngerhousea.simplereader.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseDialogFragment<T extends BaseViewModel> extends DialogFragment {

    protected T viewModel;

    protected NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressWarnings("unchecked")
        Class<T> TType = (Class<T>) ((ParameterizedType) Objects.requireNonNull(getClass()
                .getGenericSuperclass())).getActualTypeArguments()[0];
        viewModel = new ViewModelProvider(requireActivity()).get(TType);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

}
