package com.angusF.Anly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceContext {
    @Autowired
    Map<String, AnlyService> serviceMap;
    public AnlyService getAnlyService(String serviceName) {
        AnlyService anlyService = serviceMap.get(serviceName);
        if (anlyService == null) {
            throw new RuntimeException("No Service Matched, Service Name: " + serviceName);
        }
        return anlyService;
    }
}
