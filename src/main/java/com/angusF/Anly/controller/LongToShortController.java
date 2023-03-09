package com.angusF.Anly.controller;

import com.angusF.Anly.service.LongToShortService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/longToShort")
public class LongToShortController {
    private final LongToShortService ltsService;

    public LongToShortController(LongToShortService ltsService) {
        this.ltsService = ltsService;
    }

    @GetMapping
    public String getAllLong(Model model) {
        model.addAttribute("longToShort", ltsService.getAllLong());
        return "longToShort";
    }
}
