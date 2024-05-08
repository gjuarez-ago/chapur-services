package com.chapur.services.models;

import com.chapur.services.Utils.ValidationSecurity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqBodySecurity {

        @NotNull(message = "clientId is mandatory", groups = {ValidationSecurity.sendMessage.class,
                ValidationSecurity.assignPin.class, ValidationSecurity.validatePin.class,
                ValidationSecurity.editPin.class, ValidationSecurity.addPinLog.class})
        @JsonProperty("clientId")
        String clientId;

        @NotNull(message = "contactMethod is mandatory", groups = {ValidationSecurity.sendMessage.class})
        @JsonProperty("contactMethod")
        String contactMethod;

        @NotNull(message = "messageType is mandatory", groups = {ValidationSecurity.sendMessage.class})
        @JsonProperty("messageType")
        String messageType;

        @NotNull(message = "messageContent is mandatory", groups = {ValidationSecurity.sendMessage.class})
        @JsonProperty("messageContent")
        String messageContent;

        @NotNull(message = "verificationCode is mandatory", groups = {ValidationSecurity.validateVerificationCode.class})
        @JsonProperty("verificationCode")
        String verificationCode;

        @NotNull(message = "pin is mandatory", groups = {ValidationSecurity.assignPin.class, ValidationSecurity.validatePin.class,
                ValidationSecurity.editPin.class})
        @JsonProperty("pin")
        String pin;

        @NotNull(message = "pinConfirmed is mandatory", groups = {ValidationSecurity.assignPin.class})
        @JsonProperty("pinConfirmed")
        String pinConfirmed;

        @NotNull(message = "cardId is mandatory", groups = {ValidationSecurity.assignPin.class, ValidationSecurity.validatePin.class,
                ValidationSecurity.editPin.class, ValidationSecurity.addPinLog.class})
        @JsonProperty("cardId")
        String cardId;

        @JsonProperty("expiry")
        String expiry;

        @NotNull(message = "movementType is mandatory", groups = {ValidationSecurity.addPinLog.class})
        @JsonProperty("movementType")
        String movementType;

        @NotNull(message = "user is mandatory", groups = {ValidationSecurity.addPinLog.class})
        @JsonProperty("user")
        String user;

        @NotNull(message = "source is mandatory", groups = {ValidationSecurity.addPinLog.class})
        @JsonProperty("source")
        String source;


}
