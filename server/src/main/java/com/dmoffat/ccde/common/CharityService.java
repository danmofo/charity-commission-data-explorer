package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharityService {
    private final CharityDao charityDao;

    @Autowired
    public CharityService(CharityDao charityDao) {
        this.charityDao = charityDao;
    }

    public List<Charity> list() {
        return charityDao.list();
    }
}
