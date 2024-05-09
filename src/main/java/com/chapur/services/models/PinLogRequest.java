package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Pin log request.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PinLogRequest {
//    {
//        "clientId": 130923,
//            "cardId": 485732,
//            "movementType": "Asignado",
//            "user": "ricardo.ibarra@chapur.com.mx",
//            "source": "web"
//    }


    /**
     * The Client id.
     */
    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    /**
     * The Card id.
     */
    @NotNull(message = "cardId is mandatory")
    @JsonProperty("cardId")
    String cardId;

    /**
     * The Movement type.
     */
    @NotNull(message = "movementType is mandatory")
    @JsonProperty("movementType")
    String movementType;

    /**
     * The User.
     */
    @NotNull(message = "user is mandatory")
    @JsonProperty("user")
    String user;

    /**
     * The Source.
     */
    @NotNull(message = "source is mandatory")
    @JsonProperty("source")
    String source;
}
