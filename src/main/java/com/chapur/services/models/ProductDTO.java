package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "productId is mandatory")
    @JsonProperty("productId")
    Integer productId;

    @NotNull(message = "name is mandatory")
    @JsonProperty("name")
    String name;

    @NotNull(message = "description is mandatory")
    @JsonProperty("description")
    String description;

    @NotNull(message = "typeProduct is mandatory")
    @JsonProperty("typeProduct")
    String typeProduct;

    @NotNull(message = "productFolio is mandatory")
    @JsonProperty("productFolio")
    String productFolio;

    @JsonProperty("subType")
    String subType;

    @NotNull(message = "image is mandatory")
    @JsonProperty("image")
    String image;

    @NotNull(message = "referenceColor is mandatory")
    @JsonProperty("referenceColor")
    String referenceColor;

    @JsonProperty("balance")
    Float balance;

    @JsonProperty("currency")
    Float currency;

    @JsonProperty("vigency")
    Integer vigency;

    @JsonProperty("expedition")
    Date expedition;

    @JsonProperty("config")
    ProductTypeConfig config;

    @JsonProperty("summary")
    ProductSummary summary;

    @JsonProperty("movements")
    ProductMovementsList movements;

}



