package com.youngerhousea.simplereader;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.adapter.ChannelConverterFactory;
import com.youngerhousea.simplereader.adapter.LiveDataCallAdapterFactory;
import com.youngerhousea.simplereader.data.net.api.FetchRss;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RunWith(JUnit4.class)
public class RetrofitTest {
    //    MockWebServer mockWebServer;
    OkHttpClient proxyClient;
    Retrofit proxyRetrofit;
    FetchRss fetchRss;

    @Before
    public void init() {
//        mockWebServer = new MockWebServer();
        proxyClient = new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 7890))).build();
        proxyRetrofit = new Retrofit.Builder().baseUrl("https://rsshub.app/")
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(ChannelConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).client(proxyClient).build();
        fetchRss = proxyRetrofit.create(FetchRss.class);
    }

    @Test
    public void test() throws InterruptedException, IOException {
        Call<ResponseBody> call = fetchRss.getB("https://space.bilibili.com/37946996/video");
        final ResponseBody[] data = new ResponseBody[1];
        final String[] errorMessage = {""};
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                data[0] = response.body();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                errorMessage[0] = t.getMessage();
            }
        });
        Thread.sleep(10000);
        System.out.println(data[0].string());
        System.out.println(errorMessage[0]);
    }

    @Test
    public void test2() throws InterruptedException {
        Call<Channel> call = fetchRss.getA("https://rsshub.app/bilibili/ranking/0/3?limit=10");
        final Channel[] data = new Channel[1];
        final String[] errorMessage = {""};
        call.enqueue(new Callback<Channel>() {
            @Override
            public void onResponse(Call<Channel> call, Response<Channel> response) {
                data[0] = response.body();
            }

            @Override
            public void onFailure(@NotNull Call<Channel> call, @NotNull Throwable t) {
                errorMessage[0] = t.getMessage();
            }
        });
        Thread.sleep(10000);
        System.out.println(data[0]);
        System.out.println(errorMessage[0]);
    }

}
