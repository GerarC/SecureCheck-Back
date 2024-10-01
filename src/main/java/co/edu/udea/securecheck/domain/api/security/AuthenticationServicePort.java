package co.edu.udea.securecheck.domain.api.security;

import co.edu.udea.securecheck.domain.model.TokenHolder;

public interface AuthenticationServicePort {
    TokenHolder authenticate(String email, String password);
}
