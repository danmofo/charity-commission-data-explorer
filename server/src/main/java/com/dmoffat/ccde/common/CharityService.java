package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import com.dmoffat.ccde.charities.CharityAnnualReturn;
import com.dmoffat.ccde.charities.CharityFinancialChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharityService {
    private final CharityDao charityDao;
    private final CharityAnnualReturnPartADao charityAnnualReturnPartADao;

    @Autowired
    public CharityService(CharityDao charityDao, CharityAnnualReturnPartADao charityAnnualReturnPartADao) {
        this.charityDao = charityDao;
        this.charityAnnualReturnPartADao = charityAnnualReturnPartADao;
    }

    public Charity findByOrganisationNumber(Integer organisationNumber) {
        Charity charity = charityDao.find(organisationNumber);
        if(charity == null) {
            return null;
        }
//        charity.setAnnualReturnPartA(charityAnnualReturnPartADao.findLatestByOrganisationNumber(organisationNumber));
        return charity;
    }

    public CharityFinancialChart findCharityIncomeChartByOrganisationNumber(Integer organisationNumber) {
        List<CharityAnnualReturn> annualReturns =
                charityAnnualReturnPartADao.findSummaryByOrganisationNumber(organisationNumber);

        List<BigDecimal> incomes = annualReturns.stream()
                .map(CharityAnnualReturn::getTotalGrossIncome)
                .collect(Collectors.toList());

        List<BigDecimal> expenditures = annualReturns.stream()
                .map(CharityAnnualReturn::getTotalGrossExpenditure)
                .collect(Collectors.toList());

        List<Integer> years = annualReturns.stream()
            .map(ar -> ar.getFinancialPeriodStartDate().getYear())
            .collect(Collectors.toList());

        CharityFinancialChart chart = new CharityFinancialChart();
        chart.setYears(years);
        chart.setIncomeDataPoints(incomes);
        chart.setExpenditureDataPoints(expenditures);
        return chart;
    }

    public List<Charity> list() {
        return charityDao.list();
    }
}
