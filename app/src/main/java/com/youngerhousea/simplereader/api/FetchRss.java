package com.youngerhousea.simplereader.api;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FetchRss {
    @GET
    Flowable<String> getRss(@Url String url);
}
