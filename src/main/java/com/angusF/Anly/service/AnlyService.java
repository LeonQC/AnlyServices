package com.angusF.Anly.service;
import com.angusF.Anly.data.UrlRepository;
import com.angusF.Anly.model.Url;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class AnlyService {
    private final UrlRepository urlRepository;

    public AnlyService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    private static final String prefix = "http://localhost:8080/anly/";
    private static final String table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String getKey() {
        StringBuilder key = new StringBuilder("");
        Random root = new Random();
        for (int i = 0; i < 6; i++) {
            int rand = root.nextInt(61);
            key.append(table.charAt(rand));
        }
        return key.toString();
    }
    public String LongUrlHandler(String longUrl) {
        Url url = urlRepository.getByLongUrl(longUrl);
        if (url != null) {
            return prefix + url.getShortUrl();
        }

        String key = getKey();
        while (urlRepository.getByShortUrl(key) != null) {
            key = getKey();
        }

        urlRepository.saveAndFlush(new Url(longUrl, key));
        return prefix + key;
    }

    public String ShortUrlHandler(String shortUrl) {
        Url url = urlRepository.getByShortUrl(shortUrl);
        if (url == null) {
            return null;
        }
        return url.getLongUrl();
    }
}
