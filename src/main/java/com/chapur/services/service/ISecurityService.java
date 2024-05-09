package com.chapur.services.service;

import com.chapur.services.exception.GenericException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;
import java.time.LocalDateTime;


/**
 * The interface Security service.
 */
@Component
public interface ISecurityService {

    /**
     * Gets client beneficiaries.
     *
     * @param clientId the client id
     * @return the client beneficiaries
     */
    String getClientBeneficiaries(String clientId);

    /**
     * Generate verification code string.
     *
     * @param clientId the client id
     * @return the string
     */
    String generateVerificationCode(String clientId) ;

    /**
     * Send message string.
     *
     * @param clientId       the client id
     * @param contactMethod  the contact method
     * @param messageType    the message type
     * @param messageContent the message content
     * @return the string
     */
    String sendMessage(String clientId, String contactMethod, String messageType, String messageContent);

    /**
     * Validate verification code string.
     *
     * @param clientId         the client id
     * @param verificationCode the verification code
     * @return the string
     */
    String validateVerificationCode(String clientId,String verificationCode);

    /**
     * Assign pin string.
     *
     * @param pin      the pin
     * @param clientId the client id
     * @param cardId   the card id
     * @return the string
     */
    String assignPin(String pin, String clientId, String cardId) ;

    /**
     * Validate pin string.
     *
     * @param pin      the pin
     * @param clientId the client id
     * @param cardId   the card id
     * @return the string
     */
    String validatePin(String pin, String clientId, String cardId);

    /**
     * Gets pin.
     *
     * @param clientId       the client id
     * @param lastFourDigits the last four digits
     * @return the pin
     */
    String getPin(String clientId, String lastFourDigits) ;

    /**
     * Edit pin string.
     *
     * @param newPin   the new pin
     * @param clientId the client id
     * @param cardId   the card id
     * @return the string
     */
    String editPin(String newPin, String clientId, String cardId);

    /**
     * Add pin log string.
     *
     * @param clientId     the client id
     * @param cardId       the card id
     * @param movementType the movement type
     * @param date         the date
     * @param user         the user
     * @param source       the source
     * @return the string
     */
    String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user, String source);



}
