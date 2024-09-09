package co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.DomainResponse;
import co.edu.udea.securecheck.configuration.utils.GeneratedMapper;
import co.edu.udea.securecheck.domain.model.Domain;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(GeneratedMapper.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DomainResponseMapper {
    DomainResponse toResponse(Domain domain);
    List<DomainResponse> toResponses(List<Domain> domains);
}
