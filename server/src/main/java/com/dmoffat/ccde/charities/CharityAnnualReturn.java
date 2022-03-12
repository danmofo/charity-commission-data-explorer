package com.dmoffat.ccde.charities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * This model amalgamates the data from CharityReturnPartA and CharityReturnPartB and adds a few calculated fields.
 * todo: Add CharityReturnPartB fields + actually see what this is.
 */
@Entity
public class CharityAnnualReturn {
    @Id
    @Column(name = "fin_period_start_date")
    private LocalDate financialPeriodStartDate;
    @Column(name = "fin_period_end_date")
    private LocalDate financialPeriodEndDate;
    @Column(name = "total_gross_income")
    private BigDecimal totalGrossIncome;
    @Column(name = "income_from_government_grants")
    private BigDecimal incomeFromGovernmentGrants;
    @Column(name = "income_from_government_contracts")
    private BigDecimal incomeFromGovernmentContracts;
    @Column(name = "total_gross_expenditure")
    private BigDecimal totalGrossExpenditure;
    @Column(name = "salary_range_start")
    private BigDecimal salaryRangeStart;
    @Column(name = "salary_range_end")
    private BigDecimal salaryRangeEnd;

    public LocalDate getFinancialPeriodStartDate() {
        return financialPeriodStartDate;
    }

    public void setFinancialPeriodStartDate(LocalDate financialPeriodStartDate) {
        this.financialPeriodStartDate = financialPeriodStartDate;
    }

    public LocalDate getFinancialPeriodEndDate() {
        return financialPeriodEndDate;
    }

    public void setFinancialPeriodEndDate(LocalDate financialPeriodEndDate) {
        this.financialPeriodEndDate = financialPeriodEndDate;
    }

    public BigDecimal getTotalGrossIncome() {
        return totalGrossIncome;
    }

    public void setTotalGrossIncome(BigDecimal totalGrossIncome) {
        this.totalGrossIncome = totalGrossIncome;
    }

    public BigDecimal getIncomeFromGovernmentGrants() {
        return incomeFromGovernmentGrants;
    }

    public void setIncomeFromGovernmentGrants(BigDecimal incomeFromGovernmentGrants) {
        this.incomeFromGovernmentGrants = incomeFromGovernmentGrants;
    }

    public BigDecimal getIncomeFromGovernmentContracts() {
        return incomeFromGovernmentContracts;
    }

    public void setIncomeFromGovernmentContracts(BigDecimal incomeFromGovernmentContracts) {
        this.incomeFromGovernmentContracts = incomeFromGovernmentContracts;
    }

    public BigDecimal getTotalGrossExpenditure() {
        return totalGrossExpenditure;
    }

    public void setTotalGrossExpenditure(BigDecimal totalGrossExpenditure) {
        this.totalGrossExpenditure = totalGrossExpenditure;
    }

    public BigDecimal getSalaryRangeStart() {
        return salaryRangeStart;
    }

    public void setSalaryRangeStart(BigDecimal salaryRangeStart) {
        this.salaryRangeStart = salaryRangeStart;
    }

    public BigDecimal getSalaryRangeEnd() {
        return salaryRangeEnd;
    }

    public void setSalaryRangeEnd(BigDecimal salaryRangeEnd) {
        this.salaryRangeEnd = salaryRangeEnd;
    }
}
