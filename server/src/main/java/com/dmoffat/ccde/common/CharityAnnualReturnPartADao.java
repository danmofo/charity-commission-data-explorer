package com.dmoffat.ccde.common;

import com.dmoffat.ccde.charities.Charity;
import com.dmoffat.ccde.charities.CharityAnnualReturn;
import com.dmoffat.ccde.charities.CharityAnnualReturnPartA;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class CharityAnnualReturnPartADao extends HibernateDao<CharityAnnualReturnPartA, Integer> {
    private static final String SALARY_BAND_SQL = "(" +
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
            "   ) as salary_range_start," +
            "   (" +
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
            "   ) as salary_range_end ";

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
     *
     * Another way would be to fetch the charities with the highest total income and query the charity table with
     * their IDs.
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

    public List<CharityAnnualReturn> findSummaryByOrganisationNumber(Integer organisationNumber) {
        Query query = entityManager.createNativeQuery(
            "select " +
            "   fin_period_start_date," +
            "   fin_period_end_date," +
            "   total_gross_income," +
            "   income_from_government_contracts," +
            "   income_from_government_grants," +
            "   total_gross_expenditure," +
            SALARY_BAND_SQL +
            "from charity_commission.charity_annual_return_parta carp " +
            "where organisation_number = :organisationNumber",
            CharityAnnualReturn.class
        );

        query.setParameter("organisationNumber", organisationNumber);

        return (List<CharityAnnualReturn>) query.getResultList();
    }

    public List<Charity> listByTopSalary() {
        // Note: This query is really slow, server takes around 500ms to reply, vs 10ms without the sort.
        // So this is possible place for optimisation in the future.
        Query query = entityManager.createQuery(
            "from CharityAnnualReturnPartA carpa " +
            "join fetch carpa.charity " +
            "where carpa.latestSubmitted = 1 " +
            "order by carpa.salaryRangeStart desc"
        );
        query.setMaxResults(50);

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
