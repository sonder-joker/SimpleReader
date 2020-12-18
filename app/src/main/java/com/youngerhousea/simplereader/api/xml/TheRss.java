package com.youngerhousea.simplereader.api.xml;

import org.jetbrains.annotations.NotNull;

public class TheRss
{
    private Rss rss;

    public Rss getRss ()
    {
        return rss;
    }

    public void setRss (Rss rss)
    {
        this.rss = rss;
    }

    @Override
    public @NotNull String toString() {
        return "TheRss{" +
                "rss=" + rss +
                '}';
    }
}
