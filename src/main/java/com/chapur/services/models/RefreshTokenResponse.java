package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponse {

    @JsonProperty("sToken")
    private String sToken;

    @JsonProperty("sTokenExpire")
    private String sTokenExpire;

    private String tokenSpring;

    private String refreshTokenSpring;

}
