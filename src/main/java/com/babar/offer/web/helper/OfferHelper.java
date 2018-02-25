package com.babar.offer.web.helper;

import com.babar.offer.domain.Offer;
import com.babar.offer.service.CommonService;
import com.babar.offer.web.model.OfferCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author sherlock
 * @since 2/9/18.
 */
@Component
public class OfferHelper {

    private static final String IMAGES_FOLDER = "/images/";

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

    public String processUploadedImage(MultipartFile file) {
        String imageLocation = IMAGES_FOLDER;

        if (file != null && !file.isEmpty()) {
            try {
                imageLocation = imageLocation + System.currentTimeMillis() + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                Path path = Paths.get(imageLocation);
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return imageLocation;
    }
}
