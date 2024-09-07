package co.edu.udea.securecheck.adapter.driven.jpa.mapper;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.DomainEntity;
import co.edu.udea.securecheck.domain.model.Domain;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DomainEntityMapper {
    Domain toDomain(DomainEntity domainEntity);
    List<Domain> toDomains(List<DomainEntity> domainEntities);
    DomainEntity toEntity(Domain domain);
    List<DomainEntity> toEntities(List<Domain> domains);
}