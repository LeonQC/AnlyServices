package com.angusF.Anly.controller;
import com.angusF.Anly.service.AnlyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;

@RestController
public class AnlyRestController {
    private final AnlyService anlyService;

    public AnlyRestController(AnlyService anlyService) {
        this.anlyService = anlyService;
    }

    @Value("${shortUrl.prefix}")
    private String prefix;

    @PostMapping("/anly")
    public String LongUrlHandler(@RequestParam("longUrl") String longUrl) throws MalformedURLException {
        return prefix + anlyService.LongUrlHandler(longUrl);
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
}
