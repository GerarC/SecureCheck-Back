package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.exceptions.EmailAlreadyExistsException;
import co.edu.udea.securecheck.domain.exceptions.IdentityDocumentAlreadyExistsException;
import co.edu.udea.securecheck.domain.exceptions.UnderageUserException;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.UserPersistencePort;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserUseCase implements UserServicePort {
    private final UserPersistencePort userPersistencePort;

    public UserUseCase(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User save(User user) {
        validateUser(user);
        return userPersistencePort.save(user);
    }

    private void validateUser(User user) {
        if (user.getBirthdate().until(LocalDateTime.now(), ChronoUnit.YEARS) < 18)
            throw new UnderageUserException(user.getBirthdate());
        if (userPersistencePort.existsByEmail(user.getEmail()))
            throw new EmailAlreadyExistsException(user.getEmail());
        if (userPersistencePort.existsByIdentityDocument(user.getIdentityDocument()))
            throw new IdentityDocumentAlreadyExistsException(user.getIdentityDocument());
    }
}
