package com.chapur.services.models.migration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqBody {
    @JsonProperty("sOperacion")
    String sOperacion;

    @JsonProperty("sTipoDatos")
    String sTipoDatos;

    @JsonProperty("sTarjeta")
    String sTarjeta;

    @JsonProperty("sToken")
    String sToken;

    @JsonProperty("fcorte")
    String fcorte;

}