package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.UserResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserService userService;

    @PostMapping("/register/auditor")
    public ResponseEntity<UserResponse> registerAuditor(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.ok(userService.registerAuditor(userRequest));
    }
}
