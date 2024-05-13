package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * The type Product movements list.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMovementsList {
    /**
     * The Product movements.
     */
    @JsonProperty("productMovements")
    List<ProductMovements> productMovements;
}
