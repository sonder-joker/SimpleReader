package com.youngerhousea.simplereader.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.youngerhousea.simplereader.viewmodel.BaseViewModel;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity {

    private T viewDataBinding;

    protected V viewModel;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @SuppressWarnings("unchecked")
        Class<V> VType = (Class<V>) ((ParameterizedType) Objects.requireNonNull(getClass()
                .getGenericSuperclass())).getActualTypeArguments()[1];
        performDataBinding();
    }

    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
    }
}