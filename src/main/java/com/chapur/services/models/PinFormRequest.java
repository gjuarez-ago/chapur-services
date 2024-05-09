package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Pin form request.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PinFormRequest {

    /**
     * The Client id.
     */
    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    /**
     * The Pin.
     */
    @NotNull(message = "pin is mandatory")
    @JsonProperty("pin")
    String pin;

    /**
     * The Pin confirmed.
     */
    @NotNull(message = "pinConfirmed is mandatory")
    @JsonProperty("pinConfirmed")
    String pinConfirmed;

    /**
     * The Card id.
     */
    @NotNull(message = "cardId is mandatory")
    @JsonProperty("cardId")
    String cardId;

}
