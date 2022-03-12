package com.dmoffat.ccde.charities;

import com.dmoffat.ccde.common.CharityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        CharityFinancialChart chart = charityService.findCharityIncomeChartByOrganisationNumber(organisationNumber);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String charityChartJson = objectMapper.writeValueAsString(chart);
            m.addAttribute("charityChartJson", charityChartJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return "charity";
    }
}
