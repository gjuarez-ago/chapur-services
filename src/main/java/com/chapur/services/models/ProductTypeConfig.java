package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type ProductDTO type config.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTypeConfig {
    @JsonProperty ("showProductName")
    Boolean showProductName;

    @JsonProperty ("showImage")
    Boolean showImage;

    @JsonProperty ("showColor")
    Boolean showColor;

    @JsonProperty ("showFolio")
    Boolean showFolio;

    @JsonProperty ("showBalance")
    Boolean showBalance;

    @JsonProperty ("showCode")
    Boolean showCode;

    @JsonProperty ("showCountDownTimer")
    Boolean showCountDownTimer;

    @JsonProperty ("showResumeAccount")
    Boolean showResumeAccount;

    @JsonProperty ("showvigency")
    Boolean showvigency;

    @JsonProperty ("showMovement")
    Boolean showMovement;
}