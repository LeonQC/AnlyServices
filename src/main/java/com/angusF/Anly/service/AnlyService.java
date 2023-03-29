package com.angusF.Anly.service;
import com.angusF.Anly.data.UrlRepository;
import com.angusF.Anly.model.Url;
import com.angusF.Anly.util.EncodeUtil;
import com.angusF.Anly.util.UrlValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;


@Service
public class AnlyService {
    private final UrlRepository urlRepository;

    public AnlyService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Autowired
    EncodeUtil encodeUtil;
    @Autowired
    UrlValidation urlValidation;

    @Cacheable(cacheNames = "longToShort", key = "#longUrl")
    public String LongUrlHandler(String longUrl) throws MalformedURLException {
        if (!urlValidation.isValidUrl(longUrl)) {
            throw new MalformedURLException();
        }
        Url url = urlRepository.getByLongUrl(longUrl);
        if (url != null) {
            return url.getShortUrl();
        }

        String key = encodeUtil.getKey();
        while (urlRepository.getByShortUrl(key) != null) {
            key = encodeUtil.getKey();
        }

        urlRepository.saveAndFlush(new Url(longUrl, key));
        return key;
    }

    @Cacheable(cacheNames = "shortToLong", key = "#key")
    public String ShortUrlHandler(String key) {
        Url url = urlRepository.getByShortUrl(key);
        if (url == null) {
            return null;
        }
        return url.getLongUrl();
    }
}
