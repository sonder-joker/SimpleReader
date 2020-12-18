package com.youngerhousea.simplereader.api;

import com.youngerhousea.simplereader.api.xml.TheRss;

import io.reactivex.rxjava3.core.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface FetchRss {
    @GET
    Flowable<TheRss> getRss(@Url String url);
}
