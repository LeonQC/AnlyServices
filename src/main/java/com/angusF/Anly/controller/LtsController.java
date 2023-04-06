package com.angusF.Anly.controller;

import com.angusF.Anly.model.CommonUrl;
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
    public CommonUrl LongUrlHandler(@RequestBody CommonUrl commonUrl) throws Exception {
        String encode = commonUrl.getEncode();
        anlyService = serviceContext.getAnlyService(encode);
        String shortUrl = prefix + anlyService.longUrlHandler(commonUrl.getLongUrl());
        switch (encode) {
            case "random1" -> shortUrl += "1";
            case "random2" -> shortUrl += "2";
            case "base62" -> shortUrl += "3";
        }
        commonUrl.setShortUrl(shortUrl);
        return commonUrl;
    }
}
