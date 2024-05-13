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
    @NotNull(message = "typeProductId is mandatory")
    @JsonProperty ("typeProductId")
    Integer typeProductId;

    /**
     * The Type product.
     */
    @NotNull(message = "typeProduct is mandatory")
    @JsonProperty ("typeProduct")
    String typeProduct;

    /**
     * The Config.
     */
    @NotNull(message = "config is mandatory")
    @JsonProperty ("config")
    ProductTypeConfig config;

}

