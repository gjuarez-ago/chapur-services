package com.chapur.services.models;

import lombok.Data;

@Data
public class RefreshTokenDTO {

    private boolean isRefreshToken;

    private String email;

    private String token;

    private String tokenSpring;

    private int userId;

}
