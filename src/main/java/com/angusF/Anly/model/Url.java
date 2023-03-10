package com.angusF.Anly.model;

public class Url {
    private String longUrl;
    private String shortUrl;

    public Url() {
    }

    public Url(String longUrl) {
        this.longUrl = longUrl;
    }

    public Url(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
