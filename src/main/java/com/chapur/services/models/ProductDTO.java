package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * The type Product dto.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    /**
     * The Product id.
     */
    @NotNull(message = "productId is mandatory")
    @JsonProperty("productId")
    Integer productId;

    /**
     * The Name.
     */
    @NotNull(message = "name is mandatory")
    @JsonProperty("name")
    String name;

    /**
     * The Description.
     */
    @NotNull(message = "description is mandatory")
    @JsonProperty("description")
    String description;

    /**
     * The Type product.
     */
    @NotNull(message = "productType is mandatory")
    @JsonProperty("productType")
    String productType;

    /**
     * The Product folio.
     */
    @NotNull(message = "productFolio is mandatory")
    @JsonProperty("productFolio")
    String productFolio;

    /**
     * The Sub type.
     */
    @JsonProperty("subType")
    String subType;

    /**
     * The Image.
     */
    @NotNull(message = "image is mandatory")
    @JsonProperty("image")
    String image;

    /**
     * The Reference color.
     */
    @NotNull(message = "referenceColor is mandatory")
    @JsonProperty("referenceColor")
    String referenceColor;

    /**
     * The Balance.
     */
    @JsonProperty("balance")
    Float balance;

    /**
     * The Currency.
     */
    @JsonProperty("currency")
    Float currency;

    /**
     * The Vigency.
     */
    @JsonProperty("vigency")
    Integer vigency;

    /**
     * The Expedition.
     */
    @JsonProperty("expedition")
    Date expedition;

    /**
     * The Order.
     */
    @JsonProperty("order")
    Integer order;

    /**
     * The Config.
     */
    @JsonProperty("config")
    ProductTypeConfigDTO config;

    /**
     * The Summary.
     */
    @JsonProperty("summary")
    ProductSummaryResponse summary;

    /**
     * The Movements.
     */
    @JsonProperty("movements")
    List<ProductMovementsResponse> movements;

}



