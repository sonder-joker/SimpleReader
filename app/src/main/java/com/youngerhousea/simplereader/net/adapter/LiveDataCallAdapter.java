package com.youngerhousea.simplereader.net.adapter;

import androidx.lifecycle.LiveData;

import com.youngerhousea.simplereader.repository.base.ApiResponse;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<T> implements CallAdapter<T, LiveData<ApiResponse<T>>> {

    private final Type responseType;

    public LiveDataCallAdapter(Type observableType) {
        this.responseType = observableType;
    }

    @Override
    public @NotNull Type responseType() {
        return responseType;
    }

    @Override
    public @NotNull LiveData<ApiResponse<T>> adapt(@NotNull Call<T> call) {
        return new LiveData<ApiResponse<T>>() {
            private final AtomicBoolean started = new AtomicBoolean(false);
            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<T>() {
                        @Override
                        public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
                            ApiResponse<T> apiResponse = ApiResponse.create(response);
                            postValue(apiResponse);
                        }

                        @Override
                        public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                            ApiResponse<T> apiResponse = ApiResponse.create(t);
                            postValue(apiResponse);
                        }
                    });
                }
            }
        };
    }
}
