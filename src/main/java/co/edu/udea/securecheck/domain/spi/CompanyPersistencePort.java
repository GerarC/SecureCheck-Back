package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Company;

public interface CompanyPersistencePort {
    Company createCompany(Company company);
    Company getCompany(String companyId);
}
