package co.edu.udea.securecheck.adapter.driving.rest.v1.service;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse registerAuditor(UserRequest userRequest);
}
