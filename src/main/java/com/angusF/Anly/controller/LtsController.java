package com.angusF.Anly.controller;

import com.angusF.Anly.model.HttpBodyInfo;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.service.ServiceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class LtsController {
    private final ServiceContext serviceContext;

    public LtsController(ServiceContext serviceContext) throws Exception{
        this.serviceContext = serviceContext;
    }

    public AnlyService anlyService;

    @Value("${shortUrl.prefix}")
    private String prefix;

    @PostMapping("/longToShort")
    public HttpBodyInfo LongUrlHandler(@RequestBody HttpBodyInfo httpBodyInfo) throws Exception {
        String encode = httpBodyInfo.getEncode();
        anlyService = serviceContext.getAnlyService(encode);
        String shortUrl = prefix + anlyService.longUrlHandler(httpBodyInfo.getLongUrl());
        switch (encode) {
            case "random1" -> shortUrl += "1";
            case "random2" -> shortUrl += "2";
            case "base62" -> shortUrl += "3";
        }
        httpBodyInfo.setShortUrl(shortUrl);
        return httpBodyInfo;
    }
}
