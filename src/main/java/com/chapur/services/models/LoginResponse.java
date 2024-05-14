package com.chapur.services.models;

import lombok.Data;

@Data
public class LoginResponse {

    private int estatus;

    private String resultado;

    private int id;

    private LoginComplementResponse datos;
}
