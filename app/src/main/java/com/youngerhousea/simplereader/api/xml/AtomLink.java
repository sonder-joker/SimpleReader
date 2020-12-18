package com.youngerhousea.simplereader.api.xml;

import org.jetbrains.annotations.NotNull;

public class AtomLink {
    private String rel;

    private String href;

    private String type;

    public String getRel ()
    {
        return rel;
    }

    public void setRel (String rel)
    {
        this.rel = rel;
    }

    public String getHref ()
    {
        return href;
    }

    public void setHref (String href)
    {
        this.href = href;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public @NotNull String toString() {
        return "AtomLink{" +
                "rel='" + rel + '\'' +
                ", href='" + href + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
