package co.edu.udea.securecheck.domain.exceptions;

import co.edu.udea.securecheck.domain.utils.Constants;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super(String.format(Constants.EMAIL_ALREADY_EXISTS_MESSAGE, email));
    }
}
