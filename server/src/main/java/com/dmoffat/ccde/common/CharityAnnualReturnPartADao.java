package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.CharityAnnualReturnPartA;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class CharityAnnualReturnPartADao extends HibernateDao<CharityAnnualReturnPartA, Integer> {
    public CharityAnnualReturnPartA findLatestByOrganisationNumber(Integer organisationNumber) {
        Query query = entityManager.createQuery(
            "from CharityAnnualReturnPartA carpa " +
            "where " +
                "carpa.organisationNumber = :organisationNumber and " +
                "carpa.latestSubmitted = 1"
        );
        query.setParameter("organisationNumber", organisationNumber);

        return getSingleResult(query);
    }
}
