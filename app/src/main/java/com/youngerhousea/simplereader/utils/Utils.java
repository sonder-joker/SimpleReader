package com.youngerhousea.simplereader.utils;

public class Utils {
    public static boolean isEmpty(String data) {
        return data == null || data.equals("");
    }

    public static boolean isNotEmpty(String data) {
        return !isEmpty(data);
    }

    public static boolean isEmpty(Integer data) {
        return data == null;
    }

    public static boolean isNotEmpty(Integer data) {
        return !isEmpty(data);
    }

}
