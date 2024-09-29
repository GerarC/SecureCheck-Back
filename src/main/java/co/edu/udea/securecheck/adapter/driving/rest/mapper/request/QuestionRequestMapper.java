package co.edu.udea.securecheck.adapter.driving.rest.mapper.request;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.QuestionRequest;
import co.edu.udea.securecheck.domain.model.Company;
import co.edu.udea.securecheck.domain.model.Control;
import co.edu.udea.securecheck.domain.model.Question;
import co.edu.udea.securecheck.domain.utils.Generated;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(Generated.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionRequestMapper {

    default Control id2Control(Long id){
        return Control.builder().id(id).build();
    }

    default Company id2Company(String id){
        return Company.builder().id(id).build();
    }

    Question toDomain(QuestionRequest userRequest);
    List<Question> toDomains(List<QuestionRequest> userRequests);
}
