package com.angusF.Anly.model;

import javax.persistence.*;

@Entity
@Table(name="RANDOM1")
public class Random1Url {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="LONG_URL")
    private String longUrl;
    @Column(name="SHORT_URL")
    private String shortUrl;

    public Random1Url() {
    }

    public Random1Url(String longUrl) {
        this.longUrl = longUrl;
    }

    public Random1Url(String longUrl, String shortUrl) {
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
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
}
