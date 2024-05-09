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
    /**
     * The Show product name.
     */
    @JsonProperty ("showProductName")
    Boolean showProductName;

    /**
     * The Show image.
     */
    @JsonProperty ("showImage")
    Boolean showImage;

    /**
     * The Show color.
     */
    @JsonProperty ("showColor")
    Boolean showColor;

    /**
     * The Show folio.
     */
    @JsonProperty ("showFolio")
    Boolean showFolio;

    /**
     * The Show balance.
     */
    @JsonProperty ("showBalance")
    Boolean showBalance;

    /**
     * The Show code.
     */
    @JsonProperty ("showCode")
    Boolean showCode;

    /**
     * The Show count down timer.
     */
    @JsonProperty ("showCountDownTimer")
    Boolean showCountDownTimer;

    /**
     * The Show resume account.
     */
    @JsonProperty ("showResumeAccount")
    Boolean showResumeAccount;

    /**
     * The Showvigency.
     */
    @JsonProperty ("showvigency")
    Boolean showvigency;

    /**
     * The Show movement.
     */
    @JsonProperty ("showMovement")
    Boolean showMovement;
}