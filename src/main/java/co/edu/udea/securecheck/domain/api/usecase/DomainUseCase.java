package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.DomainServicePort;
import co.edu.udea.securecheck.domain.model.Domain;
import co.edu.udea.securecheck.domain.spi.DomainPersistencePort;

import java.util.List;

public class DomainUseCase implements DomainServicePort {
    private final DomainPersistencePort domainPersistencePort;

    public DomainUseCase(DomainPersistencePort domainPersistencePort) {
        this.domainPersistencePort = domainPersistencePort;
    }

    @Override
    public List<Domain> getDomains() {
        return domainPersistencePort.getDomains();
    }
}
