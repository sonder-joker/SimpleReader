package com.youngerhousea.simplereader.adapter;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.base.ApiResponse;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    public static LiveDataCallAdapterFactory create() {
        return new LiveDataCallAdapterFactory();
    }

    @Nullable
    @Override
    public CallAdapter<?, ?> get(@NotNull Type returnType, Annotation[] annotations, @NotNull Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class)
            return null;

        final Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);

        if (getRawType(observableType) != ApiResponse.class) {
            throw new IllegalArgumentException("type must be ApiResponse");
        }

        if (!(observableType instanceof ParameterizedType)) {
            throw new IllegalArgumentException("resource must be parameterized");
        }
        Type rawT = getParameterUpperBound(0, (ParameterizedType) observableType);

        return new LiveDataCallAdapter<>( rawT);
    }
}
