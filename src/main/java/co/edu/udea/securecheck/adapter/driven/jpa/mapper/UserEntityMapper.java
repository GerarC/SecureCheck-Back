package co.edu.udea.securecheck.adapter.driven.jpa.mapper;

import co.edu.udea.securecheck.adapter.driven.jpa.entity.UserEntity;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.utils.Generated;
import org.mapstruct.AnnotateWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@AnnotateWith(Generated.class)
@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toDomain(UserEntity userEntity);
    List<User> toDomains(List<UserEntity> userEntities);
    UserEntity toEntity(User user);
    List<UserEntity> toEntities(List<User> users);
}
