package com.angusF.Anly.service.impl;
import com.angusF.Anly.data.Random1Repository;
import com.angusF.Anly.model.CommonUrl;
import com.angusF.Anly.model.Random1Url;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.util.UrlValidation;
import com.angusF.Anly.util.encode.Random1Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


@Service("random1")
public class Random1Service implements AnlyService {
    private final Random1Repository random1Repository;

    public Random1Service(Random1Repository random1Repository) {
        this.random1Repository = random1Repository;
    }

    @Value("${shortUrl.prefix}")
    private String prefix;

    @Autowired
    UrlValidation urlValidation;

    @Autowired
    Random1Encode encodeUtil;

    @Cacheable(cacheNames = "rd1_lts", key = "#longUrl")
    @Override
    public String longUrlHandler(String longUrl) throws Exception {
        if (!urlValidation.isValidUrl(longUrl)) {
            throw new MalformedURLException();
        }
        Random1Url random1Url = random1Repository.getByLongUrl(longUrl);
        if (random1Url != null) {
            return random1Url.getShortUrl();
        }

        String key = encodeUtil.getKey();
        while (random1Repository.getByShortUrl(key) != null) {
            key = encodeUtil.getKey();
        }

        random1Repository.saveAndFlush(new Random1Url(longUrl, key));
        return key;
    }

    @Cacheable(cacheNames = "rd1_stl", key = "#key")
    @Override
    public String shortUrlHandler(String key) throws Exception{
        Random1Url random1Url = random1Repository.getByShortUrl(key);
        if (random1Url == null) {
            return null;
        }
        return random1Url.getLongUrl();
    }

    @Override
    public List<CommonUrl> getAll() throws Exception{
        List<CommonUrl> allUrls = new ArrayList<>();
        List<Random1Url> allRandom1Urls = random1Repository.findAll();
        for (Random1Url url : allRandom1Urls) {
            allUrls.add(new CommonUrl(url.getId(), url.getLongUrl(), prefix + url.getShortUrl() + "1", "random1"));
        }
        return allUrls;
    }
}
