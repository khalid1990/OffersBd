package com.babar.offer.controller;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.Offer;
import com.babar.offer.domain.editors.CompanyEditor;
import com.babar.offer.service.CommonService;
import com.babar.offer.service.OfferService;
import com.babar.offer.web.helper.OfferHelper;
import com.babar.offer.web.model.OfferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author babar
 * @since 2/2/18.
 */
@Controller
@RequestMapping("/offer")
@SessionAttributes(OfferController.COMMAND_NAME)
public class OfferController {

    private static final String OFFER_FORM = "offer-form";

    private static final String OFFER_SHOW_FORM = "offer-show-form";

    protected static final String COMMAND_NAME = "offerCommand";

    @Autowired
    private OfferHelper helper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private OfferService offerService;

    @InitBinder(COMMAND_NAME)
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Company.class, new CompanyEditor(commonService));
    }

    @GetMapping(value = "/create")
    public String create(ModelMap modelMap) {
        helper.populateModel(modelMap, helper.createNewOffer());

        return OFFER_FORM;
    }

    @PostMapping(value = "/index", params = "_action_save")
    public String save(@ModelAttribute(COMMAND_NAME) OfferCommand command, BindingResult bindingResult) {

        String imageUrl = helper.processUploadedImage(command.getImageFile());
        Offer offer = command.getOffer();
        offer.setImageUrl(imageUrl);
        offerService.save(offer);

        return OFFER_FORM;
    }

    @GetMapping(value = "/show")
    public String show(@RequestParam int id, ModelMap modelMap) {
        Offer offer = offerService.findOffer(id);
        helper.populateModel(modelMap, offer);

        return OFFER_SHOW_FORM;
    }

    @ResponseBody
    @RequestMapping("test")
    public String test(@RequestParam int id) {
        return commonService.findCompany(id).getName();
    }
}
