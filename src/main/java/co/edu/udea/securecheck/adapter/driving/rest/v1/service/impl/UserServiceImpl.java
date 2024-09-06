package co.edu.udea.securecheck.adapter.driving.rest.v1.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.UserResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.request.UserRequestMapper;
import co.edu.udea.securecheck.adapter.driving.rest.v1.mapper.response.UserResponseMapper;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.UserService;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.model.Role;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.utils.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public UserResponse registerAuditor(UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        user.setRole(new Role(null, RoleName.AUDITOR));
        return registerUser(user);
    }

    private UserResponse registerUser(User user) {
        User savedUser = userServicePort.save(user);
        return userResponseMapper.toResponse(savedUser);
    }
}
