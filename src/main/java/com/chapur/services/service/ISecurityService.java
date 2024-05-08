package com.chapur.services.service;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public interface ISecurityService {

    String getClientBeneficiaries(String clientId);

    String generateVerificationCode(String clientId);

    String sendMessage(String clientId, String contactMethod, String messageType, String messageContent);

    String validateVerificationCode(String verificationCode);

    String assignPin(String pin, String clientId, String cardId);

    String validatePin(String pin, String clientId, String cardId);

    // String getPin(String cardId, String clientId);

    String editPin(String newPin, String clientId, String cardId);

    String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user,
            String source);

}
