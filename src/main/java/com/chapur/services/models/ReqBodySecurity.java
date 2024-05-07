package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqBodySecurity {

        @JsonProperty("clientId")
        String clientId;

        @JsonProperty("contactMethod")
        String contactMethod;

        @JsonProperty("messageType")
        String messageType;

        @JsonProperty("messageContent")
        String messageContent;

        @JsonProperty("verificationCode")
        String verificationCode;

        @JsonProperty("pin")
        String pin;

        @JsonProperty("pinConfirmed")
        String pinConfirmed;

        @JsonProperty("cardId")
        String cardId;

        @JsonProperty("expiry")
        String expiry;

        @JsonProperty("movementType")
        String movementType;
        
        @JsonProperty("user")
        String user;

        @JsonProperty("source")
        String source;


}
