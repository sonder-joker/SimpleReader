package com.youngerhousea.simplereader.repository.base;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import com.youngerhousea.simplereader.AppExecutors;


public abstract class NetworkBoundResource<ResultType, RequestType> {
    private final MediatorLiveData<Resource<ResultType>> result = new MediatorLiveData<>();
    private AppExecutors appExecutors;

    /**
     * ResultType: Type for the Resource data<br>
     * RequestType: Type for the API response.
     */
    @MainThread
    public NetworkBoundResource(AppExecutors executors) {
        this.appExecutors = executors;

        result.setValue(Resource.loading(null));
        LiveData<ResultType> dbSource = loadFromDb();
        result.addSource(dbSource, data -> {
            result.removeSource(dbSource);
            if (shouldFetchData(data)) {
                fetchFromNetwork(dbSource);
            } else {
                result.addSource(dbSource, newData -> {
                    setValue(Resource.success(newData));
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
                setValue(Resource.loading(newData))
        );
        result.addSource(apiResponse,
                response -> {
                    result.removeSource(apiResponse);
                    result.removeSource(dbSource);
                    if (response instanceof ApiResponse.Success) {
                       appExecutors.getDiskIO().execute(() -> {
                           saveCallResult(processResponse((ApiResponse.Success<RequestType>) response));
                           appExecutors.getMainThread().execute(() -> {
                               result.addSource(loadFromDb(), newData -> {
                                   setValue(Resource.success(newData));
                               });
                           });
                       });
                    } else if (response instanceof ApiResponse.Empty) {
                        appExecutors.getMainThread().execute(() -> result.addSource(loadFromDb(), newData -> {
                            setValue(Resource.success(newData));
                        }));
                    } else if (response instanceof ApiResponse.Error) {
                        onFetchedFailed();
                        result.addSource(dbSource, newData -> {
                            setValue(Resource.error(((ApiResponse.Error<RequestType>) response).getErrorMessage(), newData));
                        });
                    }
                });
    }

    protected void onFetchedFailed() {

    }

    public LiveData<Resource<ResultType>> asLiveData() {
        return result;
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

