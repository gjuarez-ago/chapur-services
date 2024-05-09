package com.chapur.services.service.impl;

import com.chapur.services.service.ISecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Security service.
 */
@Service
@Slf4j
public class SecurityServiceImpl implements ISecurityService {

    private final int STACK_TRACE_METHOD_INDEX = 1;

    /**
     * The Method name.
     */
    String methodName;

    @Override
    public String getClientBeneficiaries(String clientId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String generateVerificationCode(String clientId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String sendMessage(String clientId, String contactMethod, String messageType, String messageContent) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String validateVerificationCode(String clientId,String verificationCode) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String assignPin(String pin, String clientId, String cardId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String validatePin(String pin, String clientId, String cardId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String getPin(String clientId, String lastFourDigits) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: "+methodName);
        return  "{\"methodName\":\""+methodName+"\"}";
    }

    @Override
    public String editPin(String newPin, String clientId, String cardId) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }

    @Override
    public String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user,
            String source) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        methodName = stackTrace[STACK_TRACE_METHOD_INDEX].getMethodName();
        log.info("Executing Method: " + methodName);
        return "{\"methodName\":\"" + methodName + "\"}";
    }
}
