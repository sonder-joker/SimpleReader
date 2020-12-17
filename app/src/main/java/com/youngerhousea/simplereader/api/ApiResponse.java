package com.youngerhousea.simplereader.api;


import com.youngerhousea.simplereader.utils.Utils;

import java.io.IOException;

import retrofit2.Response;

public class ApiResponse<T> {

    public ApiResponse<T> create(Response<T> response) {
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null || response.code() == 204) {
                return new ApiResponse.Empty<>();
            } else {
                return new ApiResponse.Success<>(body);
            }
        } else {
            String msg;
            try {
                msg = response.errorBody().string();
            } catch (IOException e) {
                msg = e.getMessage();
            }
            String errorMessage = Utils.isNullOrEmpty(msg) ? response.message() : msg;
            return new ApiResponse.Error<>(Utils.isNotNullOrEmpty(errorMessage) ? errorMessage : "Unknown error");
        }
    }


    public static class Success<T> extends ApiResponse<T> {
        private T body;

        public T getBody() {
            return body;
        }

        public Success(T body) {
            this.body = body;
        }
    }

    public static class Error<T> extends ApiResponse<T> {
        private String errorMessage;

        public Error(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

    public static class Empty<T> extends ApiResponse<T> {

    }
}
