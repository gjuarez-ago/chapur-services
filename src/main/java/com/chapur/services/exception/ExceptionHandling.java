package com.chapur.services.exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chapur.services.models.HttpResponse;

import java.io.IOException;
import java.util.Date;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandling implements ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandling.class);

    private static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact administration";
    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request";
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request";
    private static final String INCORRECT_CREDENTIALS = "Username / password incorrect. Please try again";
    private static final String ACCOUNT_DISABLED = "Your account has been disabled. If this is an error, please contact administration";
    private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file";
    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";
    public static final String ERROR_PATH = "/error";

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(new Date(), httpStatus.value(),
                httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HttpResponse> accountDisabledException() {
        return createHttpResponse(BAD_REQUEST, ACCOUNT_DISABLED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentialsException() {
        return createHttpResponse(BAD_REQUEST, INCORRECT_CREDENTIALS);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpResponse> accessDeniedException() {
        return createHttpResponse(FORBIDDEN, NOT_ENOUGH_PERMISSION);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<HttpResponse> lockedException() {
        return createHttpResponse(UNAUTHORIZED, ACCOUNT_LOCKED);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<HttpResponse> tokenExpiredException(ExpiredJwtException exception) {
        return createHttpResponse(UNAUTHORIZED, exception.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpResponse> IOException(IOException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<HttpResponse> genericException(GenericException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage());
    }

    public String getErrorPath() {
        return ERROR_PATH;
    }
}
