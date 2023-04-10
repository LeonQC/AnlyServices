package com.angusF.Anly.service;

public interface AnlyService {
    default String longUrlHandler(String longUrl) throws Exception {
        throw new RuntimeException();
    }
    default String shortUrlHandler(String shortUrl) throws Exception {
        throw new RuntimeException();
    }
}
