package com.babar.offer.web.helper;

import com.babar.offer.domain.Offer;
import com.babar.offer.service.CommonService;
import com.babar.offer.web.model.OfferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * @author sherlock
 * @since 2/9/18.
 */
@Component
public class OfferHelper {

    @Autowired
    private CommonService commonService;

    public Offer createNewOffer() {
        return new Offer();
    }

    private OfferCommand createOfferCommand(Offer offer) {
        return new OfferCommand(offer);
    }

    public void populateModel (ModelMap modelMap, Offer offer) {
        modelMap.put("offerCommand", createOfferCommand(offer));

        modelMap.put("companies", commonService.getAllCompanies());
        modelMap.put("offerTypes", commonService.getAllOfferTypes());
    }
}
