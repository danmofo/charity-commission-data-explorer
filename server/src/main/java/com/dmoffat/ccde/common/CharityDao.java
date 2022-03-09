package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import org.springframework.stereotype.Repository;

@Repository
public class CharityDao extends HibernateDao<Charity, Integer> {
}
