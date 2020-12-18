package com.youngerhousea.simplereader.base;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Resource<T> {
    private Status status;
    private T data;
    private String message;

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Resource(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }
    public static <T> Resource<T> error(String message, T data) {
        return new Resource<>(Status.ERROR, data, message);
    }
    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null);
    }

}
