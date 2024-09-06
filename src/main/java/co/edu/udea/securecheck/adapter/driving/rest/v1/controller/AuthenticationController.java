package co.edu.udea.securecheck.adapter.driving.rest.v1.controller;

import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.v1.dto.response.RegisterResponse;
import co.edu.udea.securecheck.adapter.driving.rest.v1.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @Operation(summary = "Register a new auditor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Auditor has been registered successfully",
                   content = @Content(schema = @Schema(implementation = RegisterResponse.class))),
            @ApiResponse(responseCode = "400", description = "Request info is not valid", content = @Content),
            @ApiResponse(responseCode = "409", description = "There's a conflict with given information, i.e., email or document is already registered, or User is under aged", content = @Content)
    })
    @PostMapping("/register/auditor")
    public ResponseEntity<RegisterResponse> registerAuditor(@RequestBody @Valid UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerAuditor(userRequest));
    }
}
