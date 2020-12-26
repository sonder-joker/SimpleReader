package com.youngerhousea.simplereader.base;

import com.youngerhousea.simplereader.R;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public Status getStatus() {
        return status;
    }

    private Resource(Status status, T data, String message) {
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

    public <R> Resource<R> map(Function<T, R> function) {
        return new Resource<>(this.status, function.apply(data), this.message);
    }

    public <R> List<Resource<R>> flatMap(Function<T, List<R>> function) {
        return function.apply(data).stream().map(new Function<R, Resource<R>>() {
            @Override
            public Resource<R> apply(R r) {
                return new Resource<>(Resource.this.status, r, Resource.this.message);
            }
        }).collect(Collectors.toList());
    }
}
