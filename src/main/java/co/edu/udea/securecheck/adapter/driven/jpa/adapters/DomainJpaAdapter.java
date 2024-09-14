package co.edu.udea.securecheck.adapter.driven.jpa.adapters;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.DomainEntity;
import co.edu.udea.securecheck.adapter.driven.jpa.mapper.DomainEntityMapper;
import co.edu.udea.securecheck.adapter.driven.jpa.repository.DomainRepository;
import co.edu.udea.securecheck.adapter.driven.jpa.utils.JpaConstants;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.Domain;
import co.edu.udea.securecheck.domain.spi.DomainPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DomainJpaAdapter implements DomainPersistencePort {

    private final DomainRepository domainRepository;
    private final DomainEntityMapper domainEntityMapper;

    @Override
    public List<Domain> getDomains() {
        return domainEntityMapper.toDomains(domainRepository.findAll());
    }

    @Override
    public List<Control> getDomainControls(Long id) {
        DomainEntity domainEntity = domainRepository.findById(id).orElse(null);
        assert domainEntity != null : JpaConstants.ENTITY_SHOULD_BE_VERIFIED_IN_DOMAIN_MESSAGE;
        Domain domain = domainEntityMapper.toDomain(domainEntity);
        return domain.getControls().stream().map(control -> {
            control.setDomain(domain);
            return control;
        }).toList();
    }

    @Override
    public boolean existsById(Long id) {
        return domainRepository.existsById(id);
    }
}
