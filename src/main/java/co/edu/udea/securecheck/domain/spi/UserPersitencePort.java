package co.edu.udea.securecheck.domain.spi;

import co.edu.udea.securecheck.domain.model.User;

public interface UserPersitencePort {
    User save(User user);
}
