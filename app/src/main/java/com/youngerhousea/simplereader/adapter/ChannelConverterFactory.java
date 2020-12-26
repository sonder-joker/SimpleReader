package com.youngerhousea.simplereader.adapter;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.utils.Utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class ChannelConverterFactory extends Converter.Factory {
    public static ChannelConverterFactory create() {
        return new ChannelConverterFactory();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(@NotNull Type type, @NotNull Annotation[] annotations, @NotNull Retrofit retrofit) {
        if (Channel.class.equals(type)) {
            return new Converter<ResponseBody, Channel>() {
                @Nullable
                @Override
                public Channel convert(@NotNull ResponseBody value) throws IOException {
                    return Utils.parse(value.string());
                }
            };
        }
        return null;
    }

}
