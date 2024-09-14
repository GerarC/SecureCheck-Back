package co.edu.udea.securecheck.adapter.driving.rest.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.RegisterResponse;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.request.UserRequestMapper;
import co.edu.udea.securecheck.adapter.driving.rest.service.AuthenticationService;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.model.Role;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.utils.Constants;
import co.edu.udea.securecheck.domain.utils.enums.RoleName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;

    @Override
    public RegisterResponse registerAuditor(UserRequest userRequest) {
        User user = userRequestMapper.toDomain(userRequest);
        user.setRole(new Role(null, RoleName.AUDITOR));
        return registerUser(user);
    }

    private RegisterResponse registerUser(User user) {
        User savedUser = userServicePort.save(user);
        return RegisterResponse.builder()
                .message(String.format(Constants.AUDITOR_REGISTERED_MESSAGE,
                        savedUser.getName(),
                        savedUser.getLastname(),
                        savedUser.getEmail()))
                .build();
    }
}
