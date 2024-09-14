package co.edu.udea.securecheck.domain.api;

import co.edu.udea.securecheck.domain.model.Company;

public interface CompanyServicePort {
    Company createCompany(Company company);
    Company getCompany(String companyId);
    Company deleteCompany(String companyId);
}
