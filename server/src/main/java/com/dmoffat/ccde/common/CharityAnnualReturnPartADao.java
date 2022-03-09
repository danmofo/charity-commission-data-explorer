package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import com.dmoffat.ccde.charities.CharityAnnualReturnPartA;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /**
     * We fetch from this end so we can do it in one query. If we queried from the Charity entity, e.g.
     * "from Charity c join fetch c.annualReturns..." the pagination gets done in memory and is reallly slow. 
     */
    public List<Charity> listByTopIncome() {
        Query query = entityManager.createQuery(
            "from CharityAnnualReturnPartA carpa " +
            "join fetch carpa.charity " +
            "where carpa.latestSubmitted = 1 " +
            "order by carpa.totalGrossIncome desc"
        );
        query.setMaxResults(10);

        List<CharityAnnualReturnPartA> results = getResultList(query);
        if(results.isEmpty()) {
            return Collections.emptyList();
        }

        List<Charity> charities = new ArrayList<>();

        for(CharityAnnualReturnPartA annualReturn : results) {
            Charity charity = annualReturn.getCharity();
            charity.setAnnualReturns(Collections.singletonList(annualReturn));
            charities.add(charity);
        }

        return charities;
    }
}
