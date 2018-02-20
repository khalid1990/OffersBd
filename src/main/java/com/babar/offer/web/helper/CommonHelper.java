package com.babar.offer.web.helper;

import com.babar.offer.domain.Company;
import com.babar.offer.domain.OfferType;
import org.springframework.stereotype.Component;

/**
 * @author sherlock
 * @since 2/20/18.
 */
@Component
public class CommonHelper {

    public Company createCompany() {
        return new Company();
    }

    public OfferType createOfferType() {
        return new OfferType();
    }

}
