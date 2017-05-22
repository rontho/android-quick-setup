package com.splashcode.aqs.domain.object;

/**
 * Domain object for a Company
 */

public class Company {
    private String companyName;
    private String companyCatchPhrase;
    private String companyBaseLine;

    public Company(final String companyName, final String companyCatchPhrase, final String companyBaseLine) {
        this.companyName = companyName;
        this.companyCatchPhrase = companyCatchPhrase;
        this.companyBaseLine = companyBaseLine;
    }
}
