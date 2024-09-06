package co.edu.udea.securecheck.domain.utils;

public class Constants {

    private Constants(){
        throw new IllegalStateException("Utility constants class");
    }


    // Empty messages
    public static final String EMPTY_NAME_FIELD_MESSAGE = "'name' field cannot be empty";
    public static final String EMPTY_LASTNAME_FIELD_MESSAGE = "'lastname' field cannot be empty";
    public static final String EMPTY_IDENTITY_DOCUMENT_FIELD_MESSAGE = "'identityDocument' field cannot be empty";
    public static final String EMPTY_BIRTHDATE_FIELD_MESSAGE = "'birthdate' field cannot be empty";
    public static final String EMPTY_PHONE_FIELD_MESSAGE = "'phone' field cannot be empty";
    public static final String EMPTY_EMAIL_FIELD_MESSAGE = "'email' field cannot be empty";
    public static final String EMPTY_PASSWORD_FIELD_MESSAGE = "'password' field cannot be empty";

    // Regex
    public static final String EMAIL_REGEX_RFC5322 = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String PHONE_NUMBER_REGEX = "^(\\+\\d{2})?\\d{10}$";
    public static final String IDENTITY_DOCUMENT_REGEX = "^\\d{6,16}";

    // Limits
    public static final Integer MAX_PHONE_SIZE = 14;
    public static final Integer MIN_PHONE_SIZE = 10;
    public static final Integer MAX_EMAIL_SIZE = 255;
    public static final Integer MIN_EMAIL_SIZE = 7;
    public static final Integer MAX_PASSWORD_SIZE = 15;
    public static final Integer MIN_PASSWORD_SIZE = 7;
    public static final Integer MAX_IDENTITY_DOCUMENT_SIZE = 15;
    public static final Integer MIN_IDENTITY_DOCUMENT_SIZE = 6;

    // Out of bound messages
    public static final String PHONE_OUT_OF_BOUNDS_MESSAGE = "'phone' number must be between 10 and 14 chars";
    public static final String EMAIL_OUT_OF_BOUNDS_MESSAGE = "'email' must be between 7 and 255 chars";
    public static final String PASSWORD_OUT_OF_BOUNDS_MESSAGE = "'password' must be between 7 and 15 chars";
    public static final String IDENTITY_DOCUMENT_OUT_OF_BOUNDS_MESSAGE = "'identityDocument' must be between 6 and 15 chars";

    // Not valid format message
    public static final String NOT_VALID_EMAIL_MESSAGE = "invalid email";
    public static final String NOT_VALID_PHONE_NUMBER_MESSAGE = "invalid phone number";
    public static final String NOT_NUMERIC_IDENTITY_DOCUMENT_MESSAGE = "Identity document must be numerical only";

    public static final String FUTURE_BIRTH_DATE_MESSAGE = "'birthdate' field cannot be a future date";
}
