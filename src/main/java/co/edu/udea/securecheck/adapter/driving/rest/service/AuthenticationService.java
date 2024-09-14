package co.edu.udea.securecheck.adapter.driving.rest.service;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse registerAuditor(UserRequest userRequest);
}
