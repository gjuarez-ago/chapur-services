package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMessageRequest {

    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    @NotNull(message = "contactMethod is mandatory")
    @JsonProperty("contactMethod")
    String contactMethod;

    @NotNull(message = "messageType is mandatory")
    @JsonProperty("messageType")
    String messageType;

    @NotNull(message = "messageContent is mandatory")
    @JsonProperty("messageContent")
    String messageContent;

}
