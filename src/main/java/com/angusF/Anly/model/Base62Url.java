package com.angusF.Anly.model;
import javax.persistence.*;

@Entity
@Table(name="BASE62")
public class Base62Url {
    @Id
    @Column(name="ID")
    private long id;
    @Column(name="LONG_URL")
    private String longUrl;
    @Column(name="SHORT_URL")
    private String shortUrl;

    public Base62Url() {
    }

    public Base62Url(String longUrl) {
        this.longUrl = longUrl;
    }

    public Base62Url(long id) {
        this.id = id;
    }

    public Base62Url(long id, String longUrl) {
        this.id = id;
        this.longUrl = longUrl;
    }

    public Base62Url(long id, String longUrl, String shortUrl) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
    }

    public long getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setId(long id) {
        this.id = id;
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
