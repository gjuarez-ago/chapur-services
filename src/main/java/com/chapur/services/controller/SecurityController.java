package com.chapur.services.controller;

import com.chapur.services.exception.GenericException;
import com.chapur.services.models.ReqBodySecurity;
import com.chapur.services.service.impl.SecurityServiceImpl;
import com.chapur.services.utils.ValidationSecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * The type Security controller.
 */
@RestController
@RequestMapping("/api/security")
@Slf4j
public class SecurityController {

    /**
     * The Security service.
     */
    @Autowired
    SecurityServiceImpl securityService;

    private final int STACK_TRACE_METHOD_INDEX = 1;
    /**
     * The Method name.
     */
    String methodName;

    /**
     * Detalle tarjeta string.
     *
     * @param clientId Parametro que almacena el id del cliente
     * @return response regresa el objeto de respuesta
     * @throws GenericException regresa un json string con la informacion del error
     *                          en caso de que se genera alguna exception
     */
    @GetMapping(value = "/client-beneficiaries/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getClientBeneficiaries(@PathVariable("clientId") String clientId) throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.getClientBeneficiaries(clientId);

    }

    /**
     * Generate verification code string.
     *
     * @param clientId the client id
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/generate-verification-code/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateVerificationCode(@PathVariable("clientId") String clientId) throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.generateVerificationCode(clientId);
    }

    /**
     * Send message string.
     *
     * @param clientId        the client id
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException                the generic exception
     * @throws MethodArgumentNotValidException the method argument not valid
     *                                         exception
     * @throws IllegalStateException           the illegal state exception
     */
    @PostMapping(value = "/send-message/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@PathVariable("clientId") String clientId,
            @Validated(ValidationSecurity.sendMessage.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException, MethodArgumentNotValidException, IllegalStateException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.sendMessage(reqBodySecurity.getClientId(), reqBodySecurity.getContactMethod(),
                reqBodySecurity.getMessageType(), reqBodySecurity.getMessageContent());
    }

    /**
     * Validate verification code string.
     *
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/validate-verification-code", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateVerificationCode(
            @Validated(ValidationSecurity.validateVerificationCode.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.validateVerificationCode(reqBodySecurity.getVerificationCode());
    }

    /**
     * Assign pin string.
     *
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/assign-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String assignPin(@Validated(ValidationSecurity.assignPin.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.assignPin(reqBodySecurity.getPin(), reqBodySecurity.getClientId(),
                reqBodySecurity.getCardId());
    }

    /**
     * Validate pin string.
     *
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/validate-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validatePin(
            @Validated(ValidationSecurity.validatePin.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.validatePin(reqBodySecurity.getPin(), reqBodySecurity.getClientId(),
                reqBodySecurity.getCardId());
    }

    // @PostMapping(value="/get-pin", consumes = MediaType.APPLICATION_JSON_VALUE,
    // produces = MediaType.APPLICATION_JSON_VALUE)
    // public String getPin(@RequestBody ReqBodySecurity reqBodySecurity) throws
    // GenericException {
    // methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
    // log.info("Executing endpoint method: "+methodName+" from class:
    // "+getClass().getName());
    // String response = methodName;
    // return response;
    // }

    /**
     * Edit pin string.
     *
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/edit-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String editPin(@Validated(ValidationSecurity.editPin.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return securityService.editPin(reqBodySecurity.getPin(), reqBodySecurity.getClientId(),
                reqBodySecurity.getCardId());
    }

    /**
     * Add pin log string.
     *
     * @param reqBodySecurity the req body security
     * @return the string
     * @throws GenericException the generic exception
     */
    @PostMapping(value = "/add-pin-log", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addPinLog(@Validated(ValidationSecurity.addPinLog.class) @RequestBody ReqBodySecurity reqBodySecurity)
            throws GenericException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        String response = "{\"methodName\":\"" + methodName + "\"}";
        return securityService.addPinLog(reqBodySecurity.getClientId(),
                reqBodySecurity.getCardId(),
                reqBodySecurity.getMovementType(),
                LocalDateTime.now(),
                reqBodySecurity.getUser(),
                reqBodySecurity.getSource());
    }

}