package com.youngerhousea.simplereader.api.xml;

import org.jetbrains.annotations.NotNull;

public class Guid
{
    private String isPermaLink;

    private String content;

    public String getIsPermaLink ()
    {
        return isPermaLink;
    }

    public void setIsPermaLink (String isPermaLink)
    {
        this.isPermaLink = isPermaLink;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public @NotNull String toString() {
        return "Guid{" +
                "isPermaLink='" + isPermaLink + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}