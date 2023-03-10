package com.angusF.Anly.controller;
import com.angusF.Anly.model.Url;
import com.angusF.Anly.service.AnlyService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
public class AnlyRestController {
    private final AnlyService anlyService;

    public AnlyRestController(AnlyService anlyService) {
        this.anlyService = anlyService;
    }

    @PostMapping("/anly")
    public String LongUrlHandler(@RequestParam("longUrl") String longUrl) {
        return anlyService.LongUrlHandler(longUrl);
    }

    @GetMapping("/anly/{shortUrl}")
    public void ShortUrlHandler(@PathVariable String shortUrl, HttpServletResponse response) throws IOException {
        String longUrl = anlyService.ShortUrlHandler(shortUrl);
        if (longUrl == null) {
            throw new NoSuchElementException(shortUrl);
        } else {
            System.out.println(longUrl);
            response.sendRedirect("http://" + longUrl);
        }
    }
}
