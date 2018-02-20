package com.babar.offer.service;

import com.babar.offer.domain.Offer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author sherlock
 * @since 2/20/18.
 */
@Repository
public class OfferService {

    @PersistenceContext
    private EntityManager em;

    public Offer findOffer(int id) {
        return em.find(Offer.class, id);
    }

    @Transactional
    public void save(Offer offer) {
        em.persist(offer);
    }

    @Transactional
    public void update(Offer offer) {
        em.merge(offer);
    }
}
