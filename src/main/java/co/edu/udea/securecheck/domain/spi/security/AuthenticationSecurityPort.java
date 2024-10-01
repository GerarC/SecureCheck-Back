package co.edu.udea.securecheck.domain.spi.security;

import co.edu.udea.securecheck.domain.utils.AuthenticationInfo;

public interface AuthenticationSecurityPort {
    public void authenticate(AuthenticationInfo authenticationInfo);
}
