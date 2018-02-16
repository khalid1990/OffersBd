package com.babar.offer.controller;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.editors.CompanyEditor;
import com.babar.offer.service.CommonService;
import com.babar.offer.web.helper.OfferHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author babar
 * @since 2/2/18.
 */
@Controller
@RequestMapping
@SessionAttributes(OfferController.COMMAND_NAME)
public class OfferController {

    private static final String OFFER_FORM = "offer-form";

    protected static final String COMMAND_NAME = "offerCommand";

    @Autowired
    private OfferHelper helper;

    @Autowired
    private CommonService commonService;

    @InitBinder(COMMAND_NAME)
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Company.class, new CompanyEditor(commonService));
    }

    @RequestMapping
    public String create(ModelMap modelMap) {
        helper.populateModel(modelMap, helper.createNewOffer());

        return OFFER_FORM;
    }

    @ResponseBody
    @RequestMapping("test")
    public String test(@RequestParam int id) {
        return commonService.findCompany(id).getName();
    }
}
