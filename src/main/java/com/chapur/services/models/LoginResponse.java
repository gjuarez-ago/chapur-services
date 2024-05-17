package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    private int estatus;

    private String resultado;

    private int id;

    @JsonProperty("sToken")
    private String sToken;

    @JsonProperty("sTokenExpire")
    private String sTokenExpire;

    @JsonProperty("sError")
    private String sError;

    private String tokenSpring;

    private String refreshTokenSpring;

    private LoginComplementResponse datos;

}
