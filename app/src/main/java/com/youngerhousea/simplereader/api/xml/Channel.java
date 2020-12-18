package com.youngerhousea.simplereader.api.xml;

import android.media.Image;

import com.youngerhousea.simplereader.api.xml.Item;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Channel
{
    private Image image;

    private List<Item> item;

    private AtomLink atomLink;

    private String lastBuildDate;

    private String link;

    private String description;

    private String generator;

    private String language;

    private String title;

    private String webMaster;

    private String ttl;

    public Image getImage ()
    {
        return image;
    }

    public void setImage (Image image)
    {
        this.image = image;
    }

    public List<Item> getItem ()
    {
        return item;
    }

    public void setItem (List<Item> item)
    {
        this.item = item;
    }

    public AtomLink getAtomLink() {
        return atomLink;
    }

    public void setAtomLink(AtomLink atomLink) {
        this.atomLink = atomLink;
    }

    public String getLastBuildDate ()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate (String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
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

    public String getGenerator ()
    {
        return generator;
    }

    public void setGenerator (String generator)
    {
        this.generator = generator;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getWebMaster ()
    {
        return webMaster;
    }

    public void setWebMaster (String webMaster)
    {
        this.webMaster = webMaster;
    }

    public String getTtl ()
    {
        return ttl;
    }

    public void setTtl (String ttl)
    {
        this.ttl = ttl;
    }

    @Override
    public @NotNull String toString() {
        return "Channel{" +
                "image=" + image +
                ", item=" + item +
                ", atomLink=" + atomLink +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", generator='" + generator + '\'' +
                ", language='" + language + '\'' +
                ", title='" + title + '\'' +
                ", webMaster='" + webMaster + '\'' +
                ", ttl='" + ttl + '\'' +
                '}';
    }
}
