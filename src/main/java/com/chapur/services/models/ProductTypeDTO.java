package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTypeRequest {
    @NotNull(message = "typeProductId is mandatory")
    @JsonProperty ("typeProductId")
    Integer typeProductId;

    @NotNull(message = "typeProduct is mandatory")
    @JsonProperty ("typeProduct")
    String typeProduct;

    @NotNull(message = "config is mandatory")
    @JsonProperty ("config")
    ProductTypeConfig config;

}

