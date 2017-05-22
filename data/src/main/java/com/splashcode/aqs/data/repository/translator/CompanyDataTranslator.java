package com.splashcode.aqs.data.repository.translator;

import com.splashcode.aqs.data.database.model.UserDatabaseObject;
import com.splashcode.aqs.data.http.response.CompanyResponse;
import com.splashcode.aqs.domain.object.Company;
import com.splashcode.aqs.domain.object.builder.CompanyBuilder;

/**
 * Translate backend company responses to domain readable object.
 */
public class CompanyDataTranslator {
    Company fromHttpResponse(final CompanyResponse company) {
        return new CompanyBuilder().setCompanyName(company.companyName)
                .setCompanyCatchPhrase(company.companyCatchPhrase)
                .setCompanyBaseLine(company.companyBaseLine).createCompany();
    }

    Company fromDatabaseObject(final UserDatabaseObject userDatabaseObject) {

        return new CompanyBuilder().setCompanyName(userDatabaseObject.companyName)
                .setCompanyCatchPhrase(userDatabaseObject.companyCatchPhrase)
                .setCompanyBaseLine(userDatabaseObject.companyBaseLine).createCompany();

    }
}
