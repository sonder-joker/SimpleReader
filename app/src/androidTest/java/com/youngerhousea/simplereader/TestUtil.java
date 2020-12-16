package com.youngerhousea.simplereader;

import com.youngerhousea.simplereader.data.model.Group;
import com.youngerhousea.simplereader.data.model.SubscribeRss;

import java.util.Random;

public class TestUtil {
    public static SubscribeRss createSubscribeRss(int groupId) {
        return new SubscribeRss(groupId, Double.toString(new Random().nextDouble()));
    }

    public static Group createGroup() {
        return new Group(Double.toString(new Random().nextDouble()));
    }
}
