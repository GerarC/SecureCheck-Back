package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.User;

public interface UserPersistencePort {
    User save(User user);
    boolean existsByEmail(String email);
    boolean existsByIdentityDocument(String identityDocument);
}
