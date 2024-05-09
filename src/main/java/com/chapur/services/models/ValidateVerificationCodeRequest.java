package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Validate verification code request.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidateVerificationCodeRequest {
    /**
     * The Client id.
     */
    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    /**
     * The Verification code.
     */
    @NotNull(message = "verificationCode is mandatory")
    @JsonProperty("verificationCode")
    String verificationCode;

}
