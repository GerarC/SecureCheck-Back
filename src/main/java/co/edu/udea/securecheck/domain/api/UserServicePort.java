package co.edu.udea.securecheck.domain.api;

import co.edu.udea.securecheck.domain.model.User;

public interface UserServicePort {
    User save(User user);
}
