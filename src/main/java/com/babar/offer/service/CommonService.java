package com.babar.offer.service;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.Login;
import com.babar.offer.domain.Offer;
import com.babar.offer.domain.OfferType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    @Transactional
    public void saveOrUpdateCompany(Company company) {
        if (company.getId() == 0) {
            em.persist(company);
        } else {
            em.merge(company);
        }
    }

    @Transactional
    public void deleteCompany(Company company) {
        em.remove(company);
    }

    public Login findLogin(int id) {
        return em.find(Login.class, id);
    }

    public OfferType findOfferType(int id) {
        return em.find(OfferType.class, id);
    }

    public List<OfferType> getAllOfferTypes() {
        return em.createQuery("FROM OfferType ot", OfferType.class).getResultList();
    }

    @Transactional
    public void saveOrUpdateOfferType(OfferType offerType) {
        if (offerType.getId() == 0) {
            em.persist(offerType);
        } else {
            em.merge(offerType);
        }
    }

    @Transactional
    public void deleteOfferType(OfferType offerType) {
        em.remove(offerType);
    }
}
