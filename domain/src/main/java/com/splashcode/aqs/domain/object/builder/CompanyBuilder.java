package com.splashcode.aqs.domain.object.builder;

import com.splashcode.aqs.domain.object.Company;

/**
 * Created by troncaglia on 15/05/2017.
 */

public class CompanyBuilder {
    private String companyName;
    private String companyCatchPhrase;
    private String companyBaseLine;

    public CompanyBuilder setCompanyName(final String companyName) {
        this.companyName = companyName;
        return this;
    }

    public CompanyBuilder setCompanyCatchPhrase(final String companyCatchPhrase) {
        this.companyCatchPhrase = companyCatchPhrase;
        return this;
    }

    public CompanyBuilder setCompanyBaseLine(final String companyBaseLine) {
        this.companyBaseLine = companyBaseLine;
        return this;
    }

    public Company createCompany() {
        return new Company(companyName, companyCatchPhrase, companyBaseLine);
    }
}
