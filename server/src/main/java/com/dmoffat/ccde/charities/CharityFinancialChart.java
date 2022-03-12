package com.dmoffat.ccde.charities;

import java.math.BigDecimal;
import java.util.List;

public class CharityFinancialChart {
    private List<Integer> years;
    private List<BigDecimal> incomeDataPoints;
    private List<BigDecimal> expenditureDataPoints;

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }

    public List<BigDecimal> getIncomeDataPoints() {
        return incomeDataPoints;
    }

    public void setIncomeDataPoints(List<BigDecimal> incomeDataPoints) {
        this.incomeDataPoints = incomeDataPoints;
    }

    public List<BigDecimal> getExpenditureDataPoints() {
        return expenditureDataPoints;
    }

    public void setExpenditureDataPoints(List<BigDecimal> expenditureDataPoints) {
        this.expenditureDataPoints = expenditureDataPoints;
    }
}
