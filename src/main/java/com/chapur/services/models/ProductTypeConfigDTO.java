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
public class ProductTypeConfigDTO {

    /**
     * Show product name or not.
     */
    @JsonProperty("showProductName")
    Boolean showProductName;

    /**
     * Show image or not.
     */
    @JsonProperty("showImage")
    Boolean showImage;

    /**
     * Show color or not.
     */
    @JsonProperty("showColor")
    Boolean showColor;

    /**
     * Show folio or not.
     */
    @JsonProperty("showFolio")
    Boolean showFolio;

    /**
     * Show balance or not.
     */
    @JsonProperty("showBalance")
    Boolean showBalance;

    /**
     * Show code or not.
     */
    @JsonProperty("showCode")
    Boolean showCode;

    /**
     * Show count down timer or not.
     */
    @JsonProperty("showCountDownTimer")
    Boolean showCountDownTimer;

    /**
     * Show resume account or not.
     */
    @JsonProperty("showResumeAccount")
    Boolean showResumeAccount;

    /**
     * ShowVigency or not.
     */
    @JsonProperty("showVigency")
    Boolean showVigency;

    /**
     * Show movement or not.
     */
    @JsonProperty("showMovement")
    Boolean showMovement;
}