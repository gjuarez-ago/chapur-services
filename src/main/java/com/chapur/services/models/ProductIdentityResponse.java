package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductIdentityResponse {
    @JsonProperty("code")
    String code;

    @JsonProperty("expire")
    String expire;

    @JsonProperty("vigency")
    String vigency;

    @JsonProperty("generateQR")
    String generateQR;

}
