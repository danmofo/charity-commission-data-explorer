package com.dmoffat.ccde.charities;

import com.dmoffat.ccde.common.Utils;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(catalog = "charity_commission", name = "charity")
public class Charity {
    @Id
    @Column(name = "organisation_number")
    private Integer organisationNumber;

    @Column(name = "registered_charity_number")
    private Integer registeredNumber;

    @Column(name = "linked_charity_number")
    private Integer linkedNumber;

    @Column(name = "charity_name")
    private String name;

    @Column(name = "charity_type")
    private String type;

    @Column(name = "charity_registration_status")
    private String registrationStatus;

    @Column(name = "date_of_registration")
    private LocalDate registeredOn;

    @Column(name = "date_of_removal")
    private LocalDate removedOn;

    @Column(name = "charity_reporting_status")
    private String reportingStatus;

    @Column(name = "latest_acc_fin_period_start_date")
    private LocalDate latestAccountFinancialPeriodStart;

    @Column(name = "latest_acc_fin_period_end_date")
    private LocalDate latestAccountFinancialPeriodEnd;

    @Column(name = "latest_income")
    private double latestIncome;

    @Column(name = "latest_expenditure")
    private double latestExpenditure;

    @Column(name = "charity_contact_address1")
    private String address1;

    @Column(name = "charity_contact_address2")
    private String address2;

    @Column(name = "charity_contact_address3")
    private String address3;

    @Column(name = "charity_contact_address4")
    private String address4;

    @Column(name = "charity_contact_address5")
    private String address5;

    @Column(name = "charity_contact_postcode")
    private String postcode;

    @Column(name = "charity_contact_phone")
    private String phone;

    @Column(name = "charity_contact_email")
    private String email;

    @Column(name = "charity_contact_web")
    private String websiteUrl;

    @Column(name = "charity_company_registration_number")
    private String companyRegistrationNumber;

    @Column(name = "charity_insolvent")
    private boolean insolvent;

    @Column(name = "charity_in_administration")
    private boolean inAdministration;

    @Column(name = "charity_previously_excepted")
    private boolean previouslyExcepted;

    @Column(name = "charity_is_cdf_or_cif")
    private String cdfOrCif;

    @Column(name = "charity_is_cio")
    private boolean cio;

    @Column(name = "cio_is_dissolved")
    private boolean cioDissolved;

    @Column(name = "date_cio_dissolution_notice")
    private LocalDate cioDissolutionNoticeOn;

    @Column(name = "charity_activities")
    private String activities;

    @Column(name = "charity_gift_aid")
    private String registeredForGiftAid;

    @Column(name = "charity_has_land")
    private boolean ownsLand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "charity")
    private List<CharityAnnualReturnPartA> annualReturns;

    public String getAddress() {
        StringBuilder address = new StringBuilder(address1);
        if(address2 != null) address.append(", ").append(address2);
        if(address3 != null) address.append(", ").append(address3);
        if(address4 != null) address.append(", ").append(address4);
        if(address5 != null) address.append(", ").append(address5);
        if(postcode != null) address.append(", ").append(postcode);
        return address.toString();
    }

    public CharityAnnualReturnPartA getLatestAnnualReturnPartA() {
        if(annualReturns.isEmpty()) {
            return null;
        }
        return annualReturns.stream()
                .filter(CharityAnnualReturnPartA::isLatestSubmitted)
                .collect(Utils.toSingleton());
    }

    public List<CharityAnnualReturnPartA> getAnnualReturns() {
        return annualReturns;
    }

    public void setAnnualReturns(List<CharityAnnualReturnPartA> annualReturns) {
        this.annualReturns = annualReturns;
    }

    public Integer getOrganisationNumber() {
        return organisationNumber;
    }

    public void setOrganisationNumber(Integer organisationNumber) {
        this.organisationNumber = organisationNumber;
    }

    public Integer getRegisteredNumber() {
        return registeredNumber;
    }

    public void setRegisteredNumber(Integer registeredNumber) {
        this.registeredNumber = registeredNumber;
    }

    public Integer getLinkedNumber() {
        return linkedNumber;
    }

    public void setLinkedNumber(Integer linkedNumber) {
        this.linkedNumber = linkedNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDate getRemovedOn() {
        return removedOn;
    }

    public void setRemovedOn(LocalDate removedOn) {
        this.removedOn = removedOn;
    }

    public String getReportingStatus() {
        return reportingStatus;
    }

    public void setReportingStatus(String reportingStatus) {
        this.reportingStatus = reportingStatus;
    }

    public LocalDate getLatestAccountFinancialPeriodStart() {
        return latestAccountFinancialPeriodStart;
    }

    public void setLatestAccountFinancialPeriodStart(LocalDate latestAccountFinancialPeriodStart) {
        this.latestAccountFinancialPeriodStart = latestAccountFinancialPeriodStart;
    }

    public LocalDate getLatestAccountFinancialPeriodEnd() {
        return latestAccountFinancialPeriodEnd;
    }

    public void setLatestAccountFinancialPeriodEnd(LocalDate latestAccountFinancialPeriodEnd) {
        this.latestAccountFinancialPeriodEnd = latestAccountFinancialPeriodEnd;
    }

    public double getLatestIncome() {
        return latestIncome;
    }

    public void setLatestIncome(double latestIncome) {
        this.latestIncome = latestIncome;
    }

    public double getLatestExpenditure() {
        return latestExpenditure;
    }

    public void setLatestExpenditure(double latestExpenditure) {
        this.latestExpenditure = latestExpenditure;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getAddress4() {
        return address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    public String getAddress5() {
        return address5;
    }

    public void setAddress5(String address5) {
        this.address5 = address5;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public boolean isInsolvent() {
        return insolvent;
    }

    public void setInsolvent(boolean insolvent) {
        this.insolvent = insolvent;
    }

    public boolean isInAdministration() {
        return inAdministration;
    }

    public void setInAdministration(boolean inAdministration) {
        this.inAdministration = inAdministration;
    }

    public boolean isPreviouslyExcepted() {
        return previouslyExcepted;
    }

    public void setPreviouslyExcepted(boolean previouslyExcepted) {
        this.previouslyExcepted = previouslyExcepted;
    }

    public String getCdfOrCif() {
        return cdfOrCif;
    }

    public void setCdfOrCif(String cdfOrCif) {
        this.cdfOrCif = cdfOrCif;
    }

    public boolean isCio() {
        return cio;
    }

    public void setCio(boolean cio) {
        this.cio = cio;
    }

    public boolean isCioDissolved() {
        return cioDissolved;
    }

    public void setCioDissolved(boolean cioDissolved) {
        this.cioDissolved = cioDissolved;
    }

    public LocalDate getCioDissolutionNoticeOn() {
        return cioDissolutionNoticeOn;
    }

    public void setCioDissolutionNoticeOn(LocalDate cioDissolutionNoticeOn) {
        this.cioDissolutionNoticeOn = cioDissolutionNoticeOn;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getRegisteredForGiftAid() {
        return registeredForGiftAid;
    }

    public void setRegisteredForGiftAid(String registeredForGiftAid) {
        this.registeredForGiftAid = registeredForGiftAid;
    }

    public boolean isOwnsLand() {
        return ownsLand;
    }

    public void setOwnsLand(boolean ownsLand) {
        this.ownsLand = ownsLand;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charity charity = (Charity) o;
        return organisationNumber.equals(charity.organisationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisationNumber);
    }

    @Override
    public String toString() {
        return "Charity{" +
                "organisationNumber=" + organisationNumber +
                ", name='" + name + '\'' +
                '}';
    }
}
