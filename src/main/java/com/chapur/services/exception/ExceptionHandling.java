package com.chapur.services.exception;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chapur.services.models.HttpResponse;

import java.io.IOException;
import java.util.Date;

import static org.springframework.http.HttpStatus.*;

/**
 * The type Exception handling.
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandling implements ErrorController {

    private static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact administration";
    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint. Please send a '%s' request";
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occurred while processing the request";
    private static final String INCORRECT_CREDENTIALS = "Username / password incorrect. Please try again";
    private static final String ACCOUNT_DISABLED = "Your account has been disabled. If this is an error, please contact administration";
    private static final String ERROR_PROCESSING_FILE = "Error occurred while processing file";
    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";
    /**
     * The constant ERROR_PATH.
     */
    public static final String ERROR_PATH = "/error";

    private ResponseEntity<HttpResponse> createHttpResponse(HttpStatus httpStatus, String message, Exception exception) {
        log.error(exception.getMessage(), exception);

        return new ResponseEntity<>(new HttpResponse(new Date(), httpStatus.value(),
                httpStatus, httpStatus.getReasonPhrase().toUpperCase(), message), httpStatus);
    }

    /**
     * Account disabled exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HttpResponse> accountDisabledException(DisabledException exception) {
        return createHttpResponse(BAD_REQUEST, ACCOUNT_DISABLED, exception);
    }

    /**
     * Exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HttpResponse> exception(Exception exception) {
        return createHttpResponse(BAD_REQUEST, exception.getClass() + ": " + exception.getMessage(), exception);
    }

    /**
     * Bad credentials exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentialsException(BadCredentialsException exception) {
        return createHttpResponse(BAD_REQUEST, INCORRECT_CREDENTIALS, exception);
    }

    /**
     * Access denied exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpResponse> accessDeniedException(AccessDeniedException exception) {
        return createHttpResponse(FORBIDDEN, NOT_ENOUGH_PERMISSION, exception);
    }

    /**
     * Locked exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(LockedException.class)
    public ResponseEntity<HttpResponse> lockedException(LockedException exception) {
        return createHttpResponse(UNAUTHORIZED, ACCOUNT_LOCKED, exception);
    }

    /**
     * Token expired exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<HttpResponse> tokenExpiredException(ExpiredJwtException exception) {
        return createHttpResponse(UNAUTHORIZED, exception.getMessage(), exception);
    }

    /**
     * Io exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(IOException.class)
    public ResponseEntity<HttpResponse> IOException(IOException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage(), exception);
    }

    /**
     * Generic exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<HttpResponse> genericException(GenericException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage(), exception);
    }

    /**
     * Method argument not valid exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpResponse> MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage(), exception);
    }

    /**
     * Illegal state exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<HttpResponse> IllegalStateException(IllegalStateException exception) {
        return createHttpResponse(BAD_REQUEST, exception.getMessage(), exception);
    }

    /**
     * Gets error path.
     *
     * @return the error path
     */
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
