package com.youngerhousea.simplereader.utils;

import com.prof.rssparser.Channel;
import com.prof.rssparser.OnTaskCompleted;
import com.prof.rssparser.Parser;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

import lombok.SneakyThrows;

public class Utils {
    public static boolean isNullOrEmpty(String data) {
        return data == null || data.equals("");
    }

    public static boolean isNotNullOrEmpty(String data) {
        return !isNullOrEmpty(data);
    }

    public static boolean isNullOrEmpty(Integer data) {
        return data == null;
    }

    public static boolean isNotNullOrEmpty(Integer data) {
        return !isNullOrEmpty(data);
    }

    @SneakyThrows
    public static Channel parse(String rss) {
        Parser parser = new Parser.Builder().build();
        final Channel[] channelArray = {new Channel()};
        parser.parse(rss, new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(@NotNull Channel channel) {
                channelArray[0] = channel;
            }

            @Override
            public void onError(@NotNull Exception e) {
                channelArray[0] = null;
            }
        });
        return channelArray[0];
    }

    @SuppressWarnings("rawtypes")
    public static Class getGenericType(Class genericClass, int place) {
        return (Class) ((ParameterizedType) Objects.requireNonNull(genericClass
                .getGenericSuperclass())).getActualTypeArguments()[place];
    }


    @SuppressWarnings("rawtypes")
    public static Class getGenericType(Class genericClass) {
        return (Class) ((ParameterizedType) Objects.requireNonNull(genericClass
                .getGenericSuperclass())).getActualTypeArguments()[0];
    }


}
