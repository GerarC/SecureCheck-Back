package co.edu.udea.securecheck.domain.usecase;

import co.edu.udea.securecheck.domain.api.QuestionServicePort;
import co.edu.udea.securecheck.domain.exceptions.EntityNotFoundException;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.Question;
import co.edu.udea.securecheck.domain.spi.CompanyPersistencePort;
import co.edu.udea.securecheck.domain.spi.ControlPersistencePort;
import co.edu.udea.securecheck.domain.spi.CustomQuestionPersistencePort;

public class QuestionUseCase implements QuestionServicePort {

    private final CustomQuestionPersistencePort customQuestionPersistencePort;
    private final ControlPersistencePort controlPersistencePort;
    private final CompanyPersistencePort companyPersistencePort;

    public QuestionUseCase(CustomQuestionPersistencePort customQuestionPersistencePort, ControlPersistencePort controlPersistencePort, CompanyPersistencePort companyPersistencePort) {
        this.customQuestionPersistencePort = customQuestionPersistencePort;
        this.controlPersistencePort = controlPersistencePort;
        this.companyPersistencePort = companyPersistencePort;
    }

    @Override
    public Question save(Question question) {
        if(!controlPersistencePort.existsById(question.getControl().getId()))
            throw new EntityNotFoundException(Control.class.getSimpleName(), question.getControl().getId().toString());
        if(!companyPersistencePort.existsById(question.getCompany().getId()))
            throw new EntityNotFoundException(Company.class.getSimpleName(), question.getCompany().getId());
        return customQuestionPersistencePort.save(question);
    }
}
