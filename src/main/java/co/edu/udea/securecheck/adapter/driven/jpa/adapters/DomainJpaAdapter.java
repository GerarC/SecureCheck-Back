package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.mapper.DomainEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.DomainRepository;
import co.edu.udea.securecheck.domain.model.Domain;
import co.edu.udea.securecheck.domain.spi.DomainPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DomainJpaAdapter implements DomainPersistencePort {

    private final DomainRepository domainRepository;
    private final DomainEntityMapper domainEntityMapper;

    @Override
    public List<Domain> getDomains() {
        return domainEntityMapper.toDomains(domainRepository.findAll());
    }
}
