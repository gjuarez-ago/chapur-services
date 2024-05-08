package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSummary {
    @NotNull(message = "productId is mandatory")
    @JsonProperty("productId")
    Integer productId;

    @JsonProperty("productType")
    String productType;

    @JsonProperty("previousBalance")
    Float previousBalance;

    @JsonProperty("balanceReturn")
    Float balanceReturn;

    @JsonProperty("spent")
    Float spent;

    @JsonProperty("balance")
    Float balance;

}
