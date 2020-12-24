package com.youngerhousea.simplereader.net.api;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.repository.base.ApiResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FetchRss {
    @GET
    Channel get(@Url String url);

    @GET
    Call<Channel> getA(@Url String url);

    @GET
    Call<ResponseBody> getB(@Url String url);

    @GET
    LiveData<ApiResponse<Channel>> getChannel(@Url String url);



}
