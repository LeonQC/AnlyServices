package com.angusF.Anly.controller;

import com.angusF.Anly.service.ShortToLongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/shortToLong")
public class ShortToLongController {

    private final ShortToLongService stlService;

    public ShortToLongController(ShortToLongService stlService) {
        this.stlService = stlService;
    }

    @GetMapping
    public String getAllShort(Model model) {
        model.addAttribute("shortToLong", stlService.getAllShort());
        return "shortToLong";
    }
}
