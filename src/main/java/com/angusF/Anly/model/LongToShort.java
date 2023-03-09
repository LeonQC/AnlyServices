package com.angusF.Anly.model;

public class LongToShort {
    private long id;
    private String shortURL;
    private String longURL;

    public LongToShort() {
    }

    public LongToShort(long id, String longURL) {
        this.id = id;
        this.longURL = longURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}


