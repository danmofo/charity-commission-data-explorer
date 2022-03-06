package com.dmoffat.ccde.homepage;

import com.dmoffat.ccde.common.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CharityService charityService;

    @Autowired
    public HomeController(CharityService charityService) {
        this.charityService = charityService;
    }

    @GetMapping("/")
    public String home(Model m) {
        m.addAttribute("charities", charityService.list());
        return "home";
    }

}
