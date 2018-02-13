package com.babar.offer.web.model;

import com.babar.offer.domain.Offer;

/**
 * @author sherlock
 * @since 2/8/18.
 */
public class OfferCommand {

    private static final long serialVersionUID = 1L;

    private Offer offer;

    public OfferCommand(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
