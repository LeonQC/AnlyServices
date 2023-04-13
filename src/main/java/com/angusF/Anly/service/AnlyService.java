package com.angusF.Anly.service;

import com.angusF.Anly.model.CommonUrl;

import java.util.List;

public interface AnlyService {
    default String longUrlHandler(String longUrl) throws Exception {
        throw new RuntimeException();
    }
    default String shortUrlHandler(String shortUrl) throws Exception {
        throw new RuntimeException();
    }
    default List<CommonUrl> getAll() throws Exception {
        throw new RuntimeException();
    }
}
