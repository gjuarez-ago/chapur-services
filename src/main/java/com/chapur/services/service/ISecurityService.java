package com.chapur.services.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public interface ISecurityService {

    String getClientBeneficiaries(String clientId);
    String generateVerificationCode(String clientId);
    String sendMessage(String clientId, String contactMethod, String messageType, String messageContent);
    String validateVerificationCode(String clientId,String verificationCode);
    String assignPin(String pin, String clientId, String cardId);
    String validatePin(String pin, String clientId, String cardId);
    String getPin(String clientId, String lastFourDigits);
    String editPin(String newPin, String clientId, String cardId);
    String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user, String source);



}
