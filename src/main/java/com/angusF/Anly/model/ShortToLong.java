package com.angusF.Anly.model;

public class ShortToLong {
    private long id;
    private String shortURL;
    private String longURL;

    public ShortToLong() {
    }

    public ShortToLong(long id, String shortURL) {
        this.id = id;
        this.shortURL = shortURL;
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
