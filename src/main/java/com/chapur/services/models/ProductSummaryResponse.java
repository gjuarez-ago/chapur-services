package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Product summary response.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductSummaryResponse {
    /**
     * The Product id.
     */
    @NotNull(message = "productId is mandatory")
    @JsonProperty("productId")
    Integer productId;

    /**
     * The Product type.
     */
    @JsonProperty("productType")
    String productType;

    /**
     * The Previous balance.
     */
    @JsonProperty("previousBalance")
    Float previousBalance;

    /**
     * The Balance return.
     */
    @JsonProperty("balanceReturn")
    Float balanceReturn;

    /**
     * The Spent.
     */
    @JsonProperty("spent")
    Float spent;

    /**
     * The Balance.
     */
    @JsonProperty("balance")
    Float balance;

}
