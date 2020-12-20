package com.youngerhousea.simplereader;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.net.adapter.ChannelConverterFactory;
import com.youngerhousea.simplereader.net.adapter.LiveDataCallAdapterFactory;
import com.youngerhousea.simplereader.net.api.FetchRss;
import com.youngerhousea.simplereader.repository.base.ApiResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(AndroidJUnit4.class)
public class AndroidRetrofitTest {
    OkHttpClient proxyClient;
    Retrofit proxyRetrofit;
    FetchRss fetchRss;

    @Before
    public void init() {
//        mockWebServer = new MockWebServer();
//        proxyClient = new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890))).build();
        proxyRetrofit = new Retrofit.Builder().baseUrl("https://rsshub.app/")
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(ChannelConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .client(proxyClient)
                .build();
        fetchRss = proxyRetrofit.create(FetchRss.class);
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void test3() {
        LiveData<ApiResponse<Channel>> call = fetchRss.getChannel("https://rsshub.app/bilibili/ranking/0/3?limit=10");
        call.observeForever(new Observer<ApiResponse<Channel>>() {
            @Override
            public void onChanged(ApiResponse<Channel> channelApiResponse) {
                System.out.println(channelApiResponse);
            }
        });
    }
}
