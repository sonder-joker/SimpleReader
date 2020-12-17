package com.youngerhousea.simplereader.base;

import org.jetbrains.annotations.NotNull;

public class Resource<T> {
    private T data;
    private String message;

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public Resource(T data) {
        this.data = data;
    }

    public static class Success<T> extends Resource<T> {
        public Success(@NotNull T data) {
            super(data);
        }
    }

    public static class Loading<T> extends Resource<T> {
        public Loading(T data) {
            super(data);
        }
    }

    public static class Error<T> extends Resource<T> {
        public Error(T data, String message) {
            super(data, message);
        }
    }
}
