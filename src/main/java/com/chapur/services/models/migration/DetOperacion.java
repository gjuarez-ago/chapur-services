package com.chapur.services.models.migration;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Det operacion.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetOperacion {

    /**
     * The Det operacion list.
     */
    @JsonProperty("DetOperacion")
    List<ReqBody> detOperacionList;
}