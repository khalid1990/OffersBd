package com.babar.offer.service;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.Login;
import com.babar.offer.domain.Offer;
import com.babar.offer.domain.OfferType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author sherlock
 * @since 2/16/18.
 */
@Repository
public class CommonService {

    @PersistenceContext
    private EntityManager em;

    public Company findCompany(int id) {
        return em.find(Company.class, id);
    }

    public List<Company> getAllCompanies() {
        return em.createQuery("FROM Company c", Company.class).getResultList();
    }

    public Login findLogin(int id) {
        return em.find(Login.class, id);
    }

    public OfferType findOfferType(int id) {
        return em.find(OfferType.class, id);
    }
    public Offer findOffer(int id) {
        return em.find(Offer.class, id);
    }
}
