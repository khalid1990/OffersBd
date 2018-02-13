package com.babar.offer.web.helper;

import com.babar.offer.domain.Offer;
import com.babar.offer.web.model.OfferCommand;
import org.springframework.stereotype.Component;

/**
 * @author sherlock
 * @since 2/9/18.
 */
@Component
public class OfferHelper {

    public OfferCommand createOfferCommand() {
        Offer offer = new Offer();

        return new OfferCommand(offer);
    }
}
