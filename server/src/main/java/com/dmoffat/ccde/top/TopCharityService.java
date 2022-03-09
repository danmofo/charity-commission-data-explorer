package com.dmoffat.ccde.top;

import com.dmoffat.ccde.charities.Charity;
import com.dmoffat.ccde.common.CharityAnnualReturnPartADao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopCharityService {
    private final CharityAnnualReturnPartADao charityAnnualReturnPartADao;

    @Autowired
    public TopCharityService(CharityAnnualReturnPartADao charityAnnualReturnPartADao) {
        this.charityAnnualReturnPartADao = charityAnnualReturnPartADao;
    }

    public List<Charity> listByTopIncome() {
        return charityAnnualReturnPartADao.listByTopIncome();
    }
}
