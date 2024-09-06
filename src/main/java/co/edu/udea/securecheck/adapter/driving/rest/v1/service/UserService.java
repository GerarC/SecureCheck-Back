package co.edu.udea.securecheck.adapter.driving.rest.v1.service;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.UserResponse;

public interface UserService {
    UserResponse registerAuditor(UserRequest userRequest);
}
