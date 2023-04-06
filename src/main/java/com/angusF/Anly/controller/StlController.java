package com.angusF.Anly.controller;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.service.ServiceContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@RestController
public class StlController {
    private final ServiceContext serviceContext;

    public StlController(ServiceContext serviceContext) throws Exception{
        this.serviceContext = serviceContext;
    }

    public AnlyService anlyService;

    @GetMapping("/shortToLong/{key}")
    public void ShortUrlHandler(@PathVariable String key, HttpServletResponse response) throws Exception {
        switch (key.charAt(key.length() - 1)) {
            case '1' -> anlyService = serviceContext.getAnlyService("random1");
            case '2' -> anlyService = serviceContext.getAnlyService("random2");
            case '3' -> anlyService = serviceContext.getAnlyService("base62");
        }

        key = key.substring(0, key.length() - 1);
        String longUrl = anlyService.shortUrlHandler(key);
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
