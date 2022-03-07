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
     * This highlights a problem with the object model - a Charity can have many CharityAnnualReturnPartA's, but we
     * only need the "latestSubmitted" row in this instance. So we fetch the CharityAnnualReturnPartA first, then
     * grab the associated Charity. Probably a better way to do this :)
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
            charity.setAnnualReturnPartA(annualReturn);
            charities.add(charity);
        }

        return charities;
    }
}
