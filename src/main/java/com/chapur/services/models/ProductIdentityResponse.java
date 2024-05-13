package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product identity response.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductIdentityResponse {
    /**
     * The Code.
     */
    @JsonProperty("code")
    String code;

    /**
     * The Expire.
     */
    @JsonProperty("expire")
    String expire;

    /**
     * The Vigency.
     */
    @JsonProperty("vigency")
    String vigency;

    /**
     * The Generate qr.
     */
    @JsonProperty("generateQR")
    String generateQR;

}
