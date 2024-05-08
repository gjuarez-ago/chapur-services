package com.chapur.services.models;

import java.util.Date;

import lombok.Data;

@Data
public class CreateServiceDTO {

    private Long id;
    /* Titulo */
    private String title;

    /* Subtitulo */
    private String subtitle;

    /* Imagen base64 o vinculo */
    private String image;

    /* link */
    private String link;

    /* order */
    private int order;

    /* Fecha limite de publicación */
    private Date expirationDate;

    // Determina si esta activo el anuncio
    private boolean isActive;

}
