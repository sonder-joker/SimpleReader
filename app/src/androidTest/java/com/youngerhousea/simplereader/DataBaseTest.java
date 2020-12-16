package com.youngerhousea.simplereader;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.youngerhousea.simplereader.data.AppDatabase;
import com.youngerhousea.simplereader.data.SubscribeRssDao;
import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.GroupIdAndUrl;
import com.youngerhousea.simplereader.data.model.GroupWithSubscribeRss;
import com.youngerhousea.simplereader.data.model.SubscribeRss;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsAnything;
import org.hamcrest.core.IsEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static androidx.test.espresso.matcher.ViewMatchers.assertThat;


@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    private SubscribeRssDao subscribeRssDao;
    private AppDatabase appDatabase;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        subscribeRssDao = appDatabase.getSubscribeRssDao();
    }

    @After
    public void closeDb() throws IOException {
        appDatabase.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        for (int i = 1; i < 100; ++i) {
            SubscribeRss subscribeRss = TestUtil.createSubscribeRss(i);
            Group group = TestUtil.createGroup();
            subscribeRssDao.insertGroup(group);
            subscribeRssDao.insertSubscribeRss(new GroupIdAndUrl(subscribeRss.getGroupId(), subscribeRss.getUrl()));
        }
        assertThat(subscribeRssDao.getAllGroup().getValue().get(0), new IsAnything<>());
    }
}
