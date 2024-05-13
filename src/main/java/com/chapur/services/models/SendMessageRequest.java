package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Send message request.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SendMessageRequest {

    /**
     * The Client id.
     */
    @NotNull(message = "clientId is mandatory")
    @JsonProperty("clientId")
    String clientId;

    /**
     * The Contact method.
     */
    @NotNull(message = "contactMethod is mandatory")
    @JsonProperty("contactMethod")
    String contactMethod;

    /**
     * The Message type.
     */
    @NotNull(message = "messageType is mandatory")
    @JsonProperty("messageType")
    String messageType;

    /**
     * The Message content.
     */
    @NotNull(message = "messageContent is mandatory")
    @JsonProperty("messageContent")
    String messageContent;

}
