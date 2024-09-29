package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.CompanyServicePort;
import co.edu.udea.securecheck.domain.exceptions.EntityNotFoundException;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.Question;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.CompanyPersistencePort;
import co.edu.udea.securecheck.domain.spi.CustomQuestionPersistencePort;
import co.edu.udea.securecheck.domain.spi.DefaultQuestionPersistencePort;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;
import co.edu.udea.securecheck.domain.utils.StreamUtils;

import java.time.LocalDateTime;
import java.util.List;

public class CompanyUseCase implements CompanyServicePort {
    private final CompanyPersistencePort companyPersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final DefaultQuestionPersistencePort defaultQuestionPersistencePort;
    private final CustomQuestionPersistencePort customQuestionPersistencePort;

    public CompanyUseCase(CompanyPersistencePort companyPersistencePort,
                          UserPersistencePort userPersistencePort,
                          DefaultQuestionPersistencePort defaultQuestionPersistencePort,
                          CustomQuestionPersistencePort customQuestionPersistencePort) {
        this.companyPersistencePort = companyPersistencePort;
        this.userPersistencePort = userPersistencePort;
        this.defaultQuestionPersistencePort = defaultQuestionPersistencePort;
        this.customQuestionPersistencePort = customQuestionPersistencePort;
    }

    @Override
    public Company createCompany(Company company) {
        // Ensure that in that user doesn't exist the same nit nor nick
        if (!userPersistencePort.existsById(company.getUser().getId()))
            throw new EntityNotFoundException(User.class.getSimpleName(), company.getUser().getId());
        company.setCreatedAt(LocalDateTime.now());
        Company savedCompany = companyPersistencePort.createCompany(company);

        List<Question> newQuestions = createDefaultQuestions(savedCompany);
        customQuestionPersistencePort.saveAll(newQuestions);

        return savedCompany;
    }

    @Override
    public Company getCompany(String companyId) {
        Company company = companyPersistencePort.getCompany(companyId);
        if (company == null) throw new EntityNotFoundException(Company.class.getSimpleName(), companyId);
        return company;
    }

    @Override
    public Company deleteCompany(String companyId) {
        Company company = getCompany(companyId);
        companyPersistencePort.deleteCompany(companyId);
        return company;
    }

    @Override
    public List<Question> getCompanyQuestions(String companyId) {
        if (!companyPersistencePort.existsById(companyId))
            throw new EntityNotFoundException(Company.class.getSimpleName(), companyId);
        return companyPersistencePort.getCompanyQuestions(companyId);
    }

    private List<Question> createDefaultQuestions(Company company) {
        List<Question> defaultQuestions = defaultQuestionPersistencePort.getAll();
        return StreamUtils.map(defaultQuestions, question -> {
            question.setCompany(
                    Company.builder().id(company.getId()).build()
            );
            return question;
        });
    }
}
