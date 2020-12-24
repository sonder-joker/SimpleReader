package com.youngerhousea.simplereader.adapter;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.prof.rssparser.Channel;

public class ChannelConverters {
    @TypeConverter
    public static String saveChannel(Channel channel) {
        return new Gson().toJson(channel);
    }

    @TypeConverter
    public static Channel getChannel(String string) {
        return new Gson().fromJson(string, Channel.class);
    }
}
