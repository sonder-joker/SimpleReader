package com.youngerhousea.simplereader.api.xml;

import org.jetbrains.annotations.NotNull;

public class Item
{
    private String author;

    private String link;

    private String description;

    private Guid guid;

    private String title;

    private String pubDate;

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Guid getGuid ()
    {
        return guid;
    }

    public void setGuid (Guid guid)
    {
        this.guid = guid;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getPubDate ()
    {
        return pubDate;
    }

    public void setPubDate (String pubDate)
    {
        this.pubDate = pubDate;
    }

    @Override
    public @NotNull String toString() {
        return "Item{" +
                "author='" + author + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", guid=" + guid +
                ", title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}