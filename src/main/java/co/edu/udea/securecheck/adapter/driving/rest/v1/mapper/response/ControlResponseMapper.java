package co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.ControlResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.PageResponse;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.Domain;
import co.edu.udea.securecheck.domain.utils.Generated;
import co.edu.udea.securecheck.domain.utils.Pagination;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(Generated.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ControlResponseMapper {

    default Integer domainIndex(Domain domain) {
        return domain.getIndex();
    }

    ControlResponse toResponse(Control control);
    List<ControlResponse> toResponses(List<Control> controls);

    PageResponse<ControlResponse> toPageResponse(Pagination<Control> page);
}
