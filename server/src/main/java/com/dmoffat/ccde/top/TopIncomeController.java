package com.dmoffat.ccde.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopIncomeController {
    private final TopCharityService topCharityService;

    @Autowired
    public TopIncomeController(TopCharityService topCharityService) {
        this.topCharityService = topCharityService;
    }

    @GetMapping("/top/income")
    public String index(Model m) {
        m.addAttribute("charities", topCharityService.listByTopIncome());
        return "top-income";
    }

}
