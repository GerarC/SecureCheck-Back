package co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.CompanyResponse;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.utils.Generated;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(Generated.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyResponseMapper {
    CompanyResponse toResponse(Company company);
    List<CompanyResponse> toResponses(List<Company> companies);
}
