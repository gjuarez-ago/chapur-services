package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMovementsList {
    @JsonProperty("productMovements")
    List<ProductMovements> productMovements;
}
