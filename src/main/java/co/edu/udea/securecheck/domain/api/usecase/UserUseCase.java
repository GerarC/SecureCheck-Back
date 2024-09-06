package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.UserPersitencePort;

public class UserUseCase implements UserServicePort {
    private final UserPersitencePort userPersitencePort;

    public UserUseCase(UserPersitencePort userPersitencePort) {
        this.userPersitencePort = userPersitencePort;
    }

    @Override
    public User save(User user) {
        return userPersitencePort.save(user);
    }
}
