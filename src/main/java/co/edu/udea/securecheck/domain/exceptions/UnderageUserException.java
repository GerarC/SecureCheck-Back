package co.edu.udea.securecheck.domain.exceptions;

import co.edu.udea.securecheck.domain.utils.Constants;

import java.time.LocalDateTime;

public class UnderageUserException extends RuntimeException {
    public UnderageUserException(LocalDateTime birthdate) {
        super(String.format(Constants.UNDERAGE_USER_MESSAGE, birthdate));
    }
}
