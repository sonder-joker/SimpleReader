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
public class ParserTest {
    private Parser parser;

    @Before
    public void init() {
        parser = new Parser.Builder().build();
    }

    @Test
    public void test() {
        String rss = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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
                "        <lastBuildDate>Sun, 20 Dec 2020 01:40:06 GMT</lastBuildDate>\n" +
                "        <ttl>60</ttl>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[课 堂 请 勿 对 对 子 3.0 ！！！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[课 堂 请 勿 对 对 子 3.0 ！！！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1Ci4y1c7D8\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/ed57561ee9a691bef862fb20a7708139973c2bdd.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1Ci4y1c7D8</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1Ci4y1c7D8</link>\n" +
                "            <author>\n" +
                "                <![CDATA[三十六贱笑]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[北京东路的日子（十年荣耀版）]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[北京东路的日子（十年荣耀版）<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1Xz4y167be\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/515dd2124d3518850430e3c783e4585d3d644242.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1Xz4y167be</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1Xz4y167be</link>\n" +
                "            <author>\n" +
                "                <![CDATA[荣耀手机]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[来自1000年前的中式炸鸡：包学包会，不会...再学！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[来自1000年前的中式炸鸡：包学包会，不会...再学！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1zi4y157Jb\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i1.hdslb.com/bfs/archive/c0cf61b723cfc7d409d78154431c37bcf4eb2ab8.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1zi4y157Jb</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1zi4y157Jb</link>\n" +
                "            <author>\n" +
                "                <![CDATA[绵羊料理]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【艾伦】爆肝30天！轮胎制作进击的巨人艾伦.耶格尔]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【艾伦】爆肝30天！轮胎制作进击的巨人艾伦.耶格尔<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1Qi4y157az\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/b332ce76024f37d7ab1d82d39163f2180a493b53.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1Qi4y157az</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1Qi4y157az</link>\n" +
                "            <author>\n" +
                "                <![CDATA[曹胜歌]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[《赛博朋克2077》的发售风波：蠢驴不蠢，狡诈得很｜调查报告]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[《赛博朋克2077》的发售风波：蠢驴不蠢，狡诈得很｜调查报告<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1xv41147c5\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/6d3afd302300e4ff6e0a0f0f01fbda089415a3a4.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1xv41147c5</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1xv41147c5</link>\n" +
                "            <author>\n" +
                "                <![CDATA[贪玩歌姬小宁子]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[“起码留下名字，您贵姓？   免贵 ，中国人！”]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[“起码留下名字，您贵姓？   免贵 ，中国人！”<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1wy4y1D7WU\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i1.hdslb.com/bfs/archive/02a1125ce53a8970d098c795a73eba4a3ed20393.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1wy4y1D7WU</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1wy4y1D7WU</link>\n" +
                "            <author>\n" +
                "                <![CDATA[海棠家的大肥鱼]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[“你们不要再这样吃面了！这样只会饿死我！”]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[“你们不要再这样吃面了！这样只会饿死我！”<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1nf4y1e7HB\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i1.hdslb.com/bfs/archive/9cc5a63b0f45f42605f26f81a506bad68bc5497b.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1nf4y1e7HB</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1nf4y1e7HB</link>\n" +
                "            <author>\n" +
                "                <![CDATA[盗月社食遇记]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[【罗汉鬼套路】lol新版本最有人生阅历套路 徐老师听了想打人！！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[【罗汉鬼套路】lol新版本最有人生阅历套路 徐老师听了想打人！！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1xv41147Ft\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i2.hdslb.com/bfs/archive/1033c5fa6aef1b005eed8bf1f5df6a734931e2c6.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1xv41147Ft</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1xv41147Ft</link>\n" +
                "            <author>\n" +
                "                <![CDATA[罗汉解说]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[《原神》阿贝多角色PV—— 「写生与创生」]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[《原神》阿贝多角色PV—— 「写生与创生」<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1yp4y1q7gA\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/22d246ee201588c1172796be689d7dad030a5500.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1yp4y1q7gA</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1yp4y1q7gA</link>\n" +
                "            <author>\n" +
                "                <![CDATA[原神]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>\n" +
                "                <![CDATA[靠谱盘点103：转会风云！小虎自愿转战上路，Nuguri加入FPX，牛宝：晒老师，我来辣！]]>\n" +
                "            </title>\n" +
                "            <description>\n" +
                "                <![CDATA[靠谱盘点103：转会风云！小虎自愿转战上路，Nuguri加入FPX，牛宝：晒老师，我来辣！<br><br><iframe src=\"https://player.bilibili.com/player.html?bvid=BV1fT4y1M7VH\" width=\"650\" height=\"477\" scrolling=\"no\" border=\"0\" frameborder=\"no\" framespacing=\"0\" allowfullscreen=\"true\"></iframe><br><img src=\"http://i0.hdslb.com/bfs/archive/2aa9d50ffbd30dd4a283ec08d4564ae883c50f8f.jpg\" referrerpolicy=\"no-referrer\">]]>\n" +
                "            </description>\n" +
                "            <pubDate>2020-12-20T02:06:52.799Z</pubDate>\n" +
                "            <guid isPermaLink=\"false\">https://www.bilibili.com/video/BV1fT4y1M7VH</guid>\n" +
                "            <link>https://www.bilibili.com/video/BV1fT4y1M7VH</link>\n" +
                "            <author>\n" +
                "                <![CDATA[靠谱电竞]]>\n" +
                "            </author>\n" +
                "        </item>\n" +
                "    </channel>\n" +
                "</rss>";
        Channel a = f(rss);
        System.out.println(a);
    }

    public Channel f(String rss) {
        final Channel[] c = {new Channel()};
        try {
            parser.parse(rss, new OnTaskCompleted() {
                @Override
                public void onTaskCompleted(@NotNull Channel channel) {
                    c[0] = channel;
                }

                @Override
                public void onError(@NotNull Exception e) {
                    e.printStackTrace();
                }
            });
            return c[0];
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
