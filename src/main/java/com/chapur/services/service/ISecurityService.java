package com.chapur.services.service;

import com.chapur.services.exception.GenericException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;


@Component
public interface ISecurityService {

    String getClientBeneficiaries(String clientId) throws URISyntaxException, IOException;

    String generateVerificationCode(String clientId)throws URISyntaxException, IOException;

    String sendMessage(String clientId, String contactMethod, String messageType, String messageContent) throws URISyntaxException, IOException;

    String validateVerificationCode(String clientId,String verificationCode)throws URISyntaxException, IOException;

    String assignPin(String pin, String clientId, String cardId)throws URISyntaxException, IOException;

    String validatePin(String pin, String clientId, String cardId) throws URISyntaxException, IOException;

    String getPin(String clientId, String lastFourDigits) throws URISyntaxException, IOException;

    String editPin(String newPin, String clientId, String cardId)throws URISyntaxException, IOException;

    String addPinLog(String clientId, String cardId, String movementType, LocalDateTime date, String user, String source) throws URISyntaxException, IOException;



}
