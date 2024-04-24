package com.chapur.services.models.migration;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetOperacion {

    @JsonProperty("DetOperacion")
    List<ReqBody> detOperacionList;
}