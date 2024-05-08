package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    @NotNull(message = "cardId is mandatory")
    @JsonProperty("cardId")
    String cardId;

    @NotNull(message = "movementType is mandatory")
    @JsonProperty("movementType")
    String movementType;

    @NotNull(message = "user is mandatory")
    @JsonProperty("user")
    String user;

    @NotNull(message = "source is mandatory")
    @JsonProperty("source")
    String source;
}
