package com.chapur.services.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginComplementResponse {

    private int numiden;
    private String nombre;

    @JsonProperty("ult_cont")
    private String ultCont;

    private int cvetar;

    @JsonProperty("tar_activo")
    private String tarActivo;

    @JsonProperty("fecha_alta")
    private String fechaAlta;

    private String email;

    private String telefono;

    private String pregunta;
    @JsonProperty("respuesta_clave")

    private String respuestaClave;

    private int cv;

    private int promo;

    private int norecordar;

    @JsonProperty("idweb_periodo")
    private int idwebPeriodo;

    private int estado;

    @JsonProperty("id_pregunta")
    private int idPregunta;

    @JsonProperty("mailpromo")
    private String mailPromo;

    private int notificacion;

    private String fechavigencia;

    private int privacidad;

    private int tipoemision;

    @JsonProperty("fecha_corte")
    private String fechaCorte;

    @JsonProperty("idtipocliente")
    private int idTipoCliente;

    private String tipocliente;

    @JsonProperty("numero_tarjeta")
    private String numeroTarjeta;

    private int situacion;

    @JsonProperty("conekta_id")
    private String conektaId;

    @JsonProperty("fcm_token")
    private String fcmToken;

    private int numcorte;

    @JsonProperty("idtipotarjeta")
    private int idTipoTarjeta;

    private int usuarioacess;

}
