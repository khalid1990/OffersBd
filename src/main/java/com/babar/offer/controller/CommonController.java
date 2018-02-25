package com.babar.offer.controller;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.OfferType;
import com.babar.offer.service.CommonService;
import com.babar.offer.web.helper.CommonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sherlock
 * @since 2/20/18.
 */
@Controller
@RequestMapping
@SessionAttributes({CommonController.COMPANY_COMMAND, CommonController.OFFER_TYPE_COMMAND})
public class CommonController {

    private static final String COMPANY_FORM = "company-form";
    private static final String COMPANY_LIST_VIEW = "company-list-view";

    private static final String OFFER_TYPE_FORM = "offerType-form";
    private static final String OFFER_TYPE_LIST_VIEW = "offerType-list-view";

    public static final String COMPANY_COMMAND = "company";
    public static final String OFFER_TYPE_COMMAND = "offerType";

    @Autowired
    private CommonService service;

    @Autowired
    private CommonHelper helper;

    @GetMapping(value = "/company/list")
    public String listCompanies(ModelMap modelMap) {
        List<Company> companies = service.getAllCompanies();
        modelMap.put("companies", companies);

        return COMPANY_LIST_VIEW;
    }

    @GetMapping(value = "/company/create")
    public String createCompany(ModelMap modelMap) {
        modelMap.put("company", helper.createCompany());

        return COMPANY_FORM;
    }

    @GetMapping(value = "/company/edit")
    public String editCompany(@RequestParam int id, ModelMap modelMap) {
        Company company = service.findCompany(id);
        modelMap.put(COMPANY_COMMAND, company);

        return COMPANY_FORM;
    }

    @GetMapping(value = "/company/delete")
    public String deleteCompany(@RequestParam int id) {
        Company company = service.findCompany(id);
        service.deleteCompany(company);

        return "redirect:/company/delete";
    }

    @PostMapping(value = "/company/index", params = "_action_save_company")
    public String saveOrUpdateCompany(@ModelAttribute(COMPANY_COMMAND) Company company,
                                      BindingResult bindingResult) {
        service.saveOrUpdateCompany(company);

        return "redirect:/company/list";
    }

    @GetMapping(value = "/offerType/list")
    public String listOfferTypes(ModelMap modelMap) {
        List<OfferType> offerTypes = service.getAllOfferTypes();
        modelMap.put("offerTypes", offerTypes);

        return OFFER_TYPE_LIST_VIEW;
    }

    @GetMapping(value = "/offerType/create")
    public String createOfferType(ModelMap modelMap) {
        modelMap.put(OFFER_TYPE_COMMAND, helper.createOfferType());

        return OFFER_TYPE_FORM;
    }

    @GetMapping(value = "/offerType/edit")
    public String editOfferType(@RequestParam int id, ModelMap modelMap) {
        OfferType offerType = service.findOfferType(id);
        modelMap.put(OFFER_TYPE_COMMAND, offerType);

        return OFFER_TYPE_FORM;
    }

    @GetMapping(value = "/offerType/delete")
    public String deleteOfferType(@RequestParam int id) {
        OfferType offerType = service.findOfferType(id);
        service.deleteOfferType(offerType);

        return "redirect:/offerType/list";
    }

    @PostMapping(value = "/offerType/index", params = "_action_save_offerType")
    public String saveOrUpdateOfferType(@ModelAttribute(OFFER_TYPE_COMMAND) OfferType offerType) {
        service.saveOrUpdateOfferType(offerType);

        return "redirect:/offerType/list";
    }
}
