package com.youngerhousea.simplereader.repository;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.youngerhousea.simplereader.api.ApiResponse;
import com.youngerhousea.simplereader.base.Resource;

public abstract class NetworkBoundResource<ResultType, RequestType> {
    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();

    public NetworkBoundResource() {
        result.setValue(new Resource.Loading<>(null));
        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (shouldFetchData(data)) {
                fetchFromNetwork(dbSource);
            } else {
                result.addSource(dbSource, newData -> {
                    setValue(new Resource.Success<>(newData));
                });
            }
        });
    }

    private void setValue(Resource<ResultType> newValue) {
        if (result.getValue() != newValue) {
            result.setValue(newValue);
        }
    }

    private void fetchFromNetwork(LiveData<ResultType> dbSource) {
        LiveData<ApiResponse<RequestType>> apiResponse = createCall();
        result.addSource(dbSource, newData ->
                setValue(new Resource.Loading<>(newData))
        );
        result.addSource(apiResponse,
                response -> {
                    result.removeSource(apiResponse);
                    result.removeSource(dbSource);
                    if (response instanceof ApiResponse.Success) {
                        saveCallResult(processResponse((ApiResponse.Success<RequestType>) response));
                        result.addSource(loadFromDb(), result -> {
                            setValue(result);
                        });
                    } else if (response instanceof ApiResponse.Empty) {

                    } else if (response instanceof ApiResponse.Error) {

                    }
                });


    }

    protected void onFetchedFailed() {

    }

    protected LiveData<Resource<ResultType>> asLiveData() {
        return (LiveData<Resource<ResultType>>) result;
    }

    @WorkerThread
    protected RequestType processResponse(ApiResponse.Success<RequestType> response) {
        return response.getBody();
    }

    @WorkerThread
    protected abstract void saveCallResult(RequestType item);

    @MainThread
    protected abstract boolean shouldFetchData(ResultType data);

    @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    @MainThread
    protected abstract LiveData<ApiResponse<RequestType>> createCall();
}

