package com.babar.offer.service;

import com.babar.offer.domain.Offer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Offer> getAllOffers() {
        return em.createQuery("FROM Offer o", Offer.class).getResultList();
    }

    @Transactional
    public void saveOrUpdate(Offer offer) {
        if (offer.getId() == 0) {
            em.persist(offer);
        } else {
            em.merge(offer);
        }
    }

    @Transactional
    public void update(Offer offer) {
        em.merge(offer);
    }
}
