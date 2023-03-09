package com.angusF.Anly.controller;


import com.angusF.Anly.model.LongToShort;
import com.angusF.Anly.service.LongToShortService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/longToShort")
public class LongToShortRestController {
    private final LongToShortService ltsService;

    public LongToShortRestController(LongToShortService ltsService) {
        this.ltsService = ltsService;
    }

    @GetMapping
    public List<LongToShort> getAllLong() {
        return ltsService.getAllLong();
    }
}
