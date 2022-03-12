package com.dmoffat.ccde.charities;

import com.dmoffat.ccde.common.CharityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CharityController {
    private final CharityService charityService;

    @Autowired
    public CharityController(CharityService charityService) {
        this.charityService = charityService;
    }

    @GetMapping("/charities/{organisationNumber}")
    public String viewOrganisation(@PathVariable Integer organisationNumber, Model m) {
        m.addAttribute("charity", charityService.findByOrganisationNumber(organisationNumber));
        return "charity";
    }
}
