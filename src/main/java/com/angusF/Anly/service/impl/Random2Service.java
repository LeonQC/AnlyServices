package com.angusF.Anly.service.impl;

import com.angusF.Anly.data.Random2Repository;
import com.angusF.Anly.model.Random2Url;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.util.UrlValidation;
import com.angusF.Anly.util.encode.Random2Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;

@Service("random2")
public class Random2Service implements AnlyService {
    private final Random2Repository random2Repository;

    public Random2Service(Random2Repository random2Repository) {
        this.random2Repository = random2Repository;
    }

    @Autowired
    UrlValidation urlValidation;

    @Autowired
    Random2Encode encodeUtil;

    @Cacheable(cacheNames = "rd2_lts", key = "#longUrl")
    @Override
    public String longUrlHandler(String longUrl) throws Exception {
        if (!urlValidation.isValidUrl(longUrl)) {
            throw new MalformedURLException();
        }
        Random2Url random2Url = random2Repository.getByLongUrl(longUrl);
        if (random2Url != null) {
            return random2Url.getShortUrl();
        }

        String key = encodeUtil.getKey();
        while (random2Repository.getByShortUrl(key) != null) {
            key = encodeUtil.getKey();
        }

        random2Repository.saveAndFlush(new Random2Url(longUrl, key));
        return key;
    }

    @Cacheable(cacheNames = "rd2_stl", key = "#key")
    @Override
    public String shortUrlHandler(String key) throws Exception{
        Random2Url random2Url = random2Repository.getByShortUrl(key);
        if (random2Url == null) {
            return null;
        }
        return random2Url.getLongUrl();
    }
}
