package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMovements {
    @JsonProperty("folio")
    String folio;

    @JsonProperty("total")
    Float total;

    @JsonProperty("quantity")
    Integer quantity;

    @JsonProperty("description")
    String description;
}
