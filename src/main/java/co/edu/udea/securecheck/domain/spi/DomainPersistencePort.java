package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.Domain;

import java.util.List;

public interface DomainPersistencePort {
    List<Domain> getDomains();
}
