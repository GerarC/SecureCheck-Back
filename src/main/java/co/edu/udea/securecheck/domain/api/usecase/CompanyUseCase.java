package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.CompanyServicePort;
import co.edu.udea.securecheck.domain.exceptions.EntityNotFoundException;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.CompanyPersistencePort;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;

import java.time.LocalDateTime;

public class CompanyUseCase implements CompanyServicePort {
    private final CompanyPersistencePort companyPersistencePort;
    private final UserPersistencePort userPersistencePort;

    public CompanyUseCase(CompanyPersistencePort companyPersistencePort, UserPersistencePort userPersistencePort) {
        this.companyPersistencePort = companyPersistencePort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public Company createCompany(Company company) {
        // Ensure that in that user doesn't exist the same nit nor nick
        if(!userPersistencePort.existsById(company.getUser().getId()))
            throw new EntityNotFoundException(User.class.getSimpleName(), company.getUser().getId());
        company.setCreatedAt(LocalDateTime.now());
        return companyPersistencePort.createCompany(company);
    }
}
