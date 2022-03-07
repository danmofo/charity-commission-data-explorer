package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        charity.setAnnualReturnPartA(charityAnnualReturnPartADao.findLatestByOrganisationNumber(organisationNumber));
        return charity;
    }

    public List<Charity> list() {
        return charityDao.list();
    }
}
