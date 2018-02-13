package com.babar.offer.controller;

import com.babar.offer.web.helper.OfferHelper;
import com.babar.offer.web.model.OfferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * @author babar
 * @since 2/2/18.
 */
@Controller
@RequestMapping
public class OfferController {

    private static final String OFFER_FORM = "offer-form";

    private static final String COMMAND_NAME = "offerCommand";

    @Autowired
    private OfferHelper offerHelper;

    @RequestMapping
    public String create(ModelMap modelMap) {
        modelMap.put(COMMAND_NAME, offerHelper.createOfferCommand());

        return OFFER_FORM;
    }
}
