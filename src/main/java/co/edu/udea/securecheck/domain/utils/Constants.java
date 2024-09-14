package co.edu.udea.securecheck.domain.utils;

@Generated
public class Constants {

    private Constants(){
        throw new IllegalStateException("Utility constants class");
    }

    // Registered Message
    public static final String AUDITOR_REGISTERED_MESSAGE = "'%s %s' with '%s' email has been registered";

    // Empty messages
    public static final String EMPTY_NAME_FIELD_MESSAGE = "'name' field cannot be empty";
    public static final String EMPTY_NIT_FIELD_MESSAGE = "'nit' field cannot be empty";
    public static final String EMPTY_NICK_FIELD_MESSAGE = "'nick' field cannot be empty";
    public static final String EMPTY_LASTNAME_FIELD_MESSAGE = "'lastname' field cannot be empty";
    public static final String EMPTY_IDENTITY_DOCUMENT_FIELD_MESSAGE = "'identityDocument' field cannot be empty";
    public static final String EMPTY_BIRTHDATE_FIELD_MESSAGE = "'birthdate' field cannot be empty";
    public static final String EMPTY_PHONE_FIELD_MESSAGE = "'phone' field cannot be empty";
    public static final String EMPTY_EMAIL_FIELD_MESSAGE = "'email' field cannot be empty";
    public static final String EMPTY_PASSWORD_FIELD_MESSAGE = "'password' field cannot be empty";
    public static final String EMPTY_ADDRESS_FIELD_MESSAGE = "'address' field cannot be empty";
    public static final String EMPTY_USER_ID_FIELD_MESSAGE = "'user_id' field cannot be empty";

    // Regex
    public static final String EMAIL_REGEX_RFC5322 = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public static final String PHONE_NUMBER_REGEX = "^(\\+\\d{2})?\\d{10}$";
    public static final String IDENTITY_DOCUMENT_REGEX = "^\\d{6,16}";

    // Out of bound messages
    public static final String PHONE_OUT_OF_BOUNDS_MESSAGE = "'phone' number must be between 10 and 14 chars";
    public static final String EMAIL_OUT_OF_BOUNDS_MESSAGE = "'email' must be between 7 and 255 chars";
    public static final String PASSWORD_OUT_OF_BOUNDS_MESSAGE = "'password' must be between 8 and 16 chars";
    public static final String IDENTITY_DOCUMENT_OUT_OF_BOUNDS_MESSAGE = "'identityDocument' must be between 6 and 15 chars";

    // Not valid format message
    public static final String NOT_VALID_EMAIL_MESSAGE = "invalid email";
    public static final String NOT_VALID_PHONE_NUMBER_MESSAGE = "invalid phone number";
    public static final String NOT_NUMERIC_IDENTITY_DOCUMENT_MESSAGE = "Identity document must be numerical only";

    public static final String FUTURE_BIRTH_DATE_MESSAGE = "'birthdate' field cannot be a future date";

    // Exception message
    public static final String EMAIL_ALREADY_EXISTS_MESSAGE = "A user with email '%s' already exists";
    public static final String IDENTITY_DOCUMENT_ALREADY_REGISTERED_MESSAGE = "A user with document with number '%s' is already registered";
    public static final String UNDERAGE_USER_MESSAGE = "User born '%tF' is underage";

    public static final String ENTITY_NOT_FOUND_MESSAGE = "Entity of type '%s' with id '%s' not found";
    public static final String TYPE_ATTRIBUTE_DOESNT_EXISTS_MESSAGE = "Attribute '%s' doesn't exists in '%s' type";

    public static final Integer DEFAULT_PAGE_NUMBER = 0;
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    public static final String DEFAULT_SORT_COLUMN = "id";
    public static final Boolean DEFAULT_ASCENDING = false;
}
