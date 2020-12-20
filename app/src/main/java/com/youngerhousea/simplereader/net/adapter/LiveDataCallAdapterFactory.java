package com.youngerhousea.simplereader.net.adapter;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.repository.base.ApiResponse;

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
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class)
            return null;
        final Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class rawType = getRawType(observableType);
        if (rawType != ApiResponse.class) {
            throw new IllegalArgumentException("type must be ApiResponse");
        }
        if (!(observableType instanceof ParameterizedType)) {
            throw new IllegalArgumentException("resource must be parameterized");
        }

        return new LiveDataCallAdapter<>(observableType);
    }
}
