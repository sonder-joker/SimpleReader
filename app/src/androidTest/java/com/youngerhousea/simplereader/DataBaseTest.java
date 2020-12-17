package com.youngerhousea.simplereader;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.youngerhousea.simplereader.data.AppDatabase;
import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    private SubscribeRssDao subscribeRssDao;
    private AppDatabase appDatabase;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        subscribeRssDao = appDatabase.getSubscribeRssDao();
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    @Test
    public void writeUserAndReadInList() throws Exception {
        GroupIdAndUrl subscribeRss = new GroupIdAndUrl(1, "test1");
        Group group = new Group("test1");

        subscribeRssDao.insertGroup(group)
                .test()
                .assertComplete();

        subscribeRssDao.insertSubscribeRss(subscribeRss)
                .test()
                .assertComplete();

        subscribeRssDao.getAllGroup().observeForever(new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                assertEquals(strings.get(0), "test1");
            }
        });

    }


    @After
    public void closeDb() throws IOException {
        appDatabase.close();
    }

}
