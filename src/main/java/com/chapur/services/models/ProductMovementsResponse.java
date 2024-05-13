package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product movements response.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMovementsResponse {
    /**
     * The Folio.
     */
    @JsonProperty("folio")
    String folio;

    /**
     * The Total.
     */
    @JsonProperty("total")
    Float total;

    /**
     * The Quantity.
     */
    @JsonProperty("quantity")
    Integer quantity;

    /**
     * The Description.
     */
    @JsonProperty("description")
    String description;
}
