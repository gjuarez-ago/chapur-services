package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PinFormRequest {

    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    @NotNull(message = "pin is mandatory")
    @JsonProperty("pin")
    String pin;

    @NotNull(message = "pinConfirmed is mandatory")
    @JsonProperty("pinConfirmed")
    String pinConfirmed;

    @NotNull(message = "cardId is mandatory")
    @JsonProperty("cardId")
    String cardId;

}
