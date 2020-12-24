package com.youngerhousea.simplereader;

import com.prof.rssparser.Channel;
import com.prof.rssparser.OnTaskCompleted;
import com.prof.rssparser.Parser;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RssParserTest {
    private Parser parser;
    String rss;
    @Before
    public void init() {
        parser = new Parser.Builder().build();
        rss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<rss  xmlns:atom=\"http://www.w3.org/2005/Atom\" version=\"2.0\"\n" +
                "\n" +
                ">\n" +
                "    <channel>\n" +
                "        <title>\n" +
                "            <![CDATA[bilibili 3日排行榜-全站-近期投稿]]>\n" +
                "        </title>\n" +
                "        <link>https://www.bilibili.com/ranking/all/0/0/3</link>\n" +
                "        <atom:link href=\"http://rsshub.app/bilibili/ranking/0/3?limit=10\" rel=\"self\" type=\"application/rss+xml\" />\n" +
                "        <description>\n" +
                "            <![CDATA[bilibili 3日排行榜-全站-近期投稿 - Made with love by RSSHub(https://github.com/DIYgod/RSSHub)]]>\n" +
                "        </description>\n" +
                "        <generator>RSSHub</generator>\n" +
                "        <webMaster>i@diygod.me (DIYgod)</webMaster>\n" +
                "        <language>zh-cn</language>\n" +
                "        <lastBuildDate>Thu, 24 Dec 2020 14:36:33 GMT</lastBuildDate>\n" +
                "        <ttl>60</ttl>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[使命一直在召唤 【鬼畜新世界27】]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[使命一直在召唤 【鬼畜新世界27】<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1Aa4y1p7Tz\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/521b808afa96a7898f13c3442d5c05e18046651b.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1Aa4y1p7Tz</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1Aa4y1p7Tz</link>\n" +
                "            <author>\n" +
                "                <![CDATA[三木刃]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[UP主首次给电影唱宣传曲？！怪可爱的！圣诞快乐！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[UP主首次给电影唱宣传曲？！怪可爱的！圣诞快乐！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1ii4y1w7N5\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/47cd091d334932b678bcfc44946d9d9a73bc514a.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1ii4y1w7N5</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1ii4y1w7N5</link>\n" +
                "            <author>\n" +
                "                <![CDATA[哔斯卡金像奖]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【电影史话07】他被称为电影之神！库布里克作品全解读]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【电影史话07】他被称为电影之神！库布里克作品全解读<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1Ly4y1U7Ji\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/4ac91f9654729389739fef5335f49ef34751272f.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1Ly4y1U7Ji</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1Ly4y1U7Ji</link>\n" +
                "            <author>\n" +
                "                <![CDATA[木鱼水心]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【老邪吐槽】逆天吐槽疯狂尬夸的《有翡》：替身抠图五毛特效]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【老邪吐槽】逆天吐槽疯狂尬夸的《有翡》：替身抠图五毛特效<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1tX4y1u7HP\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i2.hdslb.com/bfs/archive/4797c0957ce79b18578ef6296cdf80d5182bf145.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1tX4y1u7HP</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1tX4y1u7HP</link>\n" +
                "            <author>\n" +
                "                <![CDATA[老邪说电影]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[我想婚前买个房，男朋友急了要分手？？这男的可真鸡贼！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[我想婚前买个房，男朋友急了要分手？？这男的可真鸡贼！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV17Z4y137Vh\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i2.hdslb.com/bfs/archive/c71f7fbc2c52bee657638c0b57491e09ffc3c4d2.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV17Z4y137Vh</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV17Z4y137Vh</link>\n" +
                "            <author>\n" +
                "                <![CDATA[vivi可爱多]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【徐锦江】“硬核”中国圣诞老人鳌拜来B站了！进来许愿！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【徐锦江】“硬核”中国圣诞老人鳌拜来B站了！进来许愿！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1MT4y1T7ZP\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i2.hdslb.com/bfs/archive/7476b5774bbf78a7ac7403af8ccc0776b1a02112.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1MT4y1T7ZP</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1MT4y1T7ZP</link>\n" +
                "            <author>\n" +
                "                <![CDATA[徐锦江]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【罗翔】细思恐极的《西游记》，从真假美猴王到唐僧的离奇身世]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【罗翔】细思恐极的《西游记》，从真假美猴王到唐僧的离奇身世<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1ua411c7L1\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i2.hdslb.com/bfs/archive/fd3051cd9dc73c013dd4adc3587e6a7c0081bfa8.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1ua411c7L1</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1ua411c7L1</link>\n" +
                "            <author>\n" +
                "                <![CDATA[罗翔说刑法]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【医学博士】晚睡晚起算不算熬夜？I 如何科学熬夜？]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【医学博士】晚睡晚起算不算熬夜？I 如何科学熬夜？<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1bK4y1L7T2\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/0424f568e0071d630233648b398848bfd5fe56dc.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1bK4y1L7T2</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1bK4y1L7T2</link>\n" +
                "            <author>\n" +
                "                <![CDATA[兔叭咯]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[给大家推荐一种我近期超喜欢的单品]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[给大家推荐一种我近期超喜欢的单品<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1yX4y1T7nY\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/6c56fa105753ee915f3349a52d35c22d1d468b81.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1yX4y1T7nY</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1yX4y1T7nY</link>\n" +
                "            <author>\n" +
                "                <![CDATA[papi酱]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[《原神》一个视频解决你雪山99%的问题--雪山任务/成就/解密，建议选择分P查看]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[《原神》一个视频解决你雪山99%的问题--雪山任务/成就/解密，建议选择分P查看<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1rf4y1e7MD\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i1.hdslb.com/bfs/archive/dbbc6e6f96d515ad3593ee8e511999424122b7d5.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-24T14:47:52.916Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1rf4y1e7MD</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1rf4y1e7MD</link>\n" +
                "            <author>\n" +
                "                <![CDATA[霂暮杺]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "    </channel>\n" +
                "</rss>";
    }

    @Test
    public void test() throws Exception {
        parser.parse(rss, new OnTaskCompleted() {
            @Override
            public void onTaskCompleted(@NotNull Channel channel) {
                System.out.println(channel);
            }

            @Override
            public void onError(@NotNull Exception e) {

            }
        });
    }
}
