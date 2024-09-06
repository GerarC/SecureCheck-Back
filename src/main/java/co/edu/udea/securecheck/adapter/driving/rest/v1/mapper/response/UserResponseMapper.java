package co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.UserResponse;
import co.edu.udea.securecheck.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    UserResponse toResponse(User user);
    List<UserResponse> toResponses(List<User> users);
}
