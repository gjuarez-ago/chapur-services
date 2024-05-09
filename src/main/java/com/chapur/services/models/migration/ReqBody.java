package com.chapur.services.models.migration;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Req body.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqBody {
    /**
     * The S operacion.
     */
    @JsonProperty("sOperacion")
    String sOperacion;

    /**
     * The S tipo datos.
     */
    @JsonProperty("sTipoDatos")
    String sTipoDatos;

    /**
     * The S tarjeta.
     */
    @JsonProperty("sTarjeta")
    String sTarjeta;

    /**
     * The S token.
     */
    @JsonProperty("sToken")
    String sToken;

    /**
     * The Fcorte.
     */
    @JsonProperty("fcorte")
    String fcorte;

}