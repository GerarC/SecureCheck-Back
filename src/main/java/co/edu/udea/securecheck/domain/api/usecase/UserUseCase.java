package co.edu.udea.securecheck.domain.api.usecase;

import co.edu.udea.securecheck.domain.api.UserServicePort;
import co.edu.udea.securecheck.domain.exceptions.EmailAlreadyExistsException;
import co.edu.udea.securecheck.domain.exceptions.IdentityDocumentAlreadyExistsException;
import co.edu.udea.securecheck.domain.exceptions.UnderageUserException;
import co.edu.udea.securecheck.domain.model.User;
import co.edu.udea.securecheck.domain.spi.UserPersitencePort;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserUseCase implements UserServicePort {
    private final UserPersitencePort userPersitencePort;

    public UserUseCase(UserPersitencePort userPersitencePort) {
        this.userPersitencePort = userPersitencePort;
    }

    @Override
    public User save(User user) {
        validateUser(user);
        return userPersitencePort.save(user);
    }

    private void validateUser(User user) {
        if (user.getBirthdate().until(LocalDateTime.now(), ChronoUnit.YEARS) < 18)
            throw new UnderageUserException(user.getBirthdate());
        if (userPersitencePort.existsByEmail(user.getEmail()))
            throw new EmailAlreadyExistsException(user.getEmail());
        if (userPersitencePort.existsByIdentityDocument(user.getIdentityDocument()))
            throw new IdentityDocumentAlreadyExistsException(user.getIdentityDocument());
    }
}
