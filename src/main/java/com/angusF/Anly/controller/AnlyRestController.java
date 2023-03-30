package com.angusF.Anly.controller;
import com.angusF.Anly.model.Url;
import com.angusF.Anly.service.AnlyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class AnlyRestController {
    private final AnlyService anlyService;

    public AnlyRestController(AnlyService anlyService) {
        this.anlyService = anlyService;
    }

    @Value("${shortUrl.prefix}")
    private String prefix;

    @PostMapping("/anly")
    public Url LongUrlHandler(@RequestBody Url url) throws MalformedURLException {
        String shortUrl = prefix + anlyService.LongUrlHandler(url.getLongUrl());
        url.setShortUrl(shortUrl);
        return url;
    }

    @GetMapping("/anly/{key}")
    public void ShortUrlHandler(@PathVariable String key, HttpServletResponse response) throws IOException {
        String longUrl = anlyService.ShortUrlHandler(key);
        if (longUrl == null) {
            throw new NoSuchElementException(key);
        } else {
            System.out.println(longUrl);
            response.sendRedirect(longUrl);
        }
    }

    @GetMapping("/test1")
    public String Test1() {
        return "A test page with authentication";
    }

    @GetMapping("/test2")
    public String Test2() {
        return "A test page without authentication";
    }
}
