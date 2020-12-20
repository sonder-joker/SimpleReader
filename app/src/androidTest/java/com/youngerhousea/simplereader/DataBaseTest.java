package com.youngerhousea.simplereader;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.AppDatabase;
import com.youngerhousea.simplereader.data.RssDao;
import com.youngerhousea.simplereader.data.model.RssUrlAndRssSource;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.data.model.entity.RssUrl;
import com.youngerhousea.simplereader.net.adapter.ChannelConverterFactory;
import com.youngerhousea.simplereader.net.adapter.LiveDataCallAdapterFactory;
import com.youngerhousea.simplereader.net.api.FetchRss;
import com.youngerhousea.simplereader.repository.base.ApiResponse;
import com.youngerhousea.simplereader.repository.base.NetworkBoundResource;
import com.youngerhousea.simplereader.repository.base.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    private RssDao rssDao;
    private AppDatabase appDatabase;
    Retrofit proxyRetrofit;
    FetchRss fetchRss;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        rssDao = appDatabase.getSubscribeRssDao();

        proxyRetrofit = new Retrofit.Builder().baseUrl("https://rsshub.app/")
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(ChannelConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        fetchRss = proxyRetrofit.create(FetchRss.class);
    }

    @Before
    public void addData() {
        GroupIdAndRssUrl subscribeRss = new GroupIdAndRssUrl(1, "test1");
        Group group = new Group("test1");
        RssSource rssSource = new RssSource(1, new Channel());

        rssDao.insertGroup(group)
                .test()
                .assertComplete();

        rssDao.insertRssUrl(subscribeRss)
                .test()
                .assertComplete();
        rssDao.insertRssSource(rssSource);

    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    @Test
    public void writeUserAndReadInList() throws Exception {

        rssDao.getAllGroup().observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                assertEquals(strings.get(0), "test1");
            }
        });

    }

    @Test
    public void testRssSource() throws InterruptedException {
        RssUrl rssUrl = new RssUrl(1, "test1");
        new NetworkBoundResource<Channel, Channel>() {
            @Override
            protected void saveCallResult(Channel item) {
                rssDao.insertRssSource(new RssSource(rssUrl.getRssUrlId(), item));
            }

            @Override
            protected boolean shouldFetchData(Channel data) {
                return data == null /*|| time > setting*/;
            }

            @Override
            protected LiveData<Channel> loadFromDb() {
                return Transformations.map(rssDao.getRssSource(rssUrl.getUrl()), RssUrlAndRssSource::getChannel);
            }

            @Override
            protected LiveData<ApiResponse<Channel>> createCall() {
                return fetchRss.getChannel(rssUrl.getUrl());
            }
        }.asLiveData().observeForever(new Observer<Resource<Channel>>() {
            @Override
            public void onChanged(Resource<Channel> channelResource) {
                System.out.println(channelResource);
            }
        });
        Thread.sleep(10000);
    }


    @After
    public void closeDb() throws IOException {
        appDatabase.close();
    }

}
