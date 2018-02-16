package com.babar.offer.domain.editors;

import com.babar.offer.domain.Company;
import com.babar.offer.service.CommonService;

import java.beans.PropertyEditorSupport;

/**
 * @author sherlock
 * @since 2/13/18.
 */
public class CompanyEditor extends PropertyEditorSupport {

    private CommonService commonService;

    public CompanyEditor(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public String getAsText() {
        Company company = (Company) getValue();

        if (company != null) {
            int companyId = company.getId();
            return String.valueOf(companyId);
        }

        return "";
    }

    @Override
    public void setAsText(String text) {

        int companyId = Integer.parseInt(text);
        Company company = commonService.findCompany(companyId);
        setValue(company);
    }
}
