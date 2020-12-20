package com.youngerhousea.simplereader.net.api;



import androidx.lifecycle.LiveData;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.repository.base.ApiResponse;

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
