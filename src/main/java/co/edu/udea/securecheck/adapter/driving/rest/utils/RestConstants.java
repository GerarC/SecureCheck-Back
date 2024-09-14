package co.edu.udea.securecheck.adapter.driving.rest.utils;

public class RestConstants {
    private RestConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CODE_OK = "200";
    public static final String CODE_CREATED = "201";
    public static final String CODE_ACCEPTED = "202";
    public static final String CODE_BAD_REQUEST = "400";
    public static final String CODE_NOT_FOUND= "404";
    public static final String CODE_CONFLICT = "409";

    public static final String SWAGGER_VALIDATIONS_FAILED = "Validations have failed";

    public static final String SWAGGER_REGISTER_AUDITOR_SUMMARY = "Register a new auditor";
    public static final String SWAGGER_REGISTER_AUDITOR_SUCCESSFUL = "Auditor has been registered successfully";
    public static final String SWAGGER_REGISTER_AUDITOR_CONFLICT = "There's a conflict with given information, i.e., email or document is already registered, or User is under aged";

    public static final String SWAGGER_GET_ALL_DOMAIN_SUMMARY = "Return a domain list";
    public static final String SWAGGER_GET_ALL_DOMAIN_SUCCESSFUL = "A list with all domains";
    public static final String SWAGGER_GET_DOMAIN_CONTROLS_SUMMARY = "Search controls of a domain";
    public static final String SWAGGER_GET_DOMAIN_CONTROLS_SUCCESSFUL = "A list with the found controls";
    public static final String SWAGGER_GET_DOMAIN_NOT_FOUND = "Domain not found";

    public static final String SWAGGER_GET_ALL_CONTROL_SUMMARY = "Return a control page, depending on the query";
    public static final String SWAGGER_GET_ALL_CONTROL_SUCCESSFUL = "A bunch of controls controls";

    public static final String SWAGGER_HOME_END_POINT = "Endpoint to test if API is working";

}
