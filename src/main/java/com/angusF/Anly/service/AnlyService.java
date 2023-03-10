package com.angusF.Anly.service;
import com.angusF.Anly.model.Url;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Random;

@Service
public class AnlyService {
    private static final String prefix = "http://localhost:8080/anly/";
    private static final String table = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final HashMap<String, String> urlCache = new HashMap<>();
    private static final HashMap<String, String> keyCache = new HashMap<>();
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
        if (urlCache.containsKey(longUrl)) {
            return prefix + urlCache.get(longUrl);
        }

        String key = getKey();
        while (keyCache.containsKey(key)) {
            key = getKey();
        }

        keyCache.put(key, longUrl);
        urlCache.put(longUrl, key);
        return prefix + key;
    }

    public String ShortUrlHandler(String shortUrl) {
        if (!keyCache.containsKey(shortUrl)) {
            return null;
        }
        return keyCache.get(shortUrl);
    }
}
