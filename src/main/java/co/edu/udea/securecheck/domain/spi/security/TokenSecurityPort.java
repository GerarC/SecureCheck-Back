package co.edu.udea.securecheck.domain.spi.security;

import co.edu.udea.securecheck.domain.model.TokenHolder;
import co.edu.udea.securecheck.domain.model.User;

public interface TokenSecurityPort {
    TokenHolder createToken(User user);
    boolean validateToken(String token, String username);
    String getUsername(String token);
}
