package co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.request;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.configuration.utils.GeneratedMapper;
import co.edu.udea.securecheck.domain.model.User;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(GeneratedMapper.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toDomain(UserRequest userRequest);
    List<User> toDomains(List<UserRequest> userRequests);
}
