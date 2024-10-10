package co.edu.udea.securecheck.domain.usecase.security;

import co.edu.udea.securecheck.domain.api.security.AuthenticationServicePort;
import co.edu.udea.securecheck.domain.exceptions.EntityNotFoundException;
import co.edu.udea.securecheck.domain.model.TokenHolder;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.security.AuthenticationSecurityPort;
import co.edu.udea.securecheck.domain.spi.security.TokenSecurityPort;
import co.edu.udea.securecheck.domain.spi.persistence.UserPersistencePort;
import co.edu.udea.securecheck.domain.utils.AuthenticationInfo;
import co.edu.udea.securecheck.domain.utils.Constants;

public class AuthenticationUseCase implements AuthenticationServicePort {
    private final TokenSecurityPort tokenSecurityPort;
    private final AuthenticationSecurityPort authenticationSecurityPort;
    private final UserPersistencePort userPersistencePort;

    public AuthenticationUseCase(TokenSecurityPort tokenSecurityPort, AuthenticationSecurityPort authenticationSecurityPort, UserPersistencePort userPersistencePort) {
        this.tokenSecurityPort = tokenSecurityPort;
        this.authenticationSecurityPort = authenticationSecurityPort;
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public TokenHolder authenticate(String email, String password) {
        User user = userPersistencePort.getUserByEmail(email);
        if (user == null) throw new EntityNotFoundException(
                String.format(Constants.USER_WITH_EMAIL_NOT_FOUND_MESSAGE, email)
        );

        AuthenticationInfo info = buildInfo(user, password);

        authenticationSecurityPort.authenticate(info);

        return tokenSecurityPort.createToken(user);
    }

    private AuthenticationInfo buildInfo(User user, String password) {
        return AuthenticationInfo.builder()
                .id(user.getId())
                .password(password)
                .build();
    }
}