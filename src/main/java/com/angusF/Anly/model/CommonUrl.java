package com.angusF.Anly.model;

public class CommonUrl {
    private long id;
    private String longUrl;
    private String shortUrl;
    private String encode;

    public CommonUrl() {
    }

    public CommonUrl(String encode) {
        this.encode = encode;
    }

    public CommonUrl(String longUrl, String encode) {
        this.longUrl = longUrl;
        this.encode = encode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }
}
