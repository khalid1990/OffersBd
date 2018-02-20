package com.babar.offer.system;

import com.babar.offer.domain.Login;
import com.babar.offer.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sherlock
 * @since 2/20/18.
 */
public class UserContext {

    private CommonService commonService;

    public static Login getLoggedInUser() {
        return new Login();
    }
}
