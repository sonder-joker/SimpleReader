package com.youngerhousea.simplereader.utils;

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

}
