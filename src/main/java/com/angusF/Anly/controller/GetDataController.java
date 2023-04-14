package com.angusF.Anly.controller;

import com.angusF.Anly.model.CommonUrl;
import com.angusF.Anly.service.AnlyService;
import com.angusF.Anly.service.ServiceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDataController {
    private final ServiceContext serviceContext;

    public GetDataController(ServiceContext serviceContext) throws Exception{
        this.serviceContext = serviceContext;
    }

    public AnlyService anlyService;

    @GetMapping("/getData")
    List<CommonUrl> getData(@RequestParam String encode) throws Exception{
        anlyService = serviceContext.getAnlyService(encode);
        return anlyService.getAll();
    }
}
