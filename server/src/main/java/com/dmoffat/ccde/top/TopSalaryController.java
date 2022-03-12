package com.dmoffat.ccde.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopSalaryController {
    private final TopCharityService topCharityService;

    @Autowired
    public TopSalaryController(TopCharityService topCharityService) {
        this.topCharityService = topCharityService;
    }

    @GetMapping("/top/salary")
    public String index(Model m) {
        m.addAttribute("charities", topCharityService.listByTopSalary());
        return "top-salary";
    }
}
