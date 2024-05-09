package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product type dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTypeDTO {
    /**
     * The Type product id.
     */
    @NotNull(message = "productTypeId is mandatory")
    @JsonProperty ("productTypeId")
    Integer productTypeId;

    /**
     * The Type product.
     */
    @NotNull(message = "productType is mandatory")
    @JsonProperty ("productType")
    String productType;

    /**
     * The Config.
     */
    @NotNull(message = "config is mandatory")
    @JsonProperty ("config")
    ProductTypeConfigDTO config;

}

