package com.dmoffat.ccde.charities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(catalog = "charity_commission", name = "charity_annual_return_parta")
public class CharityAnnualReturnPartA {

    @Id
    @Column(name = "organisation_number")
    private Integer organisationNumber;

    @Column(name = "latest_fin_period_submitted")
    private boolean latestSubmitted;

    @Column(name = "fin_period_order_number")
    private int order;

    @Column(name = "ar_cycle_reference")
    private String cycleReference;

    @Column(name = "fin_period_start_date")
    private LocalDate financialPeriodStartDate;

    @Column(name = "fin_period_end_date")
    private LocalDate financialPeriodEndDate;

    @Column(name = "ar_due_date")
    private LocalDate dueDate;

    @Column(name = "ar_received_date")
    private LocalDate receivedDate;

    @Column(name = "total_gross_income")
    private double totalGrossIncome;

    @Column(name = "total_gross_expenditure")
    private double totalGrossExpenditure;

    @Column(name = "charity_raises_fund_from_public")
    private boolean charityRaisesFundFromPublic;

    @Column(name = "charity_professional_fundraiser")
    private boolean charityProfessionalFundraiser;

    @Column(name = "charity_agreement_professional_fundraiser")
    private boolean charityAgreementProfessionalFundraiser;

    @Column(name = "charity_commercial_participator")
    private boolean charityCommercialParticipator;

    @Column(name = "charity_agreement_commercial_participator")
    private boolean charityAgreementCommercialParticipator;

    @Column(name = "grant_making_is_main_activity")
    private boolean grantMakingMainActivity;

    @Column(name = "charity_receives_govt_funding_contracts")
    private boolean charityReceivesGovernmentFundingContracts;

    @Column(name = "count_govt_contracts")
    private int countGovernmentContracts;

    @Column(name = "charity_receives_govt_funding_grants")
    private boolean charityReceivesGovernmentFundingGrants;

    @Column(name = "count_govt_grants")
    private int countGovernmentGrants;

    @Column(name = "income_from_government_contracts")
    private double incomeFromGovernmentContracts;

    @Column(name = "income_from_government_grants")
    private double incomeFromGovernmentGrants;

    @Column(name = "charity_has_trading_subsidiary")
    private boolean charityTradingSubsidiary;

    @Column(name = "trustee_also_director_of_subsidiary")
    private boolean directorOfSubsidiaryTrustee;

    @Column(name = "does_trustee_receive_any_benefit")
    private boolean trusteeReceivesBenefit;

    @Column(name = "trustee_payments_acting_as_trustee")
    private boolean trusteePaymentsActingAsTrustee;

    @Column(name = "trustee_receives_payments_services")
    private boolean trusteeReceivesPaymentsServices;

    @Column(name = "trustee_receives_other_benefit")
    private boolean trusteeReceivesOtherBenefit;

    @Column(name = "trustee_resigned_employment")
    private boolean trusteeResignedEmployment;

    @Column(name = "employees_salary_over_60k")
    private boolean employeesSalaryOver60k;

    @Column(name = "count_salary_band_60001_70000")
    private int countSalaryBand60kTo70k;

    @Column(name = "count_salary_band_70001_80000")
    private int countSalaryBand70kTo80k;

    @Column(name = "count_salary_band_80001_90000")
    private int countSalaryBand80kTo90k;

    @Column(name = "count_salary_band_90001_100000")
    private int countSalaryBand90kTo100k;

    @Column(name = "count_salary_band_100001_110000")
    private int countSalaryBand100kTo110k;

    @Column(name = "count_salary_band_110001_120000")
    private int countSalaryBand110kTo120k;

    @Column(name = "count_salary_band_120001_130000")
    private int countSalaryBand120kTo130k;

    @Column(name = "count_salary_band_130001_140000")
    private int countSalaryBand130kTo140k;

    @Column(name = "count_salary_band_140001_150000")
    private int countSalaryBand140kTo150k;

    @Column(name = "count_salary_band_150001_200000")
    private int countSalaryBand150kTo200k;

    @Column(name = "count_salary_band_200001_250000")
    private int countSalaryBand200kTo250k;

    @Column(name = "count_salary_band_250001_300000")
    private int countSalaryBand250kTo300k;

    @Column(name = "count_salary_band_300001_350000")
    private int countSalaryBand300kTo350k;

    @Column(name = "count_salary_band_350001_400000")
    private int countSalaryBand350kTo400k;

    @Column(name = "count_salary_band_400001_450000")
    private int countSalaryBand400kTo450k;

    @Column(name = "count_salary_band_450001_500000")
    private int countSalaryBand450kTo500k;

    @Column(name = "count_salary_band_over_500000")
    private int countSalaryBandOver500k;

    @Column(name = "count_volunteers")
    private int countVolunteers;

    @Formula(value = "(" +
            "       count_salary_band_60001_70000 * 60000 +" +
            "       count_salary_band_70001_80000 * 70000 +" +
            "       count_salary_band_80001_90000 * 80000 +" +
            "       count_salary_band_90001_100000 * 90000 +" +
            "       count_salary_band_100001_110000 * 100000 +" +
            "       count_salary_band_110001_120000 * 110000 +" +
            "       count_salary_band_120001_130000 * 120000 +" +
            "       count_salary_band_130001_140000 * 130000 +" +
            "       count_salary_band_140001_150000 * 140000 + " +
            "       count_salary_band_150001_200000 * 150000 +" +
            "       count_salary_band_200001_250000 * 200000 +" +
            "       count_salary_band_250001_300000 * 250000 +" +
            "       count_salary_band_300001_350000 * 300000 +" +
            "       count_salary_band_350001_400000 * 350000 +" +
            "       count_salary_band_400001_450000 * 400000 +" +
            "       count_salary_band_450001_500000 * 450000 +" +
            "       count_salary_band_over_500000 * 500000" +
            "   )")
    private BigDecimal salaryRangeStart;

    @Formula(value = "(" +
            "       count_salary_band_60001_70000 * 70000 +" +
            "       count_salary_band_70001_80000 * 80000 +" +
            "       count_salary_band_80001_90000 * 90000 +" +
            "       count_salary_band_90001_100000 * 100000 +" +
            "       count_salary_band_100001_110000 * 110000 +" +
            "       count_salary_band_110001_120000 * 120000 +" +
            "       count_salary_band_120001_130000 * 130000 +" +
            "       count_salary_band_130001_140000 * 140000 +" +
            "       count_salary_band_140001_150000 * 150000 + " +
            "       count_salary_band_150001_200000 * 200000 +" +
            "       count_salary_band_200001_250000 * 250000 +" +
            "       count_salary_band_250001_300000 * 300000 +" +
            "       count_salary_band_300001_350000 * 350000 +" +
            "       count_salary_band_350001_400000 * 400000 +" +
            "       count_salary_band_400001_450000 * 450000 +" +
            "       count_salary_band_450001_500000 * 500000 +" +
            "       count_salary_band_over_500000 * 500000" +
            "   )")
    private BigDecimal salaryRangeEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_number", insertable = false, updatable = false)
    private Charity charity;

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

    public Integer getOrganisationNumber() {
        return organisationNumber;
    }

    public void setOrganisationNumber(Integer organisationNumber) {
        this.organisationNumber = organisationNumber;
    }

    public boolean isLatestSubmitted() {
        return latestSubmitted;
    }

    public void setLatestSubmitted(boolean latestSubmitted) {
        this.latestSubmitted = latestSubmitted;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCycleReference() {
        return cycleReference;
    }

    public void setCycleReference(String cycleReference) {
        this.cycleReference = cycleReference;
    }

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

    public LocalDate getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDate receivedDate) {
        this.receivedDate = receivedDate;
    }

    public double getTotalGrossIncome() {
        return totalGrossIncome;
    }

    public void setTotalGrossIncome(double totalGrossIncome) {
        this.totalGrossIncome = totalGrossIncome;
    }

    public double getTotalGrossExpenditure() {
        return totalGrossExpenditure;
    }

    public void setTotalGrossExpenditure(double totalGrossExpenditure) {
        this.totalGrossExpenditure = totalGrossExpenditure;
    }

    public boolean isCharityRaisesFundFromPublic() {
        return charityRaisesFundFromPublic;
    }

    public void setCharityRaisesFundFromPublic(boolean charityRaisesFundFromPublic) {
        this.charityRaisesFundFromPublic = charityRaisesFundFromPublic;
    }

    public boolean isCharityProfessionalFundraiser() {
        return charityProfessionalFundraiser;
    }

    public void setCharityProfessionalFundraiser(boolean charityProfessionalFundraiser) {
        this.charityProfessionalFundraiser = charityProfessionalFundraiser;
    }

    public boolean isCharityAgreementProfessionalFundraiser() {
        return charityAgreementProfessionalFundraiser;
    }

    public void setCharityAgreementProfessionalFundraiser(boolean charityAgreementProfessionalFundraiser) {
        this.charityAgreementProfessionalFundraiser = charityAgreementProfessionalFundraiser;
    }

    public boolean isCharityCommercialParticipator() {
        return charityCommercialParticipator;
    }

    public void setCharityCommercialParticipator(boolean charityCommercialParticipator) {
        this.charityCommercialParticipator = charityCommercialParticipator;
    }

    public boolean isCharityAgreementCommercialParticipator() {
        return charityAgreementCommercialParticipator;
    }

    public void setCharityAgreementCommercialParticipator(boolean charityAgreementCommercialParticipator) {
        this.charityAgreementCommercialParticipator = charityAgreementCommercialParticipator;
    }

    public boolean isGrantMakingMainActivity() {
        return grantMakingMainActivity;
    }

    public void setGrantMakingMainActivity(boolean grantMakingMainActivity) {
        this.grantMakingMainActivity = grantMakingMainActivity;
    }

    public boolean isCharityReceivesGovernmentFundingContracts() {
        return charityReceivesGovernmentFundingContracts;
    }

    public void setCharityReceivesGovernmentFundingContracts(boolean charityReceivesGovernmentFundingContracts) {
        this.charityReceivesGovernmentFundingContracts = charityReceivesGovernmentFundingContracts;
    }

    public int getCountGovernmentContracts() {
        return countGovernmentContracts;
    }

    public void setCountGovernmentContracts(int countGovernmentContracts) {
        this.countGovernmentContracts = countGovernmentContracts;
    }

    public boolean isCharityReceivesGovernmentFundingGrants() {
        return charityReceivesGovernmentFundingGrants;
    }

    public void setCharityReceivesGovernmentFundingGrants(boolean charityReceivesGovernmentFundingGrants) {
        this.charityReceivesGovernmentFundingGrants = charityReceivesGovernmentFundingGrants;
    }

    public int getCountGovernmentGrants() {
        return countGovernmentGrants;
    }

    public void setCountGovernmentGrants(int countGovernmentGrants) {
        this.countGovernmentGrants = countGovernmentGrants;
    }

    public double getIncomeFromGovernmentContracts() {
        return incomeFromGovernmentContracts;
    }

    public void setIncomeFromGovernmentContracts(double incomeFromGovernmentContracts) {
        this.incomeFromGovernmentContracts = incomeFromGovernmentContracts;
    }

    public double getIncomeFromGovernmentGrants() {
        return incomeFromGovernmentGrants;
    }

    public void setIncomeFromGovernmentGrants(double incomeFromGovernmentGrants) {
        this.incomeFromGovernmentGrants = incomeFromGovernmentGrants;
    }

    public boolean isCharityTradingSubsidiary() {
        return charityTradingSubsidiary;
    }

    public void setCharityTradingSubsidiary(boolean charityTradingSubsidiary) {
        this.charityTradingSubsidiary = charityTradingSubsidiary;
    }

    public boolean isDirectorOfSubsidiaryTrustee() {
        return directorOfSubsidiaryTrustee;
    }

    public void setDirectorOfSubsidiaryTrustee(boolean directorOfSubsidiaryTrustee) {
        this.directorOfSubsidiaryTrustee = directorOfSubsidiaryTrustee;
    }

    public boolean isTrusteeReceivesBenefit() {
        return trusteeReceivesBenefit;
    }

    public void setTrusteeReceivesBenefit(boolean trusteeReceivesBenefit) {
        this.trusteeReceivesBenefit = trusteeReceivesBenefit;
    }

    public boolean isTrusteePaymentsActingAsTrustee() {
        return trusteePaymentsActingAsTrustee;
    }

    public void setTrusteePaymentsActingAsTrustee(boolean trusteePaymentsActingAsTrustee) {
        this.trusteePaymentsActingAsTrustee = trusteePaymentsActingAsTrustee;
    }

    public boolean isTrusteeReceivesPaymentsServices() {
        return trusteeReceivesPaymentsServices;
    }

    public void setTrusteeReceivesPaymentsServices(boolean trusteeReceivesPaymentsServices) {
        this.trusteeReceivesPaymentsServices = trusteeReceivesPaymentsServices;
    }

    public boolean isTrusteeReceivesOtherBenefit() {
        return trusteeReceivesOtherBenefit;
    }

    public void setTrusteeReceivesOtherBenefit(boolean trusteeReceivesOtherBenefit) {
        this.trusteeReceivesOtherBenefit = trusteeReceivesOtherBenefit;
    }

    public boolean isTrusteeResignedEmployment() {
        return trusteeResignedEmployment;
    }

    public void setTrusteeResignedEmployment(boolean trusteeResignedEmployment) {
        this.trusteeResignedEmployment = trusteeResignedEmployment;
    }

    public boolean isEmployeesSalaryOver60k() {
        return employeesSalaryOver60k;
    }

    public void setEmployeesSalaryOver60k(boolean employeesSalaryOver60k) {
        this.employeesSalaryOver60k = employeesSalaryOver60k;
    }

    public int getCountSalaryBand60kTo70k() {
        return countSalaryBand60kTo70k;
    }

    public void setCountSalaryBand60kTo70k(int countSalaryBand60kTo70k) {
        this.countSalaryBand60kTo70k = countSalaryBand60kTo70k;
    }

    public int getCountSalaryBand70kTo80k() {
        return countSalaryBand70kTo80k;
    }

    public void setCountSalaryBand70kTo80k(int countSalaryBand70kTo80k) {
        this.countSalaryBand70kTo80k = countSalaryBand70kTo80k;
    }

    public int getCountSalaryBand80kTo90k() {
        return countSalaryBand80kTo90k;
    }

    public void setCountSalaryBand80kTo90k(int countSalaryBand80kTo90k) {
        this.countSalaryBand80kTo90k = countSalaryBand80kTo90k;
    }

    public int getCountSalaryBand90kTo100k() {
        return countSalaryBand90kTo100k;
    }

    public void setCountSalaryBand90kTo100k(int countSalaryBand90kTo100k) {
        this.countSalaryBand90kTo100k = countSalaryBand90kTo100k;
    }

    public int getCountSalaryBand100kTo110k() {
        return countSalaryBand100kTo110k;
    }

    public void setCountSalaryBand100kTo110k(int countSalaryBand100kTo110k) {
        this.countSalaryBand100kTo110k = countSalaryBand100kTo110k;
    }

    public int getCountSalaryBand110kTo120k() {
        return countSalaryBand110kTo120k;
    }

    public void setCountSalaryBand110kTo120k(int countSalaryBand110kTo120k) {
        this.countSalaryBand110kTo120k = countSalaryBand110kTo120k;
    }

    public int getCountSalaryBand120kTo130k() {
        return countSalaryBand120kTo130k;
    }

    public void setCountSalaryBand120kTo130k(int countSalaryBand120kTo130k) {
        this.countSalaryBand120kTo130k = countSalaryBand120kTo130k;
    }

    public int getCountSalaryBand130kTo140k() {
        return countSalaryBand130kTo140k;
    }

    public void setCountSalaryBand130kTo140k(int countSalaryBand130kTo140k) {
        this.countSalaryBand130kTo140k = countSalaryBand130kTo140k;
    }

    public int getCountSalaryBand140kTo150k() {
        return countSalaryBand140kTo150k;
    }

    public void setCountSalaryBand140kTo150k(int countSalaryBand140kTo150k) {
        this.countSalaryBand140kTo150k = countSalaryBand140kTo150k;
    }

    public int getCountSalaryBand150kTo200k() {
        return countSalaryBand150kTo200k;
    }

    public void setCountSalaryBand150kTo200k(int countSalaryBand150kTo200k) {
        this.countSalaryBand150kTo200k = countSalaryBand150kTo200k;
    }

    public int getCountSalaryBand200kTo250k() {
        return countSalaryBand200kTo250k;
    }

    public void setCountSalaryBand200kTo250k(int countSalaryBand200kTo250k) {
        this.countSalaryBand200kTo250k = countSalaryBand200kTo250k;
    }

    public int getCountSalaryBand250kTo300k() {
        return countSalaryBand250kTo300k;
    }

    public void setCountSalaryBand250kTo300k(int countSalaryBand250kTo300k) {
        this.countSalaryBand250kTo300k = countSalaryBand250kTo300k;
    }

    public int getCountSalaryBand300kTo350k() {
        return countSalaryBand300kTo350k;
    }

    public void setCountSalaryBand300kTo350k(int countSalaryBand300kTo350k) {
        this.countSalaryBand300kTo350k = countSalaryBand300kTo350k;
    }

    public int getCountSalaryBand350kTo400k() {
        return countSalaryBand350kTo400k;
    }

    public void setCountSalaryBand350kTo400k(int countSalaryBand350kTo400k) {
        this.countSalaryBand350kTo400k = countSalaryBand350kTo400k;
    }

    public int getCountSalaryBand400kTo450k() {
        return countSalaryBand400kTo450k;
    }

    public void setCountSalaryBand400kTo450k(int countSalaryBand400kTo450k) {
        this.countSalaryBand400kTo450k = countSalaryBand400kTo450k;
    }

    public int getCountSalaryBand450kTo500k() {
        return countSalaryBand450kTo500k;
    }

    public void setCountSalaryBand450kTo500k(int countSalaryBand450kTo500k) {
        this.countSalaryBand450kTo500k = countSalaryBand450kTo500k;
    }

    public int getCountSalaryBandOver500k() {
        return countSalaryBandOver500k;
    }

    public void setCountSalaryBandOver500k(int countSalaryBandOver500k) {
        this.countSalaryBandOver500k = countSalaryBandOver500k;
    }

    public int getCountVolunteers() {
        return countVolunteers;
    }

    public void setCountVolunteers(int countVolunteers) {
        this.countVolunteers = countVolunteers;
    }

    public BigDecimal getSalaryRangeStart() {
        return salaryRangeStart;
    }

    public BigDecimal getSalaryRangeEnd() {
        return salaryRangeEnd;
    }

    @Override
    public String toString() {
        return "CharityAnnualReturnPartA{" +
                "organisationNumber=" + organisationNumber +
                ", receivedDate=" + receivedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharityAnnualReturnPartA that = (CharityAnnualReturnPartA) o;
        return organisationNumber.equals(that.organisationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisationNumber);
    }
}
