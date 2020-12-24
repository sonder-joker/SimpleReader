package com.youngerhousea.simplereader;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.prof.rssparser.Channel;
import com.youngerhousea.simplereader.data.dao.AppDatabase;
import com.youngerhousea.simplereader.data.dao.RssDao;
import com.youngerhousea.simplereader.data.model.entity.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndRssUrl;
import com.youngerhousea.simplereader.data.model.entity.RssSource;
import com.youngerhousea.simplereader.adapter.ChannelConverterFactory;
import com.youngerhousea.simplereader.adapter.LiveDataCallAdapterFactory;
import com.youngerhousea.simplereader.data.net.api.FetchRss;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
    void testNewInterface() {

    }

    @After
    public void closeDb() {
        appDatabase.close();
    }

}
