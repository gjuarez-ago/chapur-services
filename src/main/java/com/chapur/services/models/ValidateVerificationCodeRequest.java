package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateVerificationCodeRequest {
    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    @NotNull(message = "verificationCode is mandatory")
    @JsonProperty("verificationCode")
    String verificationCode;

}
