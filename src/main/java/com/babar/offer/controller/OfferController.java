package com.babar.offer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author babar
 * @since 2/2/18.
 */
@Controller
@RequestMapping
public class OfferController {

    @RequestMapping
    public String create() {
        return "test";
    }
}
