package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.Question;

import java.util.List;

public interface CompanyPersistencePort {
    Company createCompany(Company company);
    Company getCompany(String id);
    boolean existsById(String id);
    void deleteCompany(String id);
    List<Question> getCompanyQuestions(String id);
}
