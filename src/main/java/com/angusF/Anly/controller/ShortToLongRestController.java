package com.angusF.Anly.controller;

import com.angusF.Anly.model.ShortToLong;
import com.angusF.Anly.service.ShortToLongService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shortToLong")
public class ShortToLongRestController {
    private final ShortToLongService stlService;

    public ShortToLongRestController(ShortToLongService stlService) {
        this.stlService = stlService;
    }

    @GetMapping
    public List<ShortToLong> getAllShort() {
        return stlService.getAllShort();
    }

}
