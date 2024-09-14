package co.edu.udea.securecheck.adapter.driving.rest.service.impl;

import co.edu.udea.securecheck.adapter.driving.rest.dto.request.UserRequest;
import co.edu.udea.securecheck.adapter.driving.rest.dto.response.RegisterResponse;
import co.edu.udea.securecheck.adapter.driving.rest.mapper.request.UserRequestMapper;
import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.model.Role;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.utils.Constants;
import co.edu.udea.securecheck.domain.utils.enums.RoleName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthenticationServiceImplTest {

    @Mock
    private UserServicePort userServicePort;

    @Mock
    private UserRequestMapper userRequestMapper;

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerAuditor() {
        // Define mock variables
        RegisterResponse registerResponse = RegisterResponse.builder()
                .message(String.format(Constants.AUDITOR_REGISTERED_MESSAGE,
                        "admin", "admin", "admin@admin.com")).build();
        UserRequest userRequest = UserRequest.builder()
                .name("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .birthdate(LocalDateTime.MIN)
                .identityDocument("0000000001")
                .phone("+573332223232")
                .password("password")
                .build();
        User mockUser = new User( null, "admin", "admin", "0000000001", LocalDateTime.MIN, "+573332223232", "admin@admin.com", "password", null, null);
        User returnedMockUser = new User( null, "admin", "admin", "0000000001", LocalDateTime.MIN, "+573332223232", "admin@admin.com", "password", new Role(null, RoleName.ADMIN), null);
        // Define what should happen
        when(userRequestMapper.toDomain(userRequest)).thenReturn(mockUser);
        when(userServicePort.save(any())).thenReturn(returnedMockUser);

        // Test
        RegisterResponse actualRegisterResponse = authenticationService.registerAuditor(userRequest);

        // Verify
        verify(userServicePort).save(any());
        assertNotNull(actualRegisterResponse);
        assertEquals(registerResponse, actualRegisterResponse);
    }
}