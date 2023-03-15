package com.angusF.Anly.service;
import com.angusF.Anly.data.UrlRepository;
import com.angusF.Anly.model.Url;
import com.angusF.Anly.util.EncodeUtil;
import com.angusF.Anly.util.UrlValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${shortUrl.prefix}")
    private String prefix;

    public String LongUrlHandler(String longUrl) throws MalformedURLException {
        if (!urlValidation.isValidUrl(longUrl)) {
            throw new MalformedURLException();
        }
        Url url = urlRepository.getByLongUrl(longUrl);
        if (url != null) {
            return prefix + url.getShortUrl();
        }

        String key = encodeUtil.getKey();
        while (urlRepository.getByShortUrl(key) != null) {
            key = encodeUtil.getKey();
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
