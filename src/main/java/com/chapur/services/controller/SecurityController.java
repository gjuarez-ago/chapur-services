package com.chapur.services.controller;


import com.chapur.services.models.*;
import com.chapur.services.service.impl.SecurityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
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

    private final int STACK_TRACE_METHOD_INDEX=1;
    /**
     * The Method name.
     */
    String methodName ;

    /**
     * Gets client beneficiaries.
     *
     * @param clientId the client id
     * @return the client beneficiaries
     * @throws IllegalStateException the illegal state exception
     */
    @GetMapping(value="/client-beneficiaries/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getClientBeneficiaries(@PathVariable("clientId") String clientId)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.getClientBeneficiaries(clientId);

    }


    /**
     * Generate verification code string.
     *
     * @param clientId the client id
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/generate-verification-code/{clientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String generateVerificationCode(@PathVariable("clientId") String clientId)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.generateVerificationCode(clientId);
    }


    /**
     * Send message string.
     *
     * @param clientId the client id
     * @param reqBody  the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/send-message/{clientId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendMessage(@PathVariable("clientId") String clientId,
                              @Validated @RequestBody SendMessageRequest reqBody)
            throws IllegalStateException {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.sendMessage(clientId, reqBody.getContactMethod(),
                                            reqBody.getMessageType(),reqBody.getMessageContent());
    }


    /**
     * Validate verification code string.
     *
     * @param reqBody the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/validate-verification-code", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validateVerificationCode(@Validated @RequestBody ValidateVerificationCodeRequest reqBody)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.validateVerificationCode(reqBody.getClientId(), reqBody.getVerificationCode());
    }

    /**
     * Assign pin string.
     *
     * @param reqBody the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/assign-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String assignPin(@Validated @RequestBody PinFormRequest reqBody)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.assignPin(reqBody.getPin(),reqBody.getClientId(),reqBody.getCardId());
    }

    /**
     * Validate pin string.
     *
     * @param reqBody the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/validate-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String validatePin(@Validated @RequestBody PinFormRequest reqBody)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.validatePin(reqBody.getPin(),reqBody.getClientId(),reqBody.getCardId());
    }

    /**
     * Gets pin.
     *
     * @param clientId       the client id
     * @param lastFourDigits the last four digits
     * @return the pin
     * @throws IllegalStateException the illegal state exception
     */
    @GetMapping(value="/get-pin/{clientId}/{lastFourDigits}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPin(@PathVariable("clientId")String clientId,@PathVariable("lastFourDigits")String lastFourDigits )
            throws IllegalStateException{
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.getPin(clientId,lastFourDigits);
    }

    /**
     * Edit pin string.
     *
     * @param reqBody the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PutMapping(value="/edit-pin", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String editPin(@Validated @RequestBody PinFormRequest reqBody)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return securityService.editPin(reqBody.getPin(),reqBody.getClientId(),reqBody.getCardId());
    }

    /**
     * Add pin log string.
     *
     * @param reqBody the req body
     * @return the string
     * @throws IllegalStateException the illegal state exception
     */
    @PostMapping(value="/add-pin-log", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String addPinLog(@Validated @RequestBody PinLogRequest reqBody)
            throws IllegalStateException{

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  securityService.addPinLog(reqBody.getClientId(),
                                            reqBody.getCardId(),
                                            reqBody.getMovementType(),
                                            LocalDateTime.now(),
                                            reqBody.getUser(),
                                            reqBody.getSource());
    }


}