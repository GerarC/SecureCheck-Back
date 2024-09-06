package co.edu.udea.securecheck.configuration.advice;

import co.edu.udea.securecheck.configuration.advice.responses.ExceptionResponse;
import co.edu.udea.securecheck.configuration.advice.responses.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionAdvisor {

    private ExceptionResponse createExceptionResponse(HttpStatus status, String message) {
        return ExceptionResponse.builder()
                .statusCode(status.value())
                .status(status)
                .timestamp(LocalDateTime.now())
                .message(message).build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleRuntimeException(RuntimeException e) {
        String message = e.getMessage() == null ? e.getClass().getSimpleName() : e.getMessage();
        ExceptionResponse exceptionResponse = createExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
        return ResponseEntity.status(exceptionResponse.getStatusCode()).body(exceptionResponse);
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(HttpMessageConversionException e) {
        ExceptionResponse exceptionResponse = createExceptionResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.status(exceptionResponse.getStatusCode()).body(exceptionResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ValidationExceptionResponse exceptionResponse = ValidationExceptionResponse.builder()
                .statusCode(e.getStatusCode().value())
                .status(HttpStatus.resolve(e.getStatusCode().value()))
                .timestamp(LocalDateTime.now())
                .errors(e.getFieldErrors().stream().map(field -> {
                    StringBuilder sb = new StringBuilder();
                    String rejectedValue = field.getRejectedValue() == null ? "null" : field.getRejectedValue().toString();
                    sb.append(field.getDefaultMessage()).append(": ").append(rejectedValue);
                    return sb.toString();
                }).toList())
                .message(e.getBody().getDetail()).build();
        return ResponseEntity.status(exceptionResponse.getStatusCode()).body(exceptionResponse);
    }

}


