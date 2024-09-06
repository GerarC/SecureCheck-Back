package co.edu.udea.securecheck.domain.exceptions;

import co.edu.udea.securecheck.domain.utils.Constants;

public class IdentityDocumentAlreadyExistsException extends RuntimeException {
    public IdentityDocumentAlreadyExistsException(String document) {
        super(String.format(Constants.IDENTITY_DOCUMENT_ALREADY_REGISTERED_MESSAGE, document));
    }
}
